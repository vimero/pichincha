# sofka-challenge

## Base Datos
La creacion de base datos se realiza con los scripts de inicializacion en cada uno de los 
microservicios en la ruta $MS/src/main/resources/db/migration.

## Instalacion

```
docker-compose up -d
```

## Pruebas

Exportar los archivos de la carpeta postman para realizar las pruebas y ejecutar con los siguientes pasos:

1. Crear un customer [POST] http://localhost:8080/api/v1/customers
   Este endpoint creara un customer y account por defecto de manera asincronica.

2. Crear un movimiento [POST] http://localhost:8082/api/v1/movements
   Este endpoint creara un movimiento

3. Verificar los reportes
   [GET] http://localhost:8082/api/v1/customers/1/movements/json?from=10/03/2025&to=12/03/2025
   [GET] http://localhost:8082/api/v1/customers/1/movements?from=10/03/2025&to=12/03/2025
   Estos 2 enpoints mostraran los reports de movimientos con un rango de fechas y en 2 formatos.

4. Crear un account [POST]http://localhost:8082/api/v1/accounts
   Este endpoint permitira crear una account.
