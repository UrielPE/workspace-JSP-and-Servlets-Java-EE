<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="models.Producto"%>

<%
    String titulo = (String) request.getAttribute("titulo");
    Producto producto = (Producto) request.getAttribute("producto");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=titulo%></title>
    </head>
    <body>
        <h2><%=titulo%></h2>
        <% if (producto != null) {%>
        <p><strong>Id:</strong> <%=producto.getId()%></p>
        <p><strong>Nombre:</strong> <%=producto.getNombre()%></p>
        <p><strong>Precio:</strong> $<%=producto.getPrecio()%></p>
        <% } else {%>
        <p>Producto no encontrado</p>
        <% }%>
    </body>
</html>
