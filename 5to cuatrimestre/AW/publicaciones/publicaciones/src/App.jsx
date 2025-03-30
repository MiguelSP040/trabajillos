import { useState, useEffect } from 'react'
import './App.css'

function App() {
  const [posts, setPosts] = useState([])
  const [error, setError] = useState(null)
  const [visiblePost, setVisiblePost] = useState(null)

  const showInfo = async () => {
    try {
      const response = await fetch('https://jsonplaceholder.typicode.com/posts?_limit=5')
      const data = await response.json()
      setPosts(data)
    } catch (error) {
      setError("Ha ocurrido un error al cargar la información", error)
      console.log(error);
    }
  }

  useEffect(() => {
    showInfo()
  }, [])

  const togglePostVisibility = (postId) => {
    setVisiblePost(visiblePost === postId ? null : postId)
  }

  return (
    <div>
      <h3>Publicaciones:</h3>
      {error && <p>{error}</p>}
      <ul>
        {posts.map(post => (
          <li key={post.id}>
            <h4 onClick={() => togglePostVisibility(post.id)}>{post.title}</h4>
            {visiblePost === post.id && <p>{post.body}</p>}
          </li>
        ))}
      </ul>
    </div>
  )
}

export default App