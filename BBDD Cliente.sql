------------------------------------------------------
-- AUTOR       : NTTDATA CENTERS - MÁLAGA
-- DESCRIPCIÓN : JAVA - HIBERNATE - MYSQL - TALLER 2
-- RESPONSABLE : SAMUEL CALDERÓN GONZÁLEZ
------------------------------------------------------

-- Creación de la base de datos
CREATE DATABASE IF NOT EXISTS Taller1Hibernate;

-- Uso de la base de datos
USE Taller1Hibernate;

-- Creación de la tabla Cliente
CREATE TABLE IF NOT EXISTS Cliente (
	id int primary key auto_increment,
    nombre varchar(30),
    apellido1 varchar(30),
    apellido2 varchar(30),
    dni char(9) unique
);

-- Creación de la tabla Contrato
CREATE TABLE IF NOT EXISTS Contrato (
	id int primary key auto_increment,
	fechaVigencia date,
    fechaCaducidad date,
    precioMensual decimal(16,2),
    clienteId int references cliente(id)
);