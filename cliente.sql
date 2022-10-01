/*.........................1°..........................................*/

create database  clientes;

/*.........................2°..........................................*/
CREATE TABLE distrito(
    id int primary key auto_increment,
    nombre varchar(30),
    descripcion varchar(30)
);

INSERT INTO clientes.distrito(nombre,descripcion)VALUES ('La Victoria', ' ');
INSERT INTO clientes.distrito(nombre ,descripcion)VALUES ('El Agustino', ' ');
INSERT INTO clientes.distrito(nombre,descripcion)VALUES ('Comas', ' ');
INSERT INTO clientes.distrito(nombre,descripcion)VALUES ('El Callao', ' ');


/*.........................3°..........................................*/

CREATE TABLE trabajo(
    id int primary key auto_increment,
    trabajo varchar(30),
    descripcion varchar(30)

);

INSERT INTO clientes.trabajo(trabajo,descripcion)VALUES ( 'Abogado',' ');
INSERT INTO clientes.trabajo(trabajo,descripcion)VALUES ( 'Ingeniero',' ');
INSERT INTO clientes.trabajo(trabajo,descripcion)VALUES ( 'Diseñador',' ');
INSERT INTO clientes.trabajo(trabajo,descripcion)VALUES ( 'Historiador',' ');

/*.........................4°..........................................*/

CREATE TABLE cliente (
    id int primary key auto_increment,
    nombre varchar(255),
    apellido varchar(255),
    email varchar(255),
    create_At DATE,
    celular varchar(12),
    trabajo_Id int,
    distrito_Id int,
    CONSTRAINT FK_cliente_trabajo FOREIGN KEY (trabajo_ID)
    REFERENCES trabajo(ID),
    CONSTRAINT FK_cliente_distrito FOREIGN KEY (distrito_ID)
    REFERENCES distrito (ID)
);


INSERT INTO clientes.cliente( apellido, create_at, email, nombre,celular,trabajo_id,distrito_id)
VALUES ( 'Villazana', '1991-01-17', 'wendy@gmail.com', 'Wendy','992338480',1, 1),
       ( 'Campo', '1993-01-24', 'oscar@gmail.com', 'Oscar','992338481',1, 1),
        ( 'Rojas', '1994-01-24', 'rocio@gmail.com', 'Rosa','992338482',1, 1),
        ( 'Perez', '1993-01-24', 'pedro@gmail.com', 'Pedro','992338483',1, 1),
        ( 'Aguirre', '1993-01-25', 'alex@gmail.com', 'Alex','992338484',1, 1),
        ( 'Martin', '1993-01-24', 'miguel@gmail.com', 'Miguel','992338486',1, 1),
        ( 'Glacier', '1993-01-28', 'gloria@gmail.com', 'Gloria','992338487',1, 1),
        ( 'Napa', '1993-01-29', 'nancy@gmail.com', 'Nancy','992338488',1, 1),
        ( 'Castro', '1993-01-20', 'camila@gmail.com', 'Camila','992338489',1, 1),
        ( 'Flores', '1993-02-24', 'frnak@gmail.com', 'Frank','992338410',1, 1),
        ( 'Cordova', '1993-03-24', 'carmen@gmail.com', 'Carmen','992238420',1, 1),
        ( 'Andrade', '1993-04-24', 'ariel@gmail.com', 'Ariel','992338430',1, 1),
        ( 'Rojas', '1993-05-24', 'rita@gmail.com', 'Rita','992538440',1, 1),
        ( 'Dolores', '1993-06-24', 'dora@gmail.com', 'Dora','992538450',1, 1),
        ( 'Morales', '1994-08-24', 'marco@gmail.com', 'Marco','992338460',1, 1),
        ( 'Wong', '1993-07-24', 'willo@gmail.com', 'Willo','992338480',1, 1),
        ( 'Jimenez', '1993-09-24', 'jorge@gmail.com', 'Jorge','992338480',1, 1),
        ( 'Andrade', '1993-01-21', 'antoni@gmail.com', 'Antoni','992338480',1, 1),
        ( 'Torres', '1993-01-24', 'jose@gmail.com', 'Jose','992338480',1, 1),
        ( 'Lopez', '1993-01-24', 'mari@gmail.com', 'Mari','992338480',1, 1);


/*SELECT * FROM cliente;*/
/*SELECT * FROM distrito;*/
/*SELECT * FROM trabajo;*/
/*drop table cliente;*/
/*drop table distrito;*/
/*drop table trabajo;*/

