/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.controller;

import com.sit.sistemasventas.configuration.Conexion;
import com.sit.sistemasventas.model.dao.EmpleadoDao;
import com.sit.sistemasventas.model.vo.Empleado;
import com.sun.istack.internal.logging.Logger;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ValidarController extends HttpServlet 
{
    //fields
    private String username, password, action;
    
    //Objects
    private Empleado employee; 
    private EmpleadoDao employeeDao = new EmpleadoDao();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        this.action = request.getParameter( "action" );
        switch ( this.action ) {
            case "exit":
                    resend( "unregistered account!" ,
                        "index.jsp", request, response);
                break;
            default:
                throw new AssertionError();
        }//end switch
    }//end method doGet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException 
    {
        this.action = request.getParameter( "action" );
        this.username = request.getParameter( "username" );
        this.password = request.getParameter( "password" );
        
        switch ( this.action ) {
            case "singIn":
                if( this.username != "" && this.password != "" )
                {
                    employee =  employeeDao.validar( 
                        new Empleado( this.username, 
                            this.password 
                        )
                    );

                    if( employee != null )
                    {
                        request.setAttribute( "employee", employee );
                        request.getRequestDispatcher( "Controller?menu=principal")
                            .forward(request, response);
                    }else{
                        resend( "unregistered account!" ,
                            "index.jsp", request, response);
                    }
                }else{
                    resend( "You must fill all the fields!" ,
                        "index.jsp", request, response);
                }
            break;
            default:
                throw new AssertionError();
        }//end switch
    }//end method doPost
    
    public void resend( String content, String page, HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException 
    {
        request.getSession().setAttribute( "infoMessage" , 
            content );
        response.sendRedirect( page );
    }//end method resend
}//end class Validar
