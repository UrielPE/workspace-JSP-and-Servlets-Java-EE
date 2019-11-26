<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="${initParam['urlpaypal']}" method="POST" target="_top">
    <input type="hidden" name="business" value="urielpena.e@hotmail.com">
    <input type="hidden" name="return" value="${initParam['urlretorno']}">
    <input type="hidden" name="cmd" value="_cart">
    <input type="hidden" name="upload" value="1">
    
    <c:forEach var="product" items="${sessionScope.cart}">
        <c:set var="c" value="${c+1}" ></c:set>
        <input type="hidden" name="item_name_${c}" value="${producto.getProucto().getNombre()}">
        <input type="hidden" name="item_number_${c}" value="${producto.getProucto().getWebid()}">
        <input type="hidden" name="amount_${c}" value="${producto.getProucto().getPrecio()}">
        <input type="hidden" name="quantity_${c}" value="${producto.getCantidad()}">
    </c:forEach>
</form>