<%-- 
    Document   : index
    Created on : 12-Febrero-2018, 10:24:59
    Author     : Christian Camilo Gámez
--%>

<%@page import="sit.ecommerce.model.dao.MarcaDAO"%>
<%@page import="sit.ecommerce.model.dao.CategoriaDao"%>

<%@page import="java.util.ArrayList"%>

<%@page import="sit.ecommerce.model.vo.Categoria"%>
<%@page import="sit.ecommerce.model.vo.Marca"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Gestión de productos |  Crea e-Commerce JAVA EE con pagos Online Paypal y Payu</title>
        
        <%@include file="../../WEB-INF/partials/estilos.jsp" %>
    </head><!--/head-->
    <body>
        <%@include file="../../WEB-INF/partials/header.jsp" %>
        
        <section>
            <div class="container">
                <div class="row">
                    <div class="">

                    </div>

                    <div class="col-12 clearfix">
                        ${message}
                        <h3>Gestionar producto</h3>
                        <div class="form-one">
                            <form  action="ControlProducto" enctype="multipart/form-data" method="post">
                                <div class="form-one">
                                    <p>
                                        <label for="productName">Product name:</label>
                                        <input id="productName" type="text" name="productName"
                                            placeholder="Type the product name" value="" required />
                                    </p>
                                    <p>
                                        <label for="productPrice">Product price(MXN):</label><br>
                                        <input id="productPrice" type="number" name="productPrice"
                                            value="0" min="0" />
                                    </p>
                                    <p>
                                        <label for="productNewPrice">Product new price(Promotion)(MXN)</label>
                                        <input id="productNewPrice" type="number" name="productNewPrice"
                                            value="0" min="0"/>
                                    </p>
                                    <hr>
                                    <br>
                                    <p>
                                        <label for="productPrice">Product price(USD):</label><br>
                                        <input id="productPriceUSD" type="number" name="productPriceUSD"
                                            value="0" min="0" />
                                    </p>
                                    <p>
                                        <label for="productNewPrice">Product new price(Promotion)(USD)</label>
                                        <input id="productNewPriceUSD" type="number" name="productNewPriceUSD"
                                            value="0" min="0"/>
                                    </p>
                                    <hr>
                                    <br>
                                    <p>
                                        <label for="productPrice">Product price(COP):</label><br>
                                        <input id="productPriceCOP" type="number" name="productPriceCOP"
                                            value="0" min="0" />
                                    </p>
                                    <p>
                                        <label for="productNewPrice">Product new price(Promotion)(COP)</label>
                                        <input id="productNewPriceCOP" type="number" name="productNewPriceCOP"
                                            value="0" min="0"/>
                                    </p>
                                    <hr>
                                    <br>
                                    <p>
                                        <label for="productPrice">Product price(PEN):</label><br>
                                        <input id="productPricePEN" type="number" name="productPricePEN"
                                            value="0" min="0" />
                                    </p>
                                    <p>
                                        <label for="productNewPrice">Product new price(Promotion)(PEN)</label>
                                        <input id="productNewPricePEN" type="number" name="productNewPricePEN"
                                            value="0" min="0"/>
                                    </p>
                                    <hr>
                                    <br>
                                    <p>
                                        <label for="productQuantity">Product quantity</label>
                                        <input id="productQuantity" type="number" name="productQuantity"
                                            value="1" min="0" />
                                    </p>
                                    <p>
                                        <label>Brand</label>
                                        <select name="productBrand">
                                            <option>Select brand</option>
                                            <%for( Marca m: MarcaDAO.listarTodoMarcas() ){ %>
                                                <option value="<%=m.getCodifo()%>"><%=m.getNombre()%></option>
                                            <%}%>
                                        </select>
                                    </p>
                                    <p>
                                        <label>Category</label>
                                        <select name="productCategory">
                                            <option>Select category</option>
                                            <%for( Categoria c : CategoriaDao.listarTodoDeCategoria() ){%>
                                                <option value="<%=c.getCodigo()%>" ><%=c.getNombre()%></option>
                                            <%}%>
                                        </select> 
                                    </p>
                                    <p>
                                        <textarea name="productDescription" rows="4" cols="20"
                                            placeholder="Type some product description" required></textarea>
                                    </p>
                                    <p>
                                        <label>New?</label>
                                        <input type="checkbox" name="productNew" value="ON" checked="checked" />
                                        <label>Recommended?</label>
                                        <input type="checkbox" name="productRecommended" value="ON" />
                                        <label>Visible?</label>
                                        <input type="checkbox" name="productVisible" value="ON" checked="checked" />
                                    </p>
                                    <hr>
                                    <p>
                                        <label>Picture</label>
                                        <input type="file" name="productImage" required/>
                                    </p>
                                    <hr>
                                    <p>
                                        <input class="btn btn-success" type="submit" value="Register" name="action" />
                                        <input class="btn btn-default" type="submit" value="Consult" name="action" />
                                        <input class="btn btn-warning" type="submit" value="Update" name="action" />
                                        <input class="btn btn-danger" type="submit" value="Delete" name="action" />
                                    </p>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="../../WEB-INF/partials/footer.jsp" %>
        <%@include file="../../WEB-INF/partials/js.jsp" %>
    </body>
</html>
 