/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  URIEL
 * Created: 14/09/2019
 */

--Creacion de la tabla tbl_categoria
create table tbl_categoria(
    codigo int auto_increment primary key,
    nombre varchar(30) unique,
    visible boolean default true,
    categoria_superior int,
    foreign key(categoria_superior) references tbl_categoria(codigo)
);

--Procedimiento almacenado
delimiter $$
create procedure sp_listarCategoriaSuperior()
begin 
    select codigo, nombre from tbl_categoria
    where codigo = categoria_superior and visible = true;
end
$$

--procedimiento para listar las subcategorias
delimiter @@
create procedure sp_listarSubCategoria( p_csuperior int) 
begin
    select codigo, nombre from tbl_categoria
    where codigo<>categoria_superior and visible = true and categoria_superior = p_csuperior;
end
@@

--Creacion de la tabla tbl_marca
create table tbl_marca(
    codigo int auto_increment primary key,
    nombre varchar(30) unique,
    visible boolean default true
);

--Creación de la tabla tbl_revision
create table tbl_revision(
    codigo int auto_increment primary key,
    nombre varchar(30) not null,
    correo varchar(60),
    comentario varchar(200),
    estrellas int default 3,
    fecha datetime, 
    webid int,
    foreign key( webid ) references tbl_producto( webid )
);

--Creacion de la tabla btl_producto
create table tbl_producto(
    webid int auto_increment primary key,
    nombre varchar(30),
    precio decimal(10,2),
    precio_nuevo decimal(10,2),
    stock int default 1,
    nuevo boolean default true,
    recomendado boolean default false,
    descripcion varchar(255),
    visible boolean default true,
    check( precio > precio_nuevo ),
    codigo_marca int,
    codigo_categoria int,
    foreign key( codigo_marca ) references tbl_marca(codigo),
    foreign key( codigo_categoria ) references tbl_categoria( codigo  ),
    imagen varchar( 100 ) default 'demo.png'
);
