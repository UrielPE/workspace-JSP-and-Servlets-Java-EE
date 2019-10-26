/**
 *
 * @author uriel
 */
package mx.com.sit.comercializadora.controlller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.com.sit.comercializadora.model.vo.Categoria;
import mx.com.sit.comercializadora.model.dao.CategoriaDao;

@WebServlet(name = "CategoryController", urlPatterns = {"/CategoryController"})
public class CategoryController extends HttpServlet {

    private CategoriaDao categoriaDao;
    private List<Categoria> listaCategorias;

    @Override
    public void init() throws ServletException 
    {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        categoriaDao = new CategoriaDao();
    }

    @Override
    public void destroy() {
        super.destroy(); //To change body of generated methods, choose Tools | Templates.
        categoriaDao = null;
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {    
        String option = request.getParameter("page");
        if (option != null) {
            
            switch( option )
            {
                case "nuevo":
                    request.setAttribute( "formType" , "save" );
                    redirect(request, response, "formSave.jsp");
                    break;
                    
                case "update":
                    Categoria categoria = categoriaDao.findById(
                        Integer.parseInt(request.getParameter( "id_categoria" ))
                    );
                    
                    if( categoria != null )
                    {
                        request.setAttribute( "formType" , "update" );
                        request.setAttribute( "category" , categoria );
                        redirect(request, response, "formSave.jsp");
                    }
                    break;
            }
        } else {
            
            listaCategorias = categoriaDao.listAll();
            request.setAttribute("categorias", listaCategorias);
            redirect(request, response, "index.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String message = "";
        String operation = request.getParameter( "action" );
        if (operation != null) {
            
            switch( operation )
            {
                case "save":
                    if( categoriaDao.save( new Categoria( 
                        Integer.parseInt(request.getParameter( "clave_categoria" )),    
                        request.getParameter( "nombre_categoria" )
                    ) ) )
                        message = "The record was saved successfully" ;
                    else
                        message = "The record was not saved" ;
                    
                    resend(request, response, message, "/JAVAEE-Project-Comercializadora/CategoryController");
                    break;
                    
                case "update":
                    if( categoriaDao.update( new Categoria( 
                        Integer.parseInt(request.getParameter( "clave_categoria" )),    
                        request.getParameter( "nombre_categoria" )
                    ) ) )
                        message = "The record was updated successfully" ;
                    else
                        message = "The record was not updated" ;
                                            
                    resend(request, response, message, "/JAVAEE-Project-Comercializadora/CategoryController");
                    break;
                    
                case "delete":
                    if( categoriaDao.delete( Integer.parseInt( request.getParameter( "id_categoria" )) ))
                        message = "The record was deleted successfully" ;
                    else
                        message = "The record was not deleted" ;
                                            
                    resend(request, response, message, "/JAVAEE-Project-Comercializadora/CategoryController");
                    break;
            }
        }
    }
    
    public void resend( HttpServletRequest request, HttpServletResponse response,
        String message, String url )throws IOException, ServletException
    {
        request.getSession().setAttribute( "infoMessage", message);
            response.sendRedirect( url );
    }

    public void redirect( HttpServletRequest request,
        HttpServletResponse response, String page ) throws IOException, ServletException
    {
        request.getRequestDispatcher("/WEB-INF/Categories/" + page)
            .forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
