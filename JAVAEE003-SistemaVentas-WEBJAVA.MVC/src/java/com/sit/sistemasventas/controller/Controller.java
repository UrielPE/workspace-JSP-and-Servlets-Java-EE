/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.controller;

import com.sit.sistemasventas.model.dao.ClienteDao;
import com.sit.sistemasventas.model.dao.EmpleadoDao;
import com.sit.sistemasventas.model.dao.ProductoDao;
import com.sit.sistemasventas.model.dao.VentaDao;
import com.sit.sistemasventas.model.logic.CodeGenerate;

import com.sit.sistemasventas.model.vo.Empleado;
import com.sit.sistemasventas.model.vo.Producto;
import com.sit.sistemasventas.model.vo.Cliente;
import com.sit.sistemasventas.model.vo.Venta;
import com.sun.istack.internal.logging.Logger;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.GenericServlet;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet 
{
    private String action, 
        menu, numeroSerie;
    
    private int idCliente;
    private int idEmpleado;
    private int idProducto;
    
    private Cliente cliente;
    private Producto producto;
    
    private VentaDao ventaDao = new VentaDao();
    private ClienteDao clienteDao = new ClienteDao();
    private EmpleadoDao empleadoDao = new EmpleadoDao();
    private ProductoDao productosDao = new ProductoDao();
    
    private Venta venta = new Venta();
    private List<Venta> lista = new ArrayList<Venta>();
    
    private int item, cantidad;
    private double subTotal, totalPagar;
    
    @Override
    public void init() throws ServletException {
    }//end method init
    
    public void processRequest( HttpServletRequest request, 
        HttpServletResponse response ) throws ServletException, IOException
    {
        action = request.getParameter( "action" );
        
        menu = request.getParameter( "menu" );
        switch ( menu ) {
            case "principal":
                    redirect(request, response, "principal.jsp" );
                break;
            case "Producto":
                    switch ( action ) 
                    {
                        case "Listar":  
                                request.setAttribute( "productos", productosDao.list() );
                            break;
                        case "Agregar":
                                productosDao.save( 
                                    new Producto(
                                        request.getParameter( "txtNombre" ),
                                        Double.parseDouble( request.getParameter( "txtPrecio" ) ),
                                        Integer.parseInt( request.getParameter( "txtStock" ) ) ,
                                        request.getParameter( "txtEstado" )
                                    )
                                );
                                
                                request.getRequestDispatcher( "Controller?menu=Producto&action=Listar" ).
                                    forward( request, response );
                            break;
                        case "Editar":
                                idProducto = Integer.parseInt( request.getParameter( "id" ) );
                                request.setAttribute( "productoEdit" , productosDao.getProducto( idProducto ));
                                
                                request.getRequestDispatcher( "Controller?menu=Producto&action=Listar" ).
                                    forward( request, response );
                            break;
                        case "Actualizar":
                                productosDao.update(
                                    new Producto(
                                        idProducto,
                                        request.getParameter( "txtNombre" ),
                                        Double.parseDouble( request.getParameter( "txtPrecio" ) ),
                                        Integer.parseInt( request.getParameter( "txtStock" ) ) ,
                                        request.getParameter( "txtEstado" )
                                    )
                                );
                                
                                request.getRequestDispatcher( "Controller?menu=Producto&action=Listar" ).
                                    forward( request, response );
                            break;
                        case "Eliminar":
                                productosDao.delete( Integer.parseInt(request.getParameter( "id" )) );
                            
                                request.getRequestDispatcher( "Controller?menu=Producto&action=Listar" ).
                                    forward( request, response );
                            break;
                        default:
                            throw new AssertionError();
                    }//end switch
                
                    redirect(request, response, "producto.jsp" );
                break;
            case "Empleado":
                    switch ( action ) 
                    {
                        case "Listar":
                                request.setAttribute( "empleados", empleadoDao.list() );
                            break;
                        case "Agregar":
                                empleadoDao.save( new Empleado(
                                    request.getParameter( "txtDni" ),
                                    request.getParameter( "txtNombres" ),
                                    request.getParameter( "txtTelefono" ),
                                    request.getParameter( "txtEstado" ),
                                    request.getParameter( "txtUser" )
                                ) );
                                
                                request.getRequestDispatcher( "Controller?menu=Empleado&action=Listar" ).
                                    forward( request, response );
                            break;
                        case "Editar":
                                idEmpleado = Integer.parseInt(request.getParameter( "id" ));
                                
                                request.setAttribute( "empleadoEdit",
                                    empleadoDao.getIdEmpleado( idEmpleado )
                                );
                                
                                request.getRequestDispatcher( "Controller?menu=Empleado&action=Listar" ).
                                    forward( request, response );
                            break;
                        case "Actualizar":
                                empleadoDao.update( new Empleado( 
                                    idEmpleado, 
                                    request.getParameter( "txtDni" ),
                                    request.getParameter( "txtNombres" ),
                                    request.getParameter( "txtTelefono" ),
                                    request.getParameter( "txtEstado" ),
                                    request.getParameter( "txtUser" )
                                ) );
                            
                                request.getRequestDispatcher( "Controller?menu=Empleado&action=Listar" ).
                                    forward( request, response );
                            break;
                        case "Eliminar":
                                empleadoDao.delete( Integer.parseInt( 
                                    request.getParameter( "id" )
                                ) );
                            
                                request.getRequestDispatcher( "Controller?menu=Empleado&action=Listar" ).
                                    forward( request, response );
                            break;
                        default:
                            throw new AssertionError();
                    }//end switch
                    
                    redirect(request, response, "empleado.jsp" );
                break;
            case "Cliente":
                    switch ( action ) 
                    {
                    case "Listar":
                            
                            request.setAttribute( "clientes", clienteDao.list() );
                        break;
                    case "Agregar":
                            
                            clienteDao.save(
                                new Cliente(
                                    request.getParameter( "txtDni" ),
                                    request.getParameter( "txtNombre" ),
                                    request.getParameter( "txtDireccion" ),
                                    request.getParameter( "txtEstado" )
                                )
                            );
                        
                            request.getRequestDispatcher( "Controller?menu=Cliente&action=Listar" ).
                                forward( request, response );
                        break;
                    case "Actualizar":
                            
                            clienteDao.update( 
                                new Cliente(
                                    idCliente,
                                    request.getParameter( "txtDni" ),
                                    request.getParameter( "txtNombre" ),
                                    request.getParameter( "txtDireccion" ),
                                    request.getParameter( "txtEstado" )
                                ) 
                            );
                                    
                            request.getRequestDispatcher( "Controller?menu=Cliente&action=Listar" ).
                                forward( request, response );
                        break;
                    case "Eliminar":
                            
                            clienteDao.delete( 
                                Integer.parseInt( 
                                    request.getParameter( "id" ) 
                                ) 
                            );
                            
                            request.getRequestDispatcher( "Controller?menu=Cliente&action=Listar" ).
                                forward( request, response );
                        break;
                    case "Editar":
                        
                            idCliente = Integer.parseInt(request.getParameter( "id" ));
                            
                            request.setAttribute( "clienteEdit"  ,
                                clienteDao.getCliente( idCliente ));
                            
                            request.getRequestDispatcher( "Controller?menu=Cliente&action=Listar" ).
                                forward( request, response );
                        break;
                    default:
                        throw new AssertionError();
                }
                
                    redirect(request, response, "cliente.jsp" );
                break;
            case "NuevaVenta":
                switch (action) 
                {
                    case "BuscarCliente":
                        
                            cliente = clienteDao.getClienteDni( 
                                    request.getParameter( "txtCodigoCliente" )
                                );
                            
                            request.setAttribute( "cliente", cliente );
                            request.setAttribute( "numSerie", this.numeroSerie );
                        break;
                    case "BuscarProducto":
                        
                            producto = productosDao.getProducto(  
                                Integer.parseInt( request.getParameter( "txtCodigoProducto" ) )
                            );
                            
                            request.setAttribute( "cliente", cliente );
                            request.setAttribute( "producto", producto );
                            request.setAttribute( "listaVentas", lista );
                            request.setAttribute( "totalPagar", totalPagar );
                            request.setAttribute( "numSerie", this.numeroSerie );
                        break;
                    case "Agregar al carrito":
                            
                            // counter
                            item += 1;
                            cantidad = Integer.parseInt( request.getParameter( "txtCantidad" ) );
                            subTotal = producto.getPrecio() * cantidad;
                            
                            lista.add(
                                new Venta(
                                    producto.getIdProducto(), 
                                    item, 
                                    producto.getNombres(),
                                    producto.getPrecio(),
                                    cantidad,
                                    subTotal
                                )
                            );
                            
                            lista.forEach( 
                                obj -> totalPagar += obj.getSubTotal() 
                            );
                            
                            request.setAttribute( "cliente", cliente );
                            request.setAttribute( "totalPagar", totalPagar );
                            request.setAttribute( "listaVentas", lista );
                            request.setAttribute( "numSerie", this.numeroSerie );
                        break;
                    case "Generar Venta":
                            //Actualizar Stock
                            lista.forEach( obj -> {
                                Producto p = new Producto();
                                
                                int cantidad = obj.getCantidad();
                                int idProducto = obj.getIdProducto();
                                
                                p = productosDao.getProducto( idProducto );
                                int stockActual = p.getStock() - cantidad;
                                productosDao.stockUpdate( idProducto , stockActual );
                            });
                        
                            // Guardar Venta
                            venta.setIdCliente( this.cliente.getIdCliente() );
                            venta.setIdEmpleado( 2 );
                            venta.setNumSerie( this.numeroSerie );
                            venta.setFecha( new java.util.Date() );
                            venta.setMonto( this.totalPagar );
                            venta.setEstado( "1" );
                            
                            Logger.getLogger( Controller.class ).info( venta.toString() );
                            ventaDao.save( venta );
                            
                            // Guardar Detalle venta
                            int idVenta = Integer.parseInt( ventaDao.getIdVenta() );
                            lista.forEach( obj -> {
                                venta = new Venta();
                                venta.setId( idVenta );
                                venta.setIdProducto( obj.getIdProducto() );
                                venta.setCantidad( obj.getCantidad() );
                                venta.setPrecio( obj.getPrecio() );
                                
                                ventaDao.saveDetalleVenta( venta );
                            } );
                            
                            lista=new ArrayList<>();
                        break;
                    default:
                        venta = new Venta();
                        lista = new ArrayList<>();
                        item = 0;
                        totalPagar = 0.0;                
                        this.numeroSerie = ventaDao.generarSerie();
                        
                        if( this.numeroSerie == null ){

                            this.numeroSerie = "00000001";
                            request.setAttribute( "numSerie", this.numeroSerie );
                        }else{

                            int incrementar = Integer.parseInt( this.numeroSerie );

                            CodeGenerate cg = new CodeGenerate();
                            this.numeroSerie = cg.numeroSerie( incrementar );

                            request.setAttribute( "numSerie", this.numeroSerie );
                        }//end if-else
                }//end switch
                
                    redirect(request, response, "nuevaVenta.jsp" );
                break;
        }//end switch
    }//end method processRequest
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {    
        processRequest(request, response);
    }//end method doGet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {   
        processRequest(request, response);
    }//end method doPost
    
    public void resend( HttpServletRequest request, HttpServletResponse response,
        String message, String url )throws IOException, ServletException
    {
        request.getSession().setAttribute( "infoMessage", message);
            response.sendRedirect( url );
    }//end method resend

    public void redirect( HttpServletRequest request,
        HttpServletResponse response, String page ) throws IOException, ServletException
    {
        request.getRequestDispatcher("/WEB-INF/template/" + page)
            .forward(request, response);
    }//end method redirect
}//end class Controller
