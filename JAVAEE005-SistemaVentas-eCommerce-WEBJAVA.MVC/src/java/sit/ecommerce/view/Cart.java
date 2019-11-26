/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.ecommerce.view;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sit.ecommerce.model.dao.ProductoDao;
import sit.ecommerce.model.vo.Item;
import sit.ecommerce.model.vo.Producto;

/**
 *
 * @author uriel.pena
 */
public class Cart extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        if( request.getParameter( "action" ) != null ){
            
            String action = request.getParameter( "action" );
            int webid = Integer.parseInt(request.getParameter( "id" ).toString());
            
            Producto producto = new Producto();
            
            HttpSession session = request.getSession();
            if( action.equals( "order" ) )
            {
                if( session.getAttribute( "cart" ) == null ){
                    List<Item> cart = new ArrayList<>();
                    
                    producto = ProductoDao.consultarProducto( 
                        session.getAttribute( "moneda" ).toString() , webid);
                    
                    cart.add( new Item(producto, 1) );
                    session.setAttribute( "cart" , cart);
                }else{
                    List<Item> cart = (List<Item>) session.getAttribute( "cart" );
                    int index = yaExisteProducto( webid, cart );
                    
                    if( index == -1 )
                    {
                        producto = ProductoDao.consultarProducto( 
                            session.getAttribute( "moneda" ).toString() , webid);
                        
                        cart.add( new Item(producto, 1) );
                    }else{
                        int cantidad = cart.get( index ).getCantidad()+1; 
                        cart.get( index ).setCantidad( cantidad );
                    }
                    session.setAttribute( "cart" , cart);
                }    
            }else if( action.equals( "delete" ) ){
                List<Item> cart = (List<Item>) session.getAttribute( "cart" );
                int index = yaExisteProducto( webid, cart );
                
                // delete item
                cart.remove( index );
                // save object at session
                session.setAttribute( "cart" , cart);
            }
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher( "WEB-INF/partials/cart.jsp" )
            .forward( request, response );
    }
    
    private int yaExisteProducto( int webid , List<Item> list )
    {
        for( int i = 0; i < list.size(); i++ )
        {
            if( list.get(i).getProducto().getWebid() == webid )
            {return i;}
        }//end for-each
        
        return -1;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
