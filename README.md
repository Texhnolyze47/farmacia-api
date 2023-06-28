# Farmacia-api
Api para hacer manejo de inventario, empleados y clientes


## Endpoints

### Authentication

POST
``http://localhost:8080/api/auth/register``

Json de ejemplo 

````json
{
  "username": "luisGamer",
  "email": "luis@mail.com",
  "password": "214124124"
}
````

POST
``http://localhost:8080/api/auth/login``

### Clients

POST ``http://localhost:8080/api/client``

````json
{
  "name": "nombre",
  "correo": "correo",
  "number": "number"
}
````

GET ``http://localhost:8080/api/client``

GET ``http://localhost:8080/api/client/{clientId}``

PUT ``http://localhost:8080/api/client/{clientId}``

DELETE ``http://localhost:8080/api/client/{clientId}``

### Employee

