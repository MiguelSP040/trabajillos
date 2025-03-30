// src/components/MedirAncho.js
import React, { useLayoutEffect, useRef, useState } from 'react';

function MedirAncho() {
  const divRef = useRef();
  const [ancho, setAncho] = useState(0);

  useLayoutEffect(() => {
    if (divRef.current) {
      setAncho(divRef.current.getBoundingClientRect().width);
    }
  }, []);

  return (
    <div style={{ border: '1px solid #ccc', padding: '1rem', marginBottom: '1rem' }}>
      <h3>Medir Ancho con useLayoutEffect</h3>
      <div ref={divRef} style={{ width: '50%', backgroundColor: '#f0f0f0', padding: '0.5rem' }}>
        Contenido para medir
      </div>
      <p>Ancho del div: {ancho}px</p>
    </div>
  );
}

export default MedirAncho;
