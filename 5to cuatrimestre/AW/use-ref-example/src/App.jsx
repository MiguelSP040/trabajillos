import React, { useRef } from 'react';
import './App.css';

function App() {
  const inputRef = useRef(null);

  const updateInput = () => {
    inputRef.current.focus();  // Corrected reference
  };

  return (
    <div>
      <input type='text' placeholder='example...' ref={inputRef}></input>
      <input type='text' placeholder='example...1'></input>

      <button onClick={updateInput}>Update</button>
    </div>
  );
}

export default App;
