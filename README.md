# Api farmacia


## Endpoints y operaciones
### Gestión de productos

- GET /products: Obtiene una lista de todos los productos disponibles en la farmacia.
- GET /products/{id}: Obtiene los detalles de un producto específico por su ID.
- POST /products: Agrega un nuevo producto a la lista de productos disponibles.
- PUT /products/{id}: Actualiza los detalles de un producto específico por su ID.
- DELETE /products/{id}: Elimina un producto específico por su ID.

### Gestión de ventas
- GET /sales: Obtiene una lista de todas las ventas realizadas.
- GET /sales/{id}: Obtiene los detalles de una venta específica por su ID.
- POST /sales: Agrega una nueva venta al registro de ventas.

En proceso
- PUT /sales/{id}: Actualiza los detalles de una venta específica por su ID.
- DELETE /ventas/{id}: Elimina una venta específica por su ID.

### Gestión de clientes
- GET /clients: Obtiene una lista de todos los clientes registrados.
- GET /clients/{id}: Obtiene los detalles de un cliente específico por su ID.
- POST /clients: Agrega un nuevo cliente al registro de clientes.
- PUT /clients/{id}: Actualiza los detalles de un cliente específico por su ID.
- DELETE /clients/{id}: Elimina un cliente específico por su ID.

### Gestión de empleados
- GET /employees: Obtiene una lista de todos los empleados registrados.
- GET /employees/{id}: Obtiene los detalles de un empleado específico por su ID.
- POST /employees: Agrega un nuevo empleado al registro de empleados.
- PUT /employees/{id}: Actualiza los detalles de un empleado específico por su ID.
- DELETE /employees/{id}: Elimina un empleado específico por su ID.

### Otros endpoints
- GET /ping: Devuelve un mensaje para verificar que la API está disponible.
