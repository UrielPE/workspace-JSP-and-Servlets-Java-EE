<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@page import="java.util.List"%>
<%@page import="models.Producto"%>
<%
    List<Producto> productos = (List<Producto>) request.getAttribute("productos");
    String titulo = (String) request.getAttribute("titulo");
    String fecha = (String) request.getAttribute("fecha");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=titulo%></title>
    </head>
    <body>
        <h1><%=titulo%></h1>
        <h3><%=fecha%></h3>
        <div style="margin:30px">
            <form action="<%=request.getContextPath() + "/catalogo/buscar" %>" method="post">
                    <input type="text" name="nombre" />
                    <input type="submit" name="enviar" value="Buscar" />
            </form>
        </div>
        <table border="1" cellspacing="1" cellpadding="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Detalle</th>
                </tr>
            </thead>
            <tbody>
        <% for(Producto producto : productos){%>
                <tr>
                    <td><%=producto.getId()%></td>
                    <td><%=producto.getNombre()%></td>
                    <td>$<%=producto.getPrecio()%></td>
                    <td><a href="detalle?id=<%=producto.getId()%>">ver</a></td>
                </tr>
        <% }%>
            </tbody>
        </table>
    </body>
</html>
