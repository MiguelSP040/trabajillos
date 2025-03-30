// src/components/BotonCallback.js
import React, { useCallback, useState } from 'react';

function Boton({ onClick, label }) {
  console.log('Renderizando botón:', label);
  return <button onClick={onClick}>{label}</button>;
}

const MemoBoton = React.memo(Boton);

function BotonCallback() {
  const [contador, setContador] = useState(0);

  const incrementar = useCallback(() => {
    setContador(prev => prev + 1);
  }, []);

  return (
    <div style={{ border: '1px solid #ccc', padding: '1rem', marginBottom: '1rem' }}>
      <h3>Ejemplo con useCallback</h3>
      <p>Contador: {contador}</p>
      <MemoBoton onClick={incrementar} label="Incrementar" />
    </div>
  );
}

export default BotonCallback;
