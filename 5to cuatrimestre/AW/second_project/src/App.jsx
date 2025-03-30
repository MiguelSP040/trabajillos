import { useEffect, useState } from 'react'
import './App.css'
import axios from 'axios'

function App() {
  const [count, setCount] = useState(0)
  const [data, setData] = useState("")
  
  useEffect( () => {
    axios
    .get("https://jsonplaceholder.typicode.com/comments")
    .then( (response) => {
      console.log(response.data)
      setData(response.data[0].email)
    })
  }, [count])

  const updateButton = () => {
    setCount(count+1)
  }
  
  return (
    <div>
      <h1>Hola: {data}</h1>
      <button onClick={updateButton}> {count} Update</button>
    </div>
  )
}

export default App