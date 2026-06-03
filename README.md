Instalar java 17, xammp, mysql,maven

//Para Maven "Con la carpeta descomprimida y su respectiva ruta de la carpeta bin"
Presiona Win + R
Escribe:
sysdm.cpl
Ve a Opciones avanzadas
Variables de entorno
En "Variables del sistema" selecciona Path
Editar
Nuevo

Agrega:

C:\Maven\apache-maven-3.9.16\bin

Verificar mvn -version

//Archivos en VScode

Abrir en VS Code

Abre la carpeta del proyecto.

Instala las extensiones:

Extension Pack for Java
Spring Boot Extension Pack
Ejecutar

Abre una terminal en la carpeta del proyecto:

mvn spring-boot:run

Si todo está bien verás:

Started ApiApplication

Ejecutar en la terminal despues de xammp mvn spring-boot:run