import { Link } from 'react-router-dom';
import '../App.css'
import 'bootstrap/dist/css/bootstrap.min.css';

function Dashboard() {
  return (
    <div className="container d-flex justify-content-center align-items-center vh-100">
      <div className="text-center">
        <h2>Bienvenido al Dashboard</h2>
        <p>Has iniciado sesión correctamente.</p>
        <Link to="/" className="btn btn-primary m-2">Cerrar sesión</Link>
        <Link to="/users/7" className="btn btn-success m-2">Ver detalles del usuario</Link>
      </div>
    </div>
  );
}

export default Dashboard;