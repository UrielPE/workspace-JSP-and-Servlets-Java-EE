<%-- 
    Document   : listaProductos
    Created on : 9/06/2018, 03:39:28 PM
    Author     : Uriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <style>
       table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
            font-family: 'Dosis', sans-serif;
        }

        tr:nth-child(even){background-color: #f2f2f2}
        
        /*tr:hover{
           border-bottom: 3px solid #4CAF50 ;
            -webkit-transition:   1s;
        }*/
        
        th {
            background-color: #4CAF50;
            color: white;
            /*text-align: center;*/
            height: 50px;
        }
        
        .content {
            margin-left: 200px;
            padding-left: 20px;
        }
        
        /* Style the side navigation */
        .sidenav {
            height: 100%;
            width: 200px;
            position: fixed;
            z-index: 1;
            top: 0;
            left: 0;
            background-color: #111;
            opacity: 0.8;
            overflow-x: hidden;
        }


        /* Side navigation links */
        .sidenav a {
            color: white;
            padding: 16px;
            text-decoration: none;
            /*text-align: center;*/
            display: block;
            font-family: 'Dosis', sans-serif;
        }
        
        a {
            text-decoration: none;
            /*text-align: center;*/           
            font-family: 'Dosis', sans-serif;
            color: #4CAF50;
        }

        /* Change color on hover */
        .sidenav a:hover {
            background-color: #f2f2f2;
            color: black;
            -webkit-transition:  1s;
        }
        
    </style>
    
    <body>    
        
        <div class="sidenav">
            <a href="Registro_producto.jsp">Registrar producto</a>
            <!--<a href="Actualiza_producto.jsp">Actualiza producto</a>
            <a href="Elimina_producto.jsp">Elimina   producto</a>-->
        </div>
        
        <section class="content">
            <table>
                <tr>
                    <th>Código</th>
                    <th>Sección</th>
                    <th>Nombre</th>
                    <th>Fecha</th>
                    <th>Precio</th>
                    <th>Importado</th>
                    <th>País de origen</th>
                    <th>OPERACIONES EXTRAS</th>
                </tr>
               
                <c:forEach var="producto" items="${listaProductos}">
                    
                    <!--Link para actualizar cada producto-->
                    <c:url var="enlaceTemp" value="Controlador" >
                        <c:param name="instruccion" value="cargaProducto"></c:param>
                        <c:param name="cArticulo" value="${producto.codigoArticulo}"></c:param>
                    </c:url>
                    
                    <!--Link para eliminar cada producto-->
                    <c:url var="enlaceElimina" value="Controlador" >
                        <c:param name="instruccion" value="eliminaProducto"></c:param>
                        <c:param name="codigo_articulo" value="${producto.codigoArticulo}"></c:param>
                    </c:url>
                    
                    <tr>
                        <td>${producto.codigoArticulo}</td> 
                        <td>${producto.seccion}</td> 
                        <td>${producto.nombreArticulo}</td> 
                        <td>${producto.fecha}</td> 
                        <td>${producto.precio}</td> 
                        <td>${producto.importado}</td> 
                        <td>${producto.paisOrigen}</td> 
                        <td>
                            <a href="${enlaceTemp}">Actualizar</a>
                            &nbsp; &nbsp; &nbsp; &nbsp;
                            <a href="${enlaceElimina}">Eliminar</a> 
                        </td> 
                        
                    </tr>
                </c:forEach>
            </table>
        </section> 
        
    </body>
</html>
