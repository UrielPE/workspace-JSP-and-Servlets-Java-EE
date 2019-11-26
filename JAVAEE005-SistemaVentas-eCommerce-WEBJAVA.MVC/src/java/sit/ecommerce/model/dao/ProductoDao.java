/**
 *
 * @author uriel.pena
 */
package sit.ecommerce.model.dao;

import java.util.logging.Logger;
import java.util.List;
import java.util.ArrayList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import sit.ecommerce.model.conexion.Conexion;
import sit.ecommerce.model.vo.Producto;
import sit.ecommerce.model.vo.ProductoMoneda;

public class ProductoDao 
{
    private static final Logger LOG = Logger.getLogger(ProductoDao.class.getName());
    
    private static Conexion conexion;
    private static ResultSet resultSet;
    private static Connection connection;
    private static CallableStatement callableStatement;
   
    public static boolean saveProducto( Producto producto, 
        ProductoMoneda pmColombiano,ProductoMoneda pmEstadosUni,ProductoMoneda pmVenezolano )
    {
        try 
        {
            conexion = new Conexion();
            connection = conexion.getConnection();
            
            callableStatement = connection.prepareCall( "{call sp_registrarProducto("
                    + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}" );
                          
                callableStatement.setString( 1, producto.getNombre() );
                callableStatement.setFloat( 2, producto.getPrecio() );
                callableStatement.setFloat( 3, producto.getPrecio_nuevo());
                callableStatement.setFloat( 4, producto.getStock() );
                callableStatement.setBoolean(5, producto.isNuevo());
                callableStatement.setBoolean( 6, producto.isRecomendado());
                callableStatement.setString( 7, producto.getDescripcion());
                callableStatement.setBoolean(8, producto.isNuevo());
                callableStatement.setInt( 9 , producto.getCod_marca() );
                callableStatement.setInt( 10 , producto.getCod_categoria() );
                callableStatement.setString( 11 , producto.getImagen() );
                
                callableStatement.setString( 12,pmColombiano.getMoneda() );
                callableStatement.setFloat( 13, pmColombiano.getPrecio() );
                callableStatement.setFloat( 14, pmColombiano.getPrecio_nuevo() );
                
                callableStatement.setString( 15, pmEstadosUni.getMoneda() );
                callableStatement.setFloat( 16, pmEstadosUni.getPrecio() );
                callableStatement.setFloat( 17, pmEstadosUni.getPrecio_nuevo());
                
                callableStatement.setString( 18,pmVenezolano.getMoneda() );
                callableStatement.setFloat( 19, pmVenezolano.getPrecio() );
                callableStatement.setFloat( 20, pmVenezolano.getPrecio_nuevo());
                
            return callableStatement.executeUpdate() > 0;
        } 
        
        catch (Exception e) {
            
            e.printStackTrace();
            return false;
        }
    
        finally{
            disconnect();
        }
    }
    
