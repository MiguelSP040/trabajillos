import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [user, setUser] = useState(null)
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)

  const fetchUser = async () => {
    setLoading(true)
    setError(null)
    try {
      const response = await fetch('https://randomuser.me/api/')
      const data = await response.json()
      setUser(data.results[0])
    } catch (err) {
      setError('Error al cargar los datos del usuario', err)
    } finally {
      setLoading(false)
    }
  }

  useEffect(() => {
    fetchUser()
  }, [])

  return (
    <div className="container text-center"> 
      <h1>Información de usuario</h1>
      {loading ? (
        <p>Cargando...</p>
      ) : error ? (
        <p>{error}</p>
      ) : (
        <>
          <img src={user.picture.large} alt="imagen" />
          <p>Nombre: {`${user.name.first} ${user.name.last}`}</p>
          <p>Correo electrónico: {user.email}</p>
        </>
      )}
      <button type='button' onClick={fetchUser}>Cargar nuevo usuario</button>
    </div>
  )
}

export default App