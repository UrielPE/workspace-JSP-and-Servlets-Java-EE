/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sit.ecommerce.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sit.ecommerce.model.dao.ProductoDao;
import sit.ecommerce.model.vo.Producto;
import sit.ecommerce.model.vo.ProductoMoneda;

/**
 *
 * @author uriel.pena
 */
public class ControlProducto extends HttpServlet 
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
    }
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        recibirDatos( request );
        
        String url = (String) request.getAttribute( "productImage" );
        //response.sendRedirect( "foto/"+url );
        String productName = (String) request.getAttribute( "productName" );
        float productPrice = Float.parseFloat(request.getAttribute( "productPrice" ).toString());
        float productNewPrice = Float.parseFloat(request.getAttribute( "productNewPrice" ).toString());
        
        float productPriceUSD = Float.parseFloat(request.getAttribute( "productPriceUSD" ).toString());
        float productNewPriceUSD = Float.parseFloat(request.getAttribute( "productNewPriceUSD" ).toString());
        
        float productPriceCOP = Float.parseFloat(request.getAttribute( "productPriceCOP" ).toString());
        float productNewPriceCOP = Float.parseFloat(request.getAttribute( "productNewPriceCOP" ).toString());
        
        float productPricePEN = Float.parseFloat(request.getAttribute( "productPricePEN" ).toString());
        float productNewPricePEN = Float.parseFloat(request.getAttribute( "productNewPricePEN" ).toString());
        
        int productQuantity = Integer.parseInt(request.getAttribute( "productQuantity" ).toString());
        int productBrand = Integer.parseInt(request.getAttribute( "productBrand" ).toString());
        int productCategory = Integer.parseInt(request.getAttribute( "productCategory" ).toString());
        
        String productDescription = (String) request.getAttribute( "productDescription" );
        
        boolean productNew, productRecommended, productVisible;
        try{
            productNew = request.getAttribute( "productNew" ).toString().equalsIgnoreCase("on");
        }catch(Exception ex){
            productNew = false;
        }
        
        try{
            productRecommended = request.getAttribute( "productRecommended" ).toString().equalsIgnoreCase("on");
        }catch(Exception ex){
            productRecommended = false;
        }
        
        try{
            productVisible = request.getAttribute( "productVisible" ).toString().equalsIgnoreCase("on");
        }catch(Exception ex){
            productVisible = false;
        }
        
        //product object create
        Producto producto = new Producto(
            0,productName,productPrice,productNewPrice,productQuantity,productNew,
            productRecommended,productDescription,productVisible,productBrand,productCategory,
            url
        );
        
        //productMoneda object create
        ProductoMoneda pmColombiano = new ProductoMoneda( "COP", productPriceCOP, productNewPriceCOP, 0);
        ProductoMoneda pmEstadosUni = new ProductoMoneda( "USD", productPriceUSD, productNewPriceUSD, 0);
        ProductoMoneda pmVenezolano = new ProductoMoneda( "PET", productPricePEN, productNewPricePEN, 0);
       
        
        String action = request.getAttribute("action" ).toString();
        switch( action )
        {
            case "Register":
                    if( ProductoDao.saveProducto(producto, pmColombiano, pmEstadosUni, pmVenezolano) ){
                        request.setAttribute( "message" ,  "<p style='color:green'>Producto registrado</p>" );
                    }else{
                        request.setAttribute( "message" ,  "<p style='color:red'>Producto no registrado</p>" );
                    }
                    request.getRequestDispatcher( "admin" ).forward(request, response);
                break;
                
            default:
                request.setAttribute( "message" ,  "<p style='color:red'>Acción desconocida</p>" );
                request.getRequestDispatcher( "admin" ).forward(request, response);
        }
    } 
    
    private void recibirDatos( HttpServletRequest request )
    {
        try 
        {
            FileItemFactory fileFactory = new DiskFileItemFactory();
            ServletFileUpload servletUpload = new ServletFileUpload(fileFactory);
            
            String nombre = "";
            List items = servletUpload.parseRequest(request);
            for( int i = 0; i < items.size(); i++ ){
                FileItem item = (FileItem) items.get(i);
                
                if( !item.isFormField() )
                {
                    String path = request.getServletContext().getRealPath( "/" )+"foto/";
                    SimpleDateFormat sdf = new SimpleDateFormat( "ddMyyyyhhmmss" );
                    String fecha = sdf.format( new Date() );
                    nombre = fecha+new Random().nextLong()+item.getName();
                    String nuevoNombre = path+nombre;
                    
                    File folder = new File( path );
                    if( !folder.exists() ){
                        folder.mkdirs();
                    }
                    
                    File imagen = new File( nuevoNombre );
                    if( item.getContentType().contains( "image" ) )
                    {
                        item.write( imagen );
                        request.setAttribute( item.getFieldName() , nombre );
                    }//end if
                }//end if 
                
                else{
                    request.setAttribute( item.getFieldName() , item.getString() );
                }
            }//end for
            
        }//end try
        
        catch (FileUploadException ex) {
            request.setAttribute( "subida" , false );
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            request.setAttribute( "subida" , false );
            Logger.getLogger(ControlProducto.class.getName()).log(Level.SEVERE, null, ex);
        }//end catch
    }//end method uploadImage
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
