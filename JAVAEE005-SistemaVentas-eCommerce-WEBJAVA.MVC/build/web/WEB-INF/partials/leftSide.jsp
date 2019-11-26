<%@page import="sit.ecommerce.model.dao.MarcaDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sit.ecommerce.model.dao.CategoriaDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sit.ecommerce.model.vo.Categoria"%>

<div class="left-sidebar">
    <h2>Categorías</h2>
    <div class="panel-group category-products" id="accordian"><!--category-productsr-->
        <%!
            ArrayList<Categoria> lista = (ArrayList) CategoriaDao.listarCategoriaSuperior();
            int codigo = 0;
        %>
        <% for (int i = 0; lista.size() > i; i++) {
                codigo = lista.get(i).getCodigo();
        %>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a <% if (CategoriaDao.esSuperior(codigo)) { %> data-toggle="collapse" data-parent="#accordian" <%}%> href="#<%= codigo%>">
                        <% if (CategoriaDao.esSuperior(codigo)) { %><span class="badge pull-right"><i class="fa fa-plus"></i></span><%}%>
                            <a href="?category=<%=codigo%>"><%= lista.get(i).getNombre()%></a>
                    </a>
                </h4>
            </div>
            <div id="<%=codigo%>" class="panel-collapse collapse">
                <div class="panel-body">
                    <ul>
                        <% ArrayList<Categoria> listaSubcategoria = (ArrayList) CategoriaDao.listarSubCategoria(
                                                                codigo); %>
                        <%
                            for (int j = 0; listaSubcategoria.size() > j; j++) {
                                codigo = listaSubcategoria.get(j).getCodigo();
                        %>

                        <li><a href="?category=<%=codigo%>"><%=listaSubcategoria.get(j).getNombre()%></a></li>
                            <%}%>
                    </ul>
                </div>
            </div>
        </div>
        <%}%>
    </div><!--/category-products-->

    <div class="brands_products"><!--brands_products-->
        <h2>Marcas</h2>
        <div class="brands-name">
            <ul class="nav nav-pills nav-stacked">
                <c:forEach var="brand" items="<%=MarcaDAO.listarTodoMarcas()%>">
                    <c:set var="cod" value="${brand.getCodifo()}"></c:set>
                    <% int cod = Integer.parseInt(pageContext.getAttribute( "cod" ).toString()); %>
                    <li><a href="?brand=${cod}"> <span class="pull-right">(<%=MarcaDAO.contarMarcas( cod )%>)</span>${brand.getNombre()}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div><!--/brands_products-->

    <div class="shipping text-center"><!--shipping-->
        <img src="images/home/shipping.jpg" alt="" />
    </div><!--/shipping-->

</div>