<%-- 
    Document   : createForm
    Created on : 9/07/2019, 05:05:29 PM
    Author     : URIEL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link href="<%=request.getContextPath()%>/src/bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="card border-secondary mb-3 mt-4" style="width: 65%;">
                    <div class="card-header text-white bg-info">Header</div>
                    <div class="card-body text-primary">
                        <form method="post" action="mainController">
                            <div class="form-group row justify-content-center">
                                <label for="" class="col-sm-3 col-form-label">Nombre</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="nombre" placeholder="Type your name.">
                                </div>
                            </div>
                            <div class="form-group row justify-content-center">
                                <label for="" class="col-sm-3 col-form-label">Email</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="email" placeholder="Type your email.">
                                </div>
                            </div>
                            <div class="form-group row justify-content-center">
                                <label for="inputPassword" class="col-sm-3 col-form-label">Saldo</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="saldo" placeholder="Type your saldo.">
                                </div>
                            </div>
                            <div class="form-group row justify-content-center">
                                <label for="inputPassword" class="col-sm-3 col-form-label">Nivel Endeudamiento</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="nivel_endeudamiento" placeholder="Type your nivel de endeudamiento">
                                </div>
                            </div>
                            <div class="form-group row justify-content-center">
                                <label for="inputPassword" class="col-sm-3 col-form-label">Fecha Renovación</label>
                                <div class="col-sm-7">
                                    <input type="date" class="form-control" name="fecha_renovacion" placeholder="Type renovation date">
                                </div>
                            </div>
                            <div class="form-group row justify-content-center">
                                <input type="submit" class="btn btn-info col-sm-3" name="action" value="Crear Cuenta">
                                <div class="col-sm-7">
                                    <label></label>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
