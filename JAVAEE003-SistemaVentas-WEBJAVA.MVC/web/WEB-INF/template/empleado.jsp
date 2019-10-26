<%-- 
    Document   : empleado
    Created on : 12/08/2019, 02:22:44 PM
    Author     : URIEL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleado</title>
        
        <!--Assets-->
        <link href="https://bootswatch.com/4/litera/bootstrap.css" 
            rel="stylesheet" >
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4">
                <div class="card-body">
                    <form action="Controller?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" name="txtDni" class="form-control"
                                placeholder="Type your DNI" maxlength="8" 
                                value="${empleadoEdit.getDni()}" onkeypress="return soloNumeros(event)"/>
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" name="txtNombres" class="form-control"
                                placeholder="Type your name" maxlength="100"
                                value="${empleadoEdit.getNombre()}" onkeypress="return soloLetras(event)"/>
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" name="txtTelefono" class="form-control"
                                placeholder="Type your number phone" maxlength="9"
                                value="${empleadoEdit.getTelefono()}" onkeypress="return soloLetras(event)"/>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" name="txtEstado" class="form-control"
                                placeholder="Type your state" maxlength="1"
                                value="${empleadoEdit.getEstado()}" onkeypress="return soloLetras(event)"/>
                        </div>
                        <div class="form-group">
                            <label>User</label>
                            <input type="text" name="txtUser" class="form-control"
                                placeholder="Type your user" maxlength="8"
                                value="${empleadoEdit.getUser()}" onkeypress="return soloLetras(event)"/>
                        </div>
                        <input type="submit" name="action" value="Agregar" class="btn btn-info">
                        <input type="submit" name="action" value="Actualizar" class="btn btn-success">
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>DNI</th>
                            <th>NOMBRES</th>
                            <th>TELEFONO</th>
                            <th>ESTADO</th>
                            <th>USER</th>
                            <th>ACCIÓN</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="empleado" items="${empleados}">
                            <tr>
                                <td><c:out value="${empleado.getDni()}"></c:out></td>
                                <td><c:out value="${empleado.getNombre()}"></c:out></td>
                                <td><c:out value="${empleado.getTelefono()}"></c:out></td>
                                <td><c:out value="${empleado.getEstado()}"></c:out></td>
                                <td><c:out value="${empleado.getUser()}"></c:out></td>
                                <td>
                                    <c:url var="editLink" value="Controller">
                                        <c:param name="menu" value="Empleado"></c:param>
                                        <c:param name="action" value="Editar"></c:param>
                                        <c:param name="id" value="${empleado.getIdEmpleado()}"></c:param>
                                    </c:url>
                                    
                                    <c:url var="deleteLink" value="Controller">
                                        <c:param name="menu" value="Empleado"></c:param>
                                        <c:param name="action" value="Eliminar"></c:param>
                                        <c:param name="id" value="${empleado.getIdEmpleado()}"></c:param>
                                    </c:url>
                                    
                                    <a href="${editLink}" class="btn btn-warning text-white">Editar</a>
                                    <a href="${deleteLink}" class="btn btn-danger text-white">Eliminar</a>
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
