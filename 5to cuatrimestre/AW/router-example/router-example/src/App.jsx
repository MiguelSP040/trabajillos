import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import {BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom'
import About from './pages/About';
import Profile from './pages/Profile';
import Home from './pages/Home';
import ErrorPage from './pages/ErrorPage';

function App() {
  

  return (
    <>
      {/*Contenedor de rutas*/}
      <Router>
        <nav> 
          <Link to={'/'}> Home | </Link>
          <Link to={'/profile'}> Profile | </Link>
          <Link to={'/about'}> About </Link>

        </nav>
        <Routes>
          <Route path='/'element={<Home/>}></Route>
          <Route path='/about'element={<About/>}></Route>
          <Route path='/profile/:username'element={<Profile/>}></Route>
          <Route path='*'element={<ErrorPage/>}></Route>
        </Routes>

        <div>
          <h3>Este es el footer y esta dentro del Router</h3>
        </div>
      </Router>
    </>
  )
}

export default App
