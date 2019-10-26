/**
 *
 * @author URIEL
 */
package com.sit.webjavamvc.controller;

import com.sit.webjavamvc.model.vo.Cuenta;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( name = "ControllerServlet", 
    urlPatterns = { "/mainController" }, 
    initParams = {
        @WebInitParam( name="", value = "" ),
        @WebInitParam( name="", value = "" ),
    } )
public class Controller extends HttpServlet
{
    private String action;
    private String page;
    
    @Override
    protected void doPost(
        HttpServletRequest req, HttpServletResponse resp ) 
        throws ServletException, IOException 
    {
        action =  req.getParameter( "action" );
        switch( action ){
            case "Crear Cuenta":
                req.setAttribute( "cuenta" , new Cuenta( 
                    req.getParameter( "nombre" ),
                    req.getParameter( "email" ),
                    req.getParameter( "saldo" ),
                    req.getParameter( "nivel_endeudamiento" ),
                    req.getParameter( "fecha_renovacion" )
                ));
                req.getRequestDispatcher( "/WEB-INF/views/viewResult.jsp" )
                    .forward( req, resp );
                break;
        }
    }//end method doPost

    @Override
    protected void doGet(
        HttpServletRequest req, HttpServletResponse resp )
        throws ServletException, IOException 
    {
        page = req.getParameter( "page" );
        if( page != null )
        {    
            switch ( page ) 
            {
                case "inicio":
                    redirect(req, resp, "viewResult.jsp");
                    break;
                default:
                    throw new AssertionError();
            }//end switch
        }else{
            redirect(req, resp, "createForm.jsp");
        }//end if-else
    }//end method doGet
    
    public void redirect( HttpServletRequest request,
        HttpServletResponse response, String page ) throws IOException, ServletException
    {
        request.getRequestDispatcher("/WEB-INF/views/" + page)
            .forward(request, response);
    }//end method redirect
}//end class Controller