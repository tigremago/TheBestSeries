# TheBestSeries

## ¿Que hace este proyecto?
Este proyecto Consiste en desarrollar una API Rest utilizando Spring Boot y JPA, donde se podra gestionar Usuarios, Series y Reseñas de un sistema llamado TheBestSeries. Esta aplicacion implementa operaciones CRUD(Crear, Actualizar, Eliminar y Consultar), esta conectada a una base de datos MySQL, donde se sigue una arquitectura de capas manteniendo separacion clara de responsabilidades.

## Como iniciar el proyecto
1. Mi proyecto utiliza Visual Studio code, java JDK 17 o superior, Laragon, Heidi y Postman para que funcione esta API.

Donde descargar
- https://code.visualstudio.com/download
- https://www.heidisql.com/download.php
- https://laragon.org/download
- https://www.postman.com/downloads/

También se recomienda instalar en VS Code las extensiones:
Java Extension Pack
Spring Boot Extension Pa

1. Clonar el repositorio
Ir al repositorio de GitHub del proyecto.
Hacer clic en Code y copiar el link del repositorio.
Luego tienes dos opciones:

En Visual Studio Code abrir la terminal (Ctrl + ñ) y escribir:
git clone <link-del-repositorio>
O en VS Code usar la opción “Clone Repository” y pegar el enlace.

2. Guardar el proyecto
Selecciona una carpeta para guardar el proyecto (puede ser Descargas o una carpeta de proyectos).

3. Configurar base de datos
Abrir Laragon y activar únicamente MySQL.
Luego abrir HeidiSQL, crear una nueva conexión y abrirla.

4. Ejecutar el proyecto
Abrir el proyecto en Visual Studio Code o tu IDE favorito y ejecutar la aplicación.

Si todo está correcto:
Se iniciará el servidor en el puerto 8080
En la consola verás que Spring Boot arrancó correctamente
En HeidiSQL podrás ver la base de datos creada automáticamente

5. Probar en Postman
Abrir Postman e iniciar sesión.
Crear una Collection con el nombre que desees.
Luego empezar a probar los endpoints del proyecto, por ejemplo:

http://localhost:8080/api/usuarios

Dependiendo del controlador, deberás usar métodos como:
POST (crear)
GET (consultar)
PUT (actualizar)
DELETE (eliminar)

y enviar los datos correspondientes en formato JSON.

6. Resultado final
Si todo está bien configurado, podrás:
Crear usuarios
Crear series
Agregar reseñas
Consultar información desde la API
Ver los datos en la base de datos en tiempo real


## Datos de autor
* Nombre: Rayen Yanjari
* Correo : ra.yanjari@duocuc.cl
* Proyecto 1




