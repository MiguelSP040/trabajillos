const mysql = require('mysql2/promise');
require('dotenv').config();

const pool = mysql.createPool({
    host: process.env.DB_HOST,
    port: process.env.DB_PORT,
    database: process.env.DB_NAME,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD
});

pool.getConnection((error, connection) => {
    if(error){
        console.log(`Error en la conexión de base de datos: ${error}`);
    }

    if(connection){
        connection.release();
        return;
    }
});

module.exports = pool;