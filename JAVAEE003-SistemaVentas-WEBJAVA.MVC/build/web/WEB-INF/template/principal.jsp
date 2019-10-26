<%-- 
    Document   : principal
    Created on : 10/07/2019, 09:57:48 PM
    Author     : URIEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Principal</title>

        <!--Assets-->
        <link href="https://bootswatch.com/4/litera/bootstrap.css" 
            rel="stylesheet" >
    </head>
    <body>
        <div class="container-fluid">
            <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
                <a class="navbar-brand" href="#">@SIT</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarColor01">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controller?menu=Producto&action=Listar"
                               target="myFrame">Producto</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controller?menu=Empleado&action=Listar"
                               target="myFrame">Empleado</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controller?menu=Cliente&action=Listar"
                               target="myFrame">Clientes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controller?menu=NuevaVenta&action=default"
                               target="myFrame">Nueva Venta</a>
                        </li>
                    </ul>
                    <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <c:out value="${employee.getNombre()}" ></c:out>
                        </button>                       
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item text-center" href="#">
                                <img src="<%=request.getContextPath()%>/img/user.png" alt="60" width="60">
                            </a>
                            <a class="dropdown-item" href="#">
                                <c:out value="${employee.getUser()}" ></c:out>
                            </a>
                            <a class="dropdown-item" href="#">usuario@gmail.com</a>
                            <!--Barra divisora-->
                            <div class="dropdown-divider"></div>
                            
                            <c:url var="enlaceSalir" value="Validar">
                                <c:param name="action" value="exit"></c:param>
                            </c:url>
                            <a class="dropdown-item" href="${enlaceSalir}">Salir</a>
                        </div>
                    </div>
                </div>
            </nav>
            <!--Capa donde se mostrarán todas las demás páginas.-->
            <div class="mt-2" style="height: 550px;">
                <iframe name="myFrame" style="height: 100%; width: 100%; border:none;"></iframe>
            </div>            
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" 
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" 
            crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
            integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" 
            crossorigin="anonymous"></script>
    </body>
</html>
