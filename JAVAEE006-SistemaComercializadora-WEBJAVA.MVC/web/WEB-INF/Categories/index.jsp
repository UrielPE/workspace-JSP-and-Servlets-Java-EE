<%@page import="java.util.List"%>
<%@page import="mx.com.sit.comercializadora.model.vo.Categoria"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Bootstrap Admin Theme v3</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap -->
        <link href="<%= request.getContextPath()%>/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- styles -->
        <link href="<%= request.getContextPath()%>/css/styles.css" rel="stylesheet">
    </head>   
    <body>
        <jsp:include page="../Layouts/Header.jsp"></jsp:include>

            <div class="page-content">
                <div class="row">
                <jsp:include page="../Layouts/Sidebar.jsp"></jsp:include>
                    <div class="col-md-10">
                    <c:choose>
                        <c:when test="${infoMessage != null}" >
                            <div class="alert alert-info alert-dismissible fade in" role="alert">
                                <a href="#" class="close" data-dismiss="alert" aria-label="close">
                                    <span aria-hidden="true">&times;</span>
                                </a>
                                <p><c:out value="${infoMessage}"></c:out></p>
                            </div>
                            <% request.getSession().removeAttribute("infoMessage");%>   
                        </c:when>
                    </c:choose>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="content-box-large">
                                <div class="panel-heading">
                                    <div class="panel-title">Categorias Table</div>
                                </div>
                                <div class="panel-body">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Id Categoria</th>
                                                <th>Nombre Categoria</th>
                                                <th>Operaciones</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${categorias}" var="c">
                                                <tr>
                                                    <td>${c.getId_categoria()}</td>
                                                    <td>${c.getNombre_categoria()}</td>
                                                    <td>
                                                        <a class="btn btn-primary" href="CategoryController?page=update&id_categoria=${c.getId_categoria()}" >
                                                            Editar
                                                        </a>
                                                    </td>
                                                    <td>
                                                        <form action="CategoryController" method="post">
                                                            <input type="hidden" name="action" value="delete" >
                                                            <input type="hidden" name="id_categoria" value="${c.getId_categoria()}" >
                                                            
                                                            <input type="submit" value="Eliminar" class="btn btn-danger"> 
                                                        </form>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <a href="CategoryController?page=nuevo" class="btn btn-primary">Nueva categoria</a>
                                </div>
                            </div>
                        </div>  
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="../Layouts/Footer.jsp"></jsp:include>
    </body>
</html>