import React, { useState } from 'react';

function Password({ onLoginSuccess }) {
  const [password, setPassword] = useState('');
  const correctPassword = '1234';

  const validate = (e) => {
    e.preventDefault(); 
    if (password === correctPassword) {
      onLoginSuccess();
    } else {
      console.error('Contraseña incorrecta');
    }
  };

  return (
    <form onSubmit={validate}>
      <label>Password:</label>
      <br />
      <input
        type='password'
        placeholder='Ingrese la contraseña'
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />
      <button type="submit">Login</button>
    </form>
  );
}

export default Password;
