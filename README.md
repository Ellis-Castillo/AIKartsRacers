CineApp — AIKartsRacers
Aplicación full-stack de gestión de películas por géneros, desarrollada como proyecto final del módulo de desarrollo web.
Tecnologías
Capa
Tecnología
Frontend
Angular 21 (Standalone Components, Signals, Reactive Forms)
Backend
Java + Spring Boot 4
Base de datos
H2 en memoria
Build backend
Maven (mvnw)



Estructura del proyecto
AIKartsRacers/

├── backend/

│   └── cineapp/          ← API REST con Spring Boot

├── frontend/

│   └── cine-app/         ← App Angular

└── README.md


Cómo arrancar
Backend
cd backend/cineapp

./mvnw spring-boot:run

El backend arranca en: http://localhost:8080

La consola H2 (base de datos) está disponible en: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:cinedb
Usuario: sa
Contraseña: (vacía)
Frontend
cd frontend/cine-app

npm install

ng serve

La app arranca en: http://localhost:4200

Arranca el backend antes que el frontend.


Endpoints API
Géneros
Método
Endpoint
Descripción
GET
/api/generos
Lista todos los géneros
GET
/api/generos/{id}
Detalle de un género
POST
/api/generos
Crear nuevo género
DELETE
/api/generos/{id}
Eliminar un género

Películas
Método
Endpoint
Descripción
GET
/api/peliculas
Lista todas las películas
GET
/api/peliculas/{id}
Detalle de una película
GET
/api/peliculas/genero/{id}
Películas de un género
POST
/api/peliculas
Crear nueva película
DELETE
/api/peliculas/{id}
Eliminar una película



Modelo de datos
Genero
{

  "id": 1,

  "nombre": "Acción",

  "descripcion": "Películas llenas de adrenalina"

}
Pelicula
{

  "id": 1,

  "titulo": "Mad Max",

  "anio": 2015,

  "director": "George Miller",

  "sinopsis": "Un hombre lucha por sobrevivir en un mundo post-apocalíptico",

  "genero": { "id": 1, "nombre": "Acción" }

}


Datos de ejemplo
El proyecto incluye datos precargados automáticamente al arrancar (data.sql):

Géneros: Acción, Comedia, Terror, Ciencia Ficción

Películas: Mad Max, John Wick, Superbad, El Conjuro, Interstellar


Relación entre entidades
Genero (1) ──────── (N) Pelicula

Un género puede tener muchas películas. Cada película pertenece a un único género.
