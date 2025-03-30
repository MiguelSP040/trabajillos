import { useState } from 'react';
import './App.css';
import Password from './components/Password';
import UserInfo from './components/UserInfo';

function App() {
  const [isAuthenticated, setIsAuthenticated] = useState(false);

  return (
    <>
      {!isAuthenticated ? (
        <Password onLoginSuccess={() => setIsAuthenticated(true)} />
      ) : (
        <UserInfo />
      )}
    </>
  );
}

export default App;