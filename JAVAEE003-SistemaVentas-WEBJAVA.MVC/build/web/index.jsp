
<%-- 
    Document   : index
    Created on : 10/07/2019, 09:55:57 PM
    Author     : URIEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        
        <!--Assets-->
        <link href="<%=request.getContextPath()%>/src/bootstrap.css" 
            rel="stylesheet">
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <c:choose>
                <c:when test="${infoMessage != null}" >
                    <div class="alert alert-info alert-dismissible" role="alert">
                        <a href="#" class="close" data-dismiss="alert" aria-label="close">
                            <span aria-hidden="true">&times;</span>
                        </a>
                        <p>Info!,&nbsp;<c:out value="${infoMessage}"></c:out></p>
                    </div>
                    <% request.getSession().removeAttribute("infoMessage");%>
                </c:when>
            </c:choose>
            <div class="card">
                <div class="card-body">
                    <form class="form-sing" action="Validar" method="POST">
                        <div class="form-group">
                            <label class="control-label">Username</label>
                            <input type="text" name="username" class="form-control" 
                                placeholder="Type your username"/>
                        </div>
                        <div class="form-group">
                            <label class="control-label">Password</label>
                            <input type="password" name="password" class="form-control"
                                placeholder="Type your password"/>
                        </div>
                        <input type="submit" name="action" value="singIn" class="btn btn-primary btn-block"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
