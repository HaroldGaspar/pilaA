USE master
GO
CREATE DATABASE IsilDb
GO
USE IsilDb
GO
CREATE TABLE Producto(
                         Id INT IDENTITY(1,1) NOT NULL,
                         Nombre VARCHAR(30) NOT NULL,
                         Descripcion VARCHAR(50) NOT NULL,
                         Precio DECIMAL(10,2)  NOT NULL,
                         Stock INT NOT NULL
)

CREATE TABLE Libro(
                      Id INT IDENTITY(1,1) NOT NULL,
                      Nombre VARCHAR(30) NOT NULL,
                      Descripcicon VARCHAR(50) NOT NULL,
                      Autor VARCHAR(30) NOT NULL,
                      Editorial VARCHAR(30) NOT NULL,
                      Precio DECIMAL(10,2) NOT NULL,
                      Stock INT NOT NULL
)
