import React from 'react'
import {useNavigate, useParams} from 'react-router-dom'

export default function Profile() {
    let { username } = useParams()
    const navigate = useNavigate()
    return (
        <div>
            <h1>Esta es la pagina Profile {username}</h1>
            <button onClick={() => {
                navigate('/about')
            }}>Ir a Home</button>
        </div>
    )
}
