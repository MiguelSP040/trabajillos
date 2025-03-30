import { createContext, useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "/vite.svg";
import "./App.css";
import UserComponent from "./components/UserComponent";
import Login from "./components/Login";
import User from "./components/User";
import React from "react";

const AppContext = createContext(null)

function App() {
  const [count, setCount] = useState(0);
  const [username, setUsername] = useState("Miguel")

  return (
    <>
      <AppContext.Provider value={{username,setUsername}}>
        
      
      {/*<UserComponent name={"Miguel"} email={"miguel.ansp23@gmail.com"} />
      <UserComponent name={"Aly"} email={"aly"} />*/}

      <Login setUsername={setUsername}/>
      <User username={username}/>
      </AppContext.Provider>
    </>
  );
}

export default App;
export {AppContext};