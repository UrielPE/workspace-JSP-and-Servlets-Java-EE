<%@page import="java.util.List"%>
<%@page import="sit.ecommerce.model.vo.Producto"%>
<%@page import="sit.ecommerce.model.dao.ProductoDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sit.ecommerce.model.dao.CategoriaDao"%>
<%@page import="sit.ecommerce.model.vo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Inicio |  Crea e-Commerce JAVA EE con pagos Online Paypal y Payu</title>
        
        <%@include file="estilos.jsp" %>
        
        <!--Script for paypal-->
        <script src="https://www.paypalobjects.com/api/checkout.js" ></script>
    </head><!--/head-->
    <body>
        <%@include file="header.jsp" %>

        <section id="cart_items">
		<div class="container">
			<div class="breadcrumbs">
				<ol class="breadcrumb">
				  <li><a href="#">Carrito</a></li>
				  <li class="active">Lista de productos</li>
				</ol>
			</div>
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Producto</td>
							<td class="description"></td>
							<td class="price">Precio</td>
							<td class="quantity">Cantidad</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
                                            <c:forEach var="product" items="${sessionScope.cart}">
                                                <c:set var="total" value="${total + product.getProducto().getPrecio() * product.cantidad}"></c:set>
						<tr>
							<td class="cart_product">
								<a href=""><img src="foto/${product.getProducto().getImagen()}" width="110px" alt=""></a>
							</td>
							<td class="cart_description">
								<h4><a href="">${product.getProducto().getNombre()}</a></h4>
								<p>ID Referencia Web: ${product.getProducto().getWebid()}</p>
							</td>
							<td class="cart_price">
								<p>${product.getProducto().getPrecio()}</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									<a class="cart_quantity_up" href=""> + </a>
									<input class="cart_quantity_input" type="text" name="quantity" value="${product.cantidad}" autocomplete="off" size="2">
									<a class="cart_quantity_down" href=""> - </a>
								</div>
							</td>
							<td class="cart_total">
                                                            <p id="precio_1" class="cart_total_price">
                                                                <fmt:setLocale value="en_US" />
                                                                <fmt:formatNumber value="${product.getProducto().getPrecio() * product.cantidad}" type="currency"/>
                                                            </p>
                                                                
							</td>
							<td class="cart_delete">
								<a class="cart_quantity_delete" href="?action=delete&id=${product.getProducto().getWebid()}"><i class="fa fa-times"></i></a>
							</td>
						</tr>
                                            </c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
			<div class="heading">
				<h3>¿Qué te gustaría hacer ahora?</h3>
				<p>Te gustaría pagar o seguir comprando?</p>
			</div>
			<div class="row">
				
				<div class="col-sm-10">
					<div class="total_area">
						<ul>
							<li>Sub Total <span>${total}</span></li>
							<li>Tax/IVA(19%) <span>${total*0.06}</span></li>
                                                        <li><h3>Total <span>${total + total*1.06}</span></h3></li>
						</ul>
                                            <a class="btn btn-default update" href="Home">Seguir comprando</a>
                                            <a class="btn btn-default check_out" href="Checkout">Realizar pago</a>
					</div>
				</div>
			</div>
		</div>
	</section><!--/#do_action-->
        
        <%@include file="footer.jsp" %>
        <%@include file="js.jsp" %>
            
    </body>
</html>
