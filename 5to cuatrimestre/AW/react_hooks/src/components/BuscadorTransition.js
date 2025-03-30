// src/components/BuscadorTransition.js
import React, { useState, useTransition } from 'react';

function BuscadorTransition({ lista }) {
  const [busqueda, setBusqueda] = useState('');
  const [isPending, startTransition] = useTransition();
  const [resultados, setResultados] = useState(lista);

  const manejarCambio = (e) => {
    const valor = e.target.value;
    setBusqueda(valor);
    startTransition(() => {
      const filtrados = lista.filter(item =>
        item.toLowerCase().includes(valor.toLowerCase())
      );
      setResultados(filtrados);
    });
  };

  return (
    <div style={{ border: '1px solid #ccc', padding: '1rem', marginBottom: '1rem' }}>
      <h3>Buscador con useTransition</h3>
      <input 
        type="text" 
        value={busqueda} 
        onChange={manejarCambio} 
        placeholder="Buscar..."
        style={{ padding: '0.5rem', width: '100%', marginBottom: '1rem' }}
      />
      {isPending && <p>Cargando...</p>}
      <ul>
        {resultados.map((item, idx) => (
          <li key={idx}>{item}</li>
        ))}
      </ul>
    </div>
  );
}

export default BuscadorTransition;
