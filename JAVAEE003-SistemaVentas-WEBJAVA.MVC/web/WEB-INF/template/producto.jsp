<%-- 
    Document   : producto
    Created on : 11/08/2019, 09:53:47 PM
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
                    <form  action="Controller?menu=Producto" method="POST">
                        <div class="form-group">
                            <label>Nombre(s)</label>
                            <input type="text" name="txtNombre" class="form-control"
                                placeholder="Type your names" maxlength="8" 
                                value="${productoEdit.getNombres()}" onkeypress="return soloLetras(event)"/>
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" name="txtPrecio" class="form-control"
                                placeholder="Type your price" maxlength="8" 
                                value="${productoEdit.getPrecio()}"/>
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="text" name="txtStock" class="form-control"
                                placeholder="Type your stock" maxlength="8" 
                                value="${productoEdit.getStock()}" onkeypress="return soloNumeros(event)"/>
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" name="txtEstado" class="form-control"
                                placeholder="Type your state" maxlength="8" 
                                value="${productoEdit.getEstado()}" onkeypress="return soloNumeros(event)"/>
                        </div>
                        
                        <input type="submit" name="action" value="Agregar" class="btn btn-info" >
                        <input type="submit" name="action" value="Actualizar" class="btn btn-success" >
                    </form>
                </div>
            </div>
            <div class="col-sm-8">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRES</th>
                            <th>PRECIO</th>
                            <th>STOCK</th>
                            <th>ESTADO</th>
                            <th>ACCIÓN</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productos}">
                            <tr>
                                <td><c:out value="${producto.getIdProducto()}"></c:out></td>
                                <td><c:out value="${producto.getNombres()}"></c:out></td>
                                <td><c:out value="${producto.getPrecio()}"></c:out></td>
                                <td><c:out value="${producto.getStock()}"></c:out></td>
                                <td><c:out value="${producto.getEstado()}"></c:out></td>
                                <td>
                                    <c:url var="editLink" value="Controller">
                                        <c:param name="menu" value="Producto" ></c:param>
                                        <c:param name="action" value="Editar"></c:param>
                                        <c:param name="id" value="${producto.getIdProducto()}"></c:param>
                                    </c:url>
                                    <c:url var="deleteLink" value="Controller">
                                        <c:param name="menu" value="Producto" ></c:param>
                                        <c:param name="action" value="Eliminar"></c:param>
                                        <c:param name="id" value="${producto.getIdProducto()}"></c:param>
                                    </c:url>
                                    
                                    <a href="${editLink}" class="btn btn-warning">Editar</a>
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
