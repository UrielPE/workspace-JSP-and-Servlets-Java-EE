<%-- 
    Document   : viewResult
    Created on : 10/07/2019, 12:14:40 AM
    Author     : URIEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.sit.webjavamvc.model.vo.Cuenta"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="<%=request.getContextPath()%>/src/bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="card border-secondary mb-3 mt-4" style="width: 65%;">
                    <div class="card-header text-white bg-info">Detalle Cuenta:</div>
                    <div class="card-body text-primary">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Nombre</th>
                                    <th>Email</th>
                                    <th>Saldo</th>
                                    <th>Endeudamiento</th>
                                    <th>Fecha Renovación</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>${cuenta.getName()}</td> 
                                    <td>${cuenta.getEmail()}</td>
                                    <td>${cuenta.getSaldo()}</td>
                                    <td>${cuenta.getEndeudamientoLevel()}</td>
                                    <td>${cuenta.getRenovationDate()}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <a href="mainController" name="page" value="inicio"
                           class="btn btn-secondary">Volver</a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