    public static List<Producto> listarProductosRecomendados( String moneda )
    {
        List<Producto> productos =  null;
        
        try 
        {
            conexion = new Conexion();
            connection = conexion.getConnection();
            
            callableStatement = connection.prepareCall( "{call sp_listarRecomendados(?)}" );
            callableStatement.setString( 1, moneda );
            
            resultSet = callableStatement.executeQuery();
            
            productos = new ArrayList<Producto>();
            while( resultSet.next() ){
                
                
                Producto product = new Producto();
                    product.setWebid( resultSet.getInt( "webid" )  );
                    product.setNombre( resultSet.getString( "nombre" ) );
                    product.setImagen( resultSet.getString( "imagen" ) );
                    product.setStock( resultSet.getInt( "stock" ) );
                    product.setNuevo( resultSet.getBoolean( "nuevo" ) );
                    
                    if( !moneda.equalsIgnoreCase( "MXN" ) )
                    {
                        product.setPrecio( resultSet.getFloat( "precio2" ) );
                        product.setPrecio_nuevo( resultSet.getFloat( "precion2" ) );
                    }else{
                        product.setPrecio( resultSet.getFloat( "precio" ) );
                        product.setPrecio_nuevo( resultSet.getFloat( "precio_nuevo" ) );
                    }
                
                productos.add( product );      
            }
        } 
        
        catch (Exception e) {
            
            e.printStackTrace();
        }
        
        finally{
            disconnect();
        }
        
        return productos;
    }
    
    
    public static List<Producto> listarProductosPorCategoria( String moneda, int cat )
    {
        List<Producto> productos =  null;
        
        try 
        {
            conexion = new Conexion();
            connection = conexion.getConnection();
            
            callableStatement = connection.prepareCall( "{call sp_listarPorCategoria(?, ?)}" );
            callableStatement.setString( 1, moneda );
            callableStatement.setInt( 2, cat );
            
            resultSet = callableStatement.executeQuery();
            
            productos = new ArrayList<Producto>();
            while( resultSet.next() ){
                
                
                Producto product = new Producto();
                    product.setWebid( resultSet.getInt( "webid" )  );
                    product.setNombre( resultSet.getString( "nombre" ) );
                    product.setImagen( resultSet.getString( "imagen" ) );
                    product.setStock( resultSet.getInt( "stock" ) );
                    product.setNuevo( resultSet.getBoolean( "nuevo" ) );
                    
                    if( !moneda.equalsIgnoreCase( "MXN" ) )
                    {
                        product.setPrecio( resultSet.getFloat( "precio2" ) );
                        product.setPrecio_nuevo( resultSet.getFloat( "precion2" ) );
                    }else{
                        product.setPrecio( resultSet.getFloat( "precio" ) );
                        product.setPrecio_nuevo( resultSet.getFloat( "precio_nuevo" ) );
                    }
                
                productos.add( product );      
            }
        } 
        
        catch (Exception e) {
            
            e.printStackTrace();
        }
        
        finally{
            disconnect();
        }
        
        return productos;
    }
    
    
    public static List<Producto> listarProductosPorMarca( String moneda, int mar )
    {
        List<Producto> productos =  null;
        
        try 
        {
            conexion = new Conexion();
            connection = conexion.getConnection();
            
            callableStatement = connection.prepareCall( "{call sp_listarPorMarca(?, ?)}" );
            callableStatement.setString( 1, moneda );
            callableStatement.setInt( 2, mar );
            
            resultSet = callableStatement.executeQuery();
            
            productos = new ArrayList<Producto>();
            while( resultSet.next() ){
                
                
                Producto product = new Producto();
                    product.setWebid( resultSet.getInt( "webid" )  );
                    product.setNombre( resultSet.getString( "nombre" ) );
                    product.setImagen( resultSet.getString( "imagen" ) );
                    product.setStock( resultSet.getInt( "stock" ) );
                    product.setNuevo( resultSet.getBoolean( "nuevo" ) );
                    
                    if( !moneda.equalsIgnoreCase( "MXN" ) )
                    {
                        product.setPrecio( resultSet.getFloat( "precio2" ) );
                        product.setPrecio_nuevo( resultSet.getFloat( "precion2" ) );
                    }else{
                        product.setPrecio( resultSet.getFloat( "precio" ) );
                        product.setPrecio_nuevo( resultSet.getFloat( "precio_nuevo" ) );
                    }
                
                productos.add( product );      
            }
        } 
        
        catch (Exception e) {
            
            e.printStackTrace();
        }
        
        finally{
            disconnect();
        }
        
        return productos;
    }
    
    public static Producto consultarProducto( String moneda, int webid )
    {
        Producto product =  null;
        
        try 
        {
            conexion = new Conexion();
            connection = conexion.getConnection();
            
            callableStatement = connection.prepareCall( "{call sp_consultarProducto(?, ?)}" );
            callableStatement.setString( 1, moneda );
            callableStatement.setInt( 2, webid );
            
            resultSet = callableStatement.executeQuery();
            
            if( resultSet.next() ){
                product = new Producto();
                    product.setWebid( resultSet.getInt( "webid" )  );
                    product.setNombre( resultSet.getString( "nombre" ) );
                    product.setImagen( resultSet.getString( "imagen" ) );
                    product.setStock( resultSet.getInt( "stock" ) );
                    product.setNuevo( resultSet.getBoolean( "nuevo" ) );
                    
                    if( !moneda.equalsIgnoreCase( "MXN" ) )
                    {
                        product.setPrecio( resultSet.getFloat( "precio2" ) );
                        product.setPrecio_nuevo( resultSet.getFloat( "precion2" ) );
                    }else{
                        product.setPrecio( resultSet.getFloat( "precio" ) );
                        product.setPrecio_nuevo( resultSet.getFloat( "precio_nuevo" ) );
                    }       
            }
        } 
        
        catch (Exception e) {
            
            e.printStackTrace();
        }
        
        finally{
            disconnect();
        }
        
        return product;
    }
    
    public static void disconnect()
    {
        try 
        {
            resultSet.close();
            callableStatement.close();
            connection.close();
            conexion.disconnect();
        }//end try
        
        catch (Exception e) {
            
            com.sun.istack.internal.logging.Logger.getLogger( CategoriaDao.class ).warning( e.getMessage() );
        }//end catch
    }//end method disconnect
    
    public static void main(String[] args) {
        System.out.println( ProductoDao.consultarProducto( "MXN" , 9 ) );
    }
}
