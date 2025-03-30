import React, { useEffect, useState } from "react";
import axios from "axios";

function UserInfo() {
  const [data, setData] = useState("");

  useEffect(() => {
    axios.get("http://jsonplaceholder.typicode.com/users").then((response) => {
      setData(response.data[9]);
    });
  });

  return (
    <>
      <h2>Datos del usuario:</h2>
      <p>Id: {data.id}</p>
      <p>Nombre: {data.name}</p>
      <p>Usuario: {data.username}</p>
      <p>Email: {data.email}</p>
    </>
  );
}

export default UserInfo;
