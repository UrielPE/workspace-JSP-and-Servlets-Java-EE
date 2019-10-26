<%-- 
    Document   : Registro_producto
    Created on : 13/06/2018, 07:54:44 PM
    Author     : Uriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Dosis" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-family: 'Dosis', sans-serif;
        }

        input[type=date] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
            font-family: 'Dosis', sans-serif;
        }
        
        input[type=submit] {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-family: 'Dosis', sans-serif;
        }

        input[type=submit]:hover {
            background-color: #45a049;
            font-family: 'Dosis', sans-serif;
        }

        form {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
            width: 40%;
        }
        
        label
        {
            font-family: 'Dosis', sans-serif;
        }
        
        h1
        {
            font-family: 'Dosis', sans-serif;
            font-size: 25px;
        }
    </style>
    
    
    <body>
           
            <div class="form">
              <form name="form1" method="get" action="Controlador">
              <input type="hidden" name="instruccion" value="insertarBD">
                  
                <label for="fname">Código producto</label>
                <input type="text" id="codigo_articulo" name="codigo_articulo" placeholder="Código producto.">

                <label for="lname">Seccion producto</label>
                <input type="text" id="seccion_articulo" name="seccion_articulo" placeholder="Seccion producto.">

                <label for="lname">Nombre articulo</label>
                <input type="text" id="nombre_articulo" name="nombre_articulo" placeholder="Nombre articulo.">
                
                <label for="lname">Fecha articulo</label>
                <input type="date" id="fecha_articulo" name="fecha_articulo" placeholder="Fecha articulo.">
                
                <label for="lname">Precio articulo</label>
                <input type="text" id="precio_articulo" name="precio_articulo" placeholder="Precio articulo.">
                
                <label for="lname">Importado</label>
                <input type="text" id="importado_articulo" name="importado_articulo" placeholder="¿Importado?.">
                
                <label for="lname">País de origen</label>
                <input type="text" id="pais_origen_articulo" name="pais_origen_articulo" placeholder="Páis de origen.">
                <input type="submit" name="REGISTRAR PRODUCTO">
              </form>
            </div>
    </body>
</html>
