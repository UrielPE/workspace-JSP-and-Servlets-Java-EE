<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="${initParam['urlpaypal']}" method="POST" target="_top">
    <input type="hidden" name="business" value="urielpena.e@hotmail.com">
    <input type="hidden" name="return" value="${initParam['urlretorno']}">
    <input type="hidden" name="cmd" value="_cart">
    <input type="hidden" name="upload" value="1">
    
    
    <!--Value send for paypal-->
    <c:forEach var="product" items="${sessionScope.cart}">
        <c:set var="c" value="${c+1}" ></c:set>
        <input type="hidden" name="item_name_${c}" value="${product.getProducto().getNombre()}">
        <input type="hidden" name="item_number_${c}" value="${product.getProducto().getWebid()}">
        <input type="hidden" name="amount_${c}" value="${product.getProducto().getPrecio()}">
        <input type="hidden" name="quantity_${c}" value="${product.getCantidad()}">
    </c:forEach>
    <input type="image" src="https://www.sandbox.paypal.com/es_ES/ES/i/btn/btn_buynow_LG.gif" border="0" name="submit" alt="Paypal, la forma más rápida y segura de pagar en Internet."/>
    <img alt="" border="0" src="https://www.sandbox.paypal.com/es_ES/i/src/pixel.gif" width="1" height="1">
</form>