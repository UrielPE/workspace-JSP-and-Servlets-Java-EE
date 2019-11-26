/**
 *
 * @author URIEL
 */
package sit.ecommerce.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Home extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, 
        HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        if( session.getAttribute( "moneda" ) == null ){
            
            session.setAttribute( "moneda", "MXN" );
            session.setAttribute( "nom_moneda", "$ Pesos Mexicanos" );
        }//end if
        
        if( request.getParameter( "category" ) != null ){
            session.setAttribute( "category" , Integer.parseInt(request.getParameter( "category" )) );
        }else if( request.getParameter( "brand" ) != null ){
            session.setAttribute( "brand" , Integer.parseInt(request.getParameter( "brand" )) );
        }else{
            session.setAttribute( "category" , 0 );
            session.setAttribute( "brand" , 0 );
        }
       
        
        request.getRequestDispatcher( "WEB-INF/partials/index.jsp" )
            .forward( request, response );
    }//end method processRequest
    
    @Override
    public void doGet( HttpServletRequest request,
        HttpServletResponse response ) throws ServletException, IOException 
    {
        processRequest( request, response );
    }//end method doGet
}//end class Home
