import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import '../App.css'
import 'bootstrap/dist/css/bootstrap.min.css';

function UserDetails() {
  const { id } = useParams();
  const [user, setUser] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch(`https://jsonplaceholder.typicode.com/users/${id}`)
      .then((response) => {
        if (!response.ok) {
          throw new Error('Error al cargr los datos');
        }
        return response.json();
      })
      .then((data) => {
        setUser(data);
        setLoading(false);
      })
      .catch((error) => {
        setError(error);
        setLoading(false);
      });
  }, [id]);

  if (loading) {
    return <div className="text-center mt-5"><div className="spinner-border" role="status"><span className="sr-only">Cargando...</span></div></div>;
  }

  if (error) {
    return <div className="alert alert-danger text-center mt-5" role="alert">Error: {error.message}</div>;
  }

  return (
    <div className="container mt-5">
      <h2 className="text-center mb-4">Detalles del Usuario</h2>
      {user && (
        <div className="card">
          <div className="card-body">
            <p className="card-text"><strong>Nombre:</strong> {user.name}</p>
            <p className="card-text"><strong>Correo:</strong> {user.email}</p>
            <p className="card-text"><strong>Teléfono:</strong> {user.phone}</p>
            <p className="card-text"><strong>Website:</strong> {user.website}</p>
          </div>
        </div>
      )}
    </div>
  );
}

export default UserDetails;