CREATE DATABASE apoyo;
USE apoyo;
CREATE TABLE ALUMNO (
 id_alumno INT PRIMARY KEY,
 nombre VARCHAR(100),
 correo VARCHAR(100),
 contraseña VARCHAR(50),
 estado VARCHAR(20)
 );
 CREATE TABLE PROFESOR (
id_profesor INT PRIMARY KEY,
nombre VARCHAR(100),
 correo VARCHAR(100),
 contraseña VARCHAR(50),
 estado VARCHAR(20),
 area VARCHAR(50)
);
CREATE TABLE OPORTUNIDAD (
 id_oportunidad INT PRIMARY KEY,
 nombre VARCHAR(100),
 descripcion TEXT,
 requisitos TEXT,
 estado VARCHAR(20)
);
CREATE TABLE REGISTRO_SERVICIO (
 id_registro INT PRIMARY KEY,
 fecha_inicio DATE,
 fecha_fin DATE,
 estado VARCHAR(20),
 id_alumno INT,
 id_oportunidad INT,
 FOREIGN KEY (id_alumno) REFERENCES ALUMNO(id_alumno),
 FOREIGN KEY (id_oportunidad) REFERENCES OPORTUNIDAD(id_oportunidad)
);
CREATE TABLE ACTIVIDAD (
 id_actividad INT PRIMARY KEY,
 descripcion TEXT,
 horas INT,
 fecha DATE,
 estado VARCHAR(20),
 id_registro INT,
 FOREIGN KEY (id_registro) REFERENCES REGISTRO_SERVICIO(id_registro)
);
CREATE TABLE REPORTE (
 id_reporte INT PRIMARY KEY,
 fecha_generacion DATE,
 total_horas INT,
 id_registro INT,
 FOREIGN KEY (id_registro) REFERENCES REGISTRO_SERVICIO(id_registro)
);
CREATE TABLE MENSAJE (
 id_mensaje INT PRIMARY KEY,
 contenido TEXT,
 fecha DATE,
 id_alumno INT,
 FOREIGN KEY (id_alumno) REFERENCES ALUMNO(id_alumno)
);