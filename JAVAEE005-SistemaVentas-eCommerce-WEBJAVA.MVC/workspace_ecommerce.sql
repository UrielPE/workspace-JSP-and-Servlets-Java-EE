/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  URIEL
 * Created: 14/09/2019
 */

create table tbl_categoria(
    codigo int auto_increment primary key,
    nombre varchar(30) unique,
    visible boolean default true,
    categoria_superior int,
    foreign key(categoria_superior) references tbl_categoria(codigo)
);


create table tbl_marca(
    codigo int auto_increment primary key,
    nombre varchar(30) unique,
    visible boolean default true
);


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


delimiter $$
create procedure sp_listarCategoriaSuperior()
begin 
    select codigo, nombre from tbl_categoria
    where codigo = categoria_superior and visible = true;
end
$$


delimiter @@
create procedure sp_listarSubCategoria( p_csuperior int) 
begin
    select codigo, nombre from tbl_categoria
    where codigo<>categoria_superior and visible = true and categoria_superior = p_csuperior;
end
@@


delimiter @@
create procedure sp_contarSubCategoria( c_subCategoria int )
begin
    select count( * ) as cantidad from tbl_categoria  
    where categoria_superior = c_subCategoria and codigo <> c_subCategoria;
end 
@@ 


create table tbl_producto_moneda(
    moneda char(3),
    precio decimal(10,2),
    precionuevo decimal(10,2),
    check( precionuevo < precio ),
    webid int,
    foreign key( webid ) references tbl_producto(webid),
    primary key( moneda,webid)
);


delimiter $$
create procedure sp_listarTodoDeCategoria()
begin
    select codigo,nombre from tbl_categoria where visible = true;
end
$$


delimiter $$
create procedure sp_listarTodoDeMarca()
begin
    select codigo,nombre from tbl_marca where visible=true order by nombre;
end
$$


delimiter $$
create procedure sp_registrarProducto(
    p_nombre varchar(30),
    p_precio decimal(10,2),
    p_precio_nuevo decimal(10,2),
    p_stock int,
    p_nuevo boolean,
    p_recomendado boolean,
    p_descripcion text,
    p_visible boolean,
    p_codigo_marca int,
    p_codigo_categoria int,
    p_img varchar(100),

    p_moneda_cop char(3),
    p_precio_cop decimal(10,2),
    p_precio_nuevo_cop decimal(10,2),
    p_moneda_usd char(3),
    p_precio_usd decimal(10,2),
    p_precio_nuevo_usd decimal(10,2),
    p_moneda_pen char(3),
    p_precio_pen decimal(10,2),
    p_precio_nuevo_pen decimal(10,2)
)
begin
    DECLARE v_webid int;

    insert into tbl_producto values( null, p_nombre,p_precio,p_precio_nuevo,p_stock,
        p_nuevo,p_recomendado,p_descripcion,p_visible,p_codigo_marca,p_codigo_categoria,p_img );

    set v_webid = (SELECT LAST_INSERT_ID());
    
    insert into tbl_producto_moneda values
    ( p_moneda_cop,p_precio_cop,p_precio_nuevo_cop,v_webid ),
    ( p_moneda_usd,p_precio_usd,p_precio_nuevo_usd,v_webid ),
    ( p_moneda_pen,p_precio_pen,p_precio_nuevo_pen,v_webid );
    
end
$$


delimiter $$
create procedure sp_listarRecomendados( p_moneda char(3) )
begin
if p_moneda <> 'MXN' then
    select p.*, m.precio as precio2, m.precionuevo as precion2 from tbl_producto p
        inner join tbl_producto_moneda m on m.webid=p.webid
        inner join tbl_marca mar on mar.codigo = p.codigo_marca
        inner join tbl_categoria c on c.codigo=p.codigo_categoria
        where p.visible=true and c.visible=true and mar.visible = true and m.moneda=p_moneda;
else
    select p.* from tbl_producto p
        inner join tbl_marca mar on mar.codigo = p.codigo_marca
        inner join tbl_categoria c on c.codigo=p.codigo_categoria
        where p.visible=true and c.visible=true and mar.visible = true;
end if;
end
$$


delimiter $$
create procedure sp_listarPorCategoria( p_moneda char(3), p_cat int )
begin
if p_moneda <> 'MXN' then
    select p.*, m.precio as precio2, m.precionuevo as precion2 from tbl_producto p
        inner join tbl_producto_moneda m on m.webid=p.webid
        inner join tbl_marca mar on mar.codigo = p.codigo_marca
        inner join tbl_categoria c on c.codigo=p.codigo_categoria
        where p.visible=true and c.visible=true and mar.visible = true and m.moneda=p_moneda
        and p.codigo_categoria = p_cat;
else
    select p.* from tbl_producto p
        inner join tbl_marca mar on mar.codigo = p.codigo_marca
        inner join tbl_categoria c on c.codigo=p.codigo_categoria
        where p.visible=true and c.visible=true and mar.visible = true
        and p.codigo_categoria = p_cat;
end if;
end
$$


delimiter $$
create procedure sp_contarProductosMarca( mar int )
begin
select count(*) from tbl_producto where codigo_marca=mar;
end
$$


