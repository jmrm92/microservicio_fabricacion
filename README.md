# Fabricacion Microservicio

## Descripción

Este microservicio, desarrollado con Spring Boot, gestiona las operaciones relacionadas con los procesos de fabricación en una planta de producción. Proporciona funcionalidades para obtener detalles de fabricación, consultar costos, filtrar procesos por costos y inicializar nuevos procesos de fabricación.

## Endpoints

### GET Endpoints

- `GET /`: Retorna una lista de todos los procesos de fabricación.
- `GET /coste/{idFabricacion}`: Obtiene el costo de un proceso de fabricación específico, basado en el ID proporcionado.
- `GET /filtrar/{costeMinimo}/{costeMaximo}`: Filtra y retorna los procesos de fabricación en base a un rango de costos proporcionado.

### POST Endpoints

- `POST /{idModelo}/{cantidadModelos}`: Inicia un nuevo proceso de fabricación para un modelo específico y una cantidad determinada.

### Pasos para ejecutar

1. Clona el repositorio a tu máquina local
2. Crear base de datos MySQL si fuera necesario con las sentencias documentadas en el archivo create.sql dentro de la carpeta META-INF
3. Ejecuta `mvn spring-boot:run` para iniciar el microservicio.
4. El servicio ahora está corriendo y los endpoints pueden ser accedidos vía `localhost:9090`.

 
