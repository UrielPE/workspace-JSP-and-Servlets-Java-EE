<%-- 
    Document   : nuevoProducto
    Created on : 12/08/2019, 02:22:59 PM    
    Author     : URIEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <!--Assets-->
        <link href="https://bootswatch.com/4/litera/bootstrap.css" 
            rel="stylesheet" >
        
        <style>
            @media print{
                .parte01, .btn, .action{
                    display:none;
                }
                
            }
        </style>
    </head>
    <body>
        <div class="d-flex">
            <div class="col-sm-5 parte01">
                <div class="card">
                    <form action="Controller?menu=NuevaVenta" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label><i class="fas fa-address-card"></i>&nbsp;Datos del cliente</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" placeholder="Códe" value="${cliente.getDni()}" name="txtCodigoCliente" class="form-control" aria-label="Amount (to the nearest dollar)">
                                    <input type="submit" name="action" value="BuscarCliente" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="txtNombreCliente" value="${cliente.getNombres()}" disabled="true" placeholder="Nombre cliente" class="form-control">
                                </div>
                            </div>
                            <!--Datos del producto-->
                            <div class="form-group">
                                <label><i class="fab fa-product-hunt"></i>&nbsp;Datos del Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="txtCodigoProducto" value="${producto.getIdProducto()}" placeholder="Códe" class="form-control" aria-label="Amount (to the nearest dollar)">
                                    <input type="submit" name="action" value="BuscarProducto" class="btn btn-outline-info">
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="txtNombreProducto" value="${producto.getNombres()}" disabled="true" placeholder="Nombre cliente" class="form-control">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-5 d-flex">
                                    <div class="form-group">
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <span class="input-group-text">
                                                    $
                                                </span>
                                            </div>
                                            <input type="text" name="txtPrecio" disabled="true" value="${producto.getPrecio()}" min="0" placeholder="Price" class="form-control" aria-label="Amount (to the nearest dollar)">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-sm-3">
                                    <div class="form-group">
                                        <input type="number" placeholder="Cant." name="txtCantidad" min="1" class="form-control" aria-label="Amount (to the nearest dollar)">
                                    </div>
                                </div>
                                <div class="col-sm-4">
                                    <div class="input-group mb-2">
                                        <div class="input-group-prepend">
                                            <span class="input-group-text">
                                                <i class="fas fa-cubes"></i>
                                            </span>
                                        </div>
                                        <input type="text" name="txtStock" value="${producto.getStock()}" disabled="true" placeholder="Stock" class="form-control" aria-label="Amount (to the nearest dollar)">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-4 d-flex">
                                    <input type="submit" name="action" value="Agregar al carrito" class="btn btn-outline-info">
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-sm-7">
                <div class="card">
                    <div class="card-body">
                        <div class="d-flex col-sm-6 ml-auto">
                            <label>Nro.Serie:&nbsp;&nbsp;</label>
                            <input type="text" value="${numSerie}" disabled="true" name="txtNoSerie" class="form-control">
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Núm.</th>
                                    <th>Cód.</th>
                                    <th>Descripción</th>
                                    <th>Precio</th>
                                    <th>Cantidad</th>
                                    <th>Subtotal</th>
                                    <th class="action"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="venta" items="${listaVentas}">
                                    <tr>
                                        <td><c:out value="${venta.getItem()}"></c:out></td>
                                        <td><c:out value="${venta.getIdProducto()}"></c:out></td>
                                        <td><c:out value="${venta.getDescripcionP()}"></c:out></td>
                                        <td><c:out value="${venta.getPrecio()}"></c:out></td>
                                        <td><c:out value="${venta.getCantidad()}"></c:out></td>
                                        <td><c:out value="${venta.getSubTotal()}"></c:out></td>
                                        <td>
                                            <a href="#" class="btn btn-outline-warning"><i class="fas fa-pencil-alt"></i></a>
                                            <a href="#" class="btn btn-outline-danger"><i class="fas fa-trash"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer d-flex">
                        <div class="col-sm-6">
                            <c:url var="generarVenta" value="Controller">
                                <c:param name="menu" value="NuevaVenta"></c:param>
                                <c:param name="action" value="Generar Venta"></c:param>
                            </c:url>
                            
                            <a href="${generarVenta}" class="btn btn-success" onclick="print()">Generar Venta</a>
                            <a href="" class="btn btn-danger">Cancelar</a>
                        </div>
                        <div class="col-sm-4 ">
                            <div class="form-group">
                                <div class="input-group mb-2">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            $
                                        </span>
                                    </div>
                                    <input type="text" name="txtTotal" disabled="true" value="${totalPagar}" min="0" placeholder="Total a pagar" class="form-control" aria-label="Amount (to the nearest dollar)">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
            <script src="<%=request.getContextPath()%>/src/js/all.js" type=""></script>
    </body>
</html>
