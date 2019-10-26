<%-- 
    Document   : cliente
    Created on : 12/08/2019, 02:22:23 PM
    Author     : URIEL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!--Assets-->
        <link href="https://bootswatch.com/4/litera/bootstrap.css" 
            rel="stylesheet" >
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controller?menu=Cliente" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" name="txtDni" class="form-control"
                                placeholder="Type your dni" maxlength="8" 
                                value="${clienteEdit.getDni()}" onkeypress="return soloNumeros(event)"/>
                         </div>
                        <div class="form-group">
                            <label>Nombre(s)</label>
                            <input type="text" name="txtNombre" class="form-control"
                                placeholder="Type your names" maxlength="244" 
                                value="${clienteEdit.getNombres()}" onkeypress="return soloLetras(event)"/>
                        </div>
                        <div class="form-group">
                            <label>Dirección</label>
                            <input type="text" name="txtDireccion" class="form-control"
                                placeholder="Type your address" maxlength="244" 
                                value="${clienteEdit.getDireccion()}" onkeypress="return soloLetras(event)"/>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" name="txtEstado" class="form-control"
                                placeholder="Type your state" maxlength="1" 
                                value="${clienteEdit.getEstado()}" onkeypress="return soloNumeros(event)"/>
                        </div>
                        <input type="submit" class="btn btn-primary" name="action" value="Agregar">
                        <input type="submit" class="btn btn-success" name="action" value="Actualizar">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>DNI</th>
                            <th>NOMBRES</th>
                            <th>DIRECCIÓN</th>
                            <th>ESTADO</th>
                            <th>ACCIÓN</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cliente" items="${clientes}" >
                            <tr>
                                <td><c:out value="${cliente.getDni()}"></c:out></td>
                                <td><c:out value="${cliente.getNombres()}"></c:out></td>
                                <td><c:out value="${cliente.getDireccion()}"></c:out></td>
                                <td><c:out value="${cliente.getEstado()}"></c:out></td>
                                <td>
                                    <c:url var="editLink" value="Controller">
                                        <c:param name="menu" value="Cliente"></c:param>
                                        <c:param name="action" value="Editar"></c:param>
                                        <c:param name="id" value="${cliente.getIdCliente()}"></c:param>
                                    </c:url>
                                    <c:url var="deleteLink" value="Controller">
                                        <c:param name="menu" value="Cliente"></c:param>
                                        <c:param name="action" value="Eliminar"></c:param>
                                        <c:param name="id" value="${cliente.getIdCliente()}"></c:param>
                                    </c:url>
                                    
                                    <a href="${editLink}" class="btn btn-warning" >Editar</a>
                                    <a href="${deleteLink}" class="btn btn-danger">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        
        <script src="<%=request.getContextPath()%>/src/js/Validaciones.js" ></script>
    </body>
</html>
