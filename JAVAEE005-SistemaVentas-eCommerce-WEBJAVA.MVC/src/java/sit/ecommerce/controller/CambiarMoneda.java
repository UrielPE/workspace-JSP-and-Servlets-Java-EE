/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.ecommerce.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author URIEL
 */
public class CambiarMoneda extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        if( request.getParameter( "moneda" ) != null ){
            switch ( request.getParameter( "moneda" ) ) 
            {
                case "COP":
                        session.setAttribute( "moneda", request.getParameter( "moneda" ) );
                        session.setAttribute( "nom_moneda", "$ Pesos Colombianos" );
                    break;
                case "USD":
                        session.setAttribute( "moneda", request.getParameter( "moneda" ) );
                        session.setAttribute( "nom_moneda", "$ Dolar(USA)" );
                    break;
                case "PET":
                        session.setAttribute( "moneda", request.getParameter( "moneda" ) );
                        session.setAttribute( "nom_moneda", "$ Sol Peruano" );
                    break;
                default:
                    session.setAttribute( "moneda", "MXN" );
                    session.setAttribute( "nom_moneda", "$ Pesos Mexicanos" );
            }
            
        }//end if
        
        response.sendRedirect( "Home" );
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
