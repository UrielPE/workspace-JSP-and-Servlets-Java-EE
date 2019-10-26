/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.modeloVO.Producto;
import com.modeloDAO.ProductoDAO;

import java.util.List;
import javax.servlet.RequestDispatcher;

import com.modelo.conexion.ConexionPOOL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Uriel
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})  //Notacion
public class Controlador extends HttpServlet {

//    @Resource( name = "jdbc/productos" )
    javax.sql.DataSource miPool;
    private ProductoDAO productoDAO;
    private ConexionPOOL miConexionPOOL ;
    
    private List<Producto> misProductos;

    //metodo desde donde inicia el servlet
    @Override
    public void init() throws ServletException 
    {
        //super.init(); //To change body of generated methods, choose Tools | Templates.       
        try 
        {
            miConexionPOOL = new ConexionPOOL();
            miPool = miConexionPOOL.getConnection();
            
            productoDAO = new ProductoDAO( miPool );
           
        } //end try
        
        catch ( Exception  e) 
        {
            throw new ServletException( e );
        }//end catch
    }//end method init
  
    private void obtenerProductos( HttpServletRequest request, 
            HttpServletResponse response )
    {
        try 
        {
            misProductos = productoDAO.getProductos();
        
            request.setAttribute( "listaProductos", misProductos );

            //Enviando el reques al JSP
            javax.servlet.RequestDispatcher miRD =
                    request.getRequestDispatcher( "/listaProductos.jsp" );
            miRD.forward( request, response );
        }//end block try 
        
        catch (Exception e) 
        {
            e.printStackTrace();
        }//end catch
    }//end method obtenerProductos
    
    private void agregarProducto(HttpServletRequest request, 
            HttpServletResponse response) 
    {                       
        try {
            productoDAO.agregarProducto( new Producto( 
                        request.getParameter( "codigo_articulo" ),
                        request.getParameter( "seccion_articulo" ),
                        request.getParameter( "nombre_articulo" ),
                        request.getParameter( "precio_articulo" ),    
                        request.getParameter( "fecha_articulo" ),
                        request.getParameter( "importado_articulo" ),
                        request.getParameter( "pais_origen_articulo" )
                ) );
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        obtenerProductos(request, response);
        
    }//end method agregarProducto
    
    private void actualizaProducto( HttpServletRequest request, 
            HttpServletResponse response ) throws Exception
    {
          try {
            productoDAO.actualizaProducto( new Producto( 
                        request.getParameter( "codigo_articulo" ),
                        request.getParameter( "seccion_articulo" ),
                        request.getParameter( "nombre_articulo" ),
                        request.getParameter( "precio_articulo" ),    
                        request.getParameter( "fecha_articulo" ),
                        request.getParameter( "importado_articulo" ),
                        request.getParameter( "pais_origen_articulo" )
                ) );
              System.out.println( request.getParameter( "CA" ) );
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        obtenerProductos(request, response);
    }//end method actualizaProducto
    
    private void eliminaProducto(HttpServletRequest request,
            HttpServletResponse response) throws Exception
    {
        productoDAO.eliminaProducto(
                request.getParameter( "codigo_articulo" ) );
        
        obtenerProductos(request, response);
    }// end method eliminaProducto
    
    private void cargaProducto(HttpServletRequest request, 
            HttpServletResponse response) throws Exception 
    {
        String codigo_articulo = request.getParameter( "cArticulo" );
        
        // Accedemos al DAO para recibir el dato consultado
        Producto producto = productoDAO.getProducto( codigo_articulo );
        
        // Alacenando atributo
        request.setAttribute( "productoActualiza", producto );
        
        //Vinculando con Actualizar.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher( "/ActualizaProducto.jsp" );
        dispatcher.forward( request, response );
    }//end method cargaProductos
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //Capturacion de caracteres especiales
        request.setCharacterEncoding( "UTF-8" );
        //En caso de salida con PrintWriter para caracteres especiales
        request.setCharacterEncoding( "UTF-8" );
        
        try 
        {
            String valor = request.getParameter( "instruccion" );
            //valor  = "insertarBD";
            
            if( valor == null )
                valor = "listarProductos" ;
            
            switch( valor )
            {
                case "insertarBD":
                    agregarProducto( request, response );
                    break;
                    
                case "listarProductos":
                    obtenerProductos( request, response );
                    break;
                    
                case "cargaProducto":
                    cargaProducto( request, response );
                    break;
                    
                case "actualizaBD" :
                    actualizaProducto( request, response );
                    break;
                    
                case "eliminaProducto":
                    eliminaProducto( request, response );
                    break;
                default :
                    obtenerProductos( request, response );
            }//end switch   
        }//end block try 
        
        catch (Exception ex) {
            ex.printStackTrace();
        }//end block catch
    }//end method doGet

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
    }

    
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
