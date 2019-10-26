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
                        <div class="row">
                            <div class="col-md-6">
                                <div class="content-box-large">
                                    <div class="panel-heading">
                                        <div class="panel-title">Crear categoria</div>
                                    </div>
                                    <div class="panel-body">
                                        <form class="form-horizontal" role="form" action="CategoryController" method="post">
                                            <input type="hidden" name="action" value="${formType}">
                                            <div class="form-group">
                                                <div class="col-sm-10">
                                                    <input type="number" class="form-control" id="inputPassword3" placeholder="Clave categoria" name="clave_categoria" value="<c:if test='${formType.equals("update")}'><c:out value="${category.getId_categoria()}"></c:out></c:if>" min="0">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" id="inputEmail3" placeholder="Nombre categoria" name="nombre_categoria" value="<c:if test="${formType.equals('update')}">${category.getNombre_categoria()}</c:if>">
                                                </div>
                                            </div>

                                            <div class="form-group">
                                                <div class="col-sm-10">
                                                    <button type="submit" class="btn btn-primary"><c:out value="${formType}"></c:out></button>
                                                </div>
                                            </div>
                                        </form>
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