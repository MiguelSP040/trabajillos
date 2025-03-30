// src/components/ListaMemo.js
import React, { useMemo } from 'react';

function ListaMemo({ items }) {
  const itemsFiltrados = useMemo(() => {
    return items.filter(item => item.activo);
  }, [items]);
  
  return (
    <div style={{ border: '1px solid #ccc', padding: '1rem', marginBottom: '1rem' }}>
      <h3>Lista Filtrada con useMemo</h3>
      <ul>
        {itemsFiltrados.map(item => (
          <li key={item.id}>{item.nombre}</li>
        ))}
      </ul>
    </div>
  );
}

export default ListaMemo;
