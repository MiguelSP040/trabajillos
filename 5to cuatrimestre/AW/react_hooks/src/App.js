// src/App.js
import React from 'react';
import ContadorReducer from './components/ContadorReducer';
import ListaMemo from './components/ListaMemo';
import BotonCallback from './components/BotonCallback';
import MedirAncho from './components/MedirAncho';
import BuscadorTransition from './components/BuscadorTransition';

function App() {
  // Datos para ListaMemo y BuscadorTransition
  const datosLista = [
    { id: 1, nombre: 'Elemento 1', activo: true },
    { id: 2, nombre: 'Elemento 2', activo: false },
    { id: 3, nombre: 'Elemento 3', activo: true },
  ];

  const listaBuscador = [
    'Manzana',
    'Banana',
    'Cereza',
    'Dátil',
    'Elderberry',
    'Fresa',
    'Grosella',
  ];

  return (
    <div style={{ maxWidth: '800px', margin: '2rem auto', fontFamily: 'Arial, sans-serif' }}>
      <h1>Ejemplos de Hooks en React</h1>
      <ContadorReducer />
      <ListaMemo items={datosLista} />
      <BotonCallback />
      <MedirAncho />
      <BuscadorTransition lista={listaBuscador} />
    </div>
  );
}

export default App;
