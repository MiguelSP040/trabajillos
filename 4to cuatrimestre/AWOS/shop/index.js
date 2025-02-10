//1. Recuperar o instanciar las dependencias
const express = require('express');
const morgan = require('morgan');
require('dotenv').config(); //Recupera las variables de entorno del .env
const routes = [
    require('./src/modules/category/category.route')
];

//2. Crear la API
const API = express();

//3.Configurar API y los middlewares
API.set('port', process.env.API_PORT);

API.use(morgan('dev'));
//Realiza que las peticiones no vengan sobrecargadas
API.use(express.urlencoded({extended: false}));
API.use(express.json());
API.use((request, response, next) => {
    //Configuramos encabezados de la respuesta
    //Permite el acceso de todos los origenes
    response.header('Access-Control-Allow-Origins', '*');
    response.header('Access-Control-Allow-Headers', 'Accept, Content-Type, Authorization');
    //Coarse
    response.header('Access-Control-Allow-Methods', 'GET, POST, PUT, DELETE, OPTIONS');
    response.header('Allow', 'GET, POST, PUT, DELETE, OPTIONS');
    next();
});

//4. Configurar las rutas de la API
API.use(`${process.env.API_BASE}/category`, routes[0]);

//5. Deploy de la API
API.listen(API.get('port'), ()=>{
    console.log(`API corriendo en el puerto ${API.get('port')}`);
});