/**
 *
 * @author Uriel
 */
package com.modeloDAO;

import com.modeloVO.Producto;

import java.util.List;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import javax.sql.DataSource;


public class ProductoDAO 
{
    private Connection origenDatos ;
    
    private PreparedStatement miPS;
    private DataSource miConexion;
    private Statement  miStatement;
    private ResultSet  miResultSet;
    
    private String instruccionSQL_getProductos = "SELECT * FROM productos";
    
    private String instruccionSQL_insertProducto =
                    "INSERT INTO productos (CÓDIGOARTÍCULO,SECCIÓN,NOMBREARTÍCULO,"
                    + "PRECIO,FECHA,IMPORTADO,PAÍSDEORIGEN) "
                    + "VALUES (?,?,?,?,?,?,?)";
    
   private String instruccionSQL_getProducto = "SELECT * FROM productos WHERE "
                    + "CÓDIGOARTÍCULO=?";
    
   private String instruccionSQL_SQLUpdate = "UPDATE productos SET "
           + "SECCIÓN=?, NOMBREARTÍCULO=?, PRECIO=?, FECHA=?, IMPORTADO=?,"
           + "PAÍSDEORIGEN=? WHERE CÓDIGOARTÍCULO=? ;";
   
   private String instruccionSQL_SQLDelete = "DELETE FROM productos WHERE "
           + "CÓDIGOARTÍCULO=?;";



    public ProductoDAO( DataSource origenDatos )
    {
        this.miConexion = origenDatos;
    }//end constructor
        
    public List<Producto> getProductos() 
            throws java.sql.SQLException, ClassNotFoundException
    {
        List<Producto> productos = new ArrayList<Producto>();
                
        
        origenDatos = this.miConexion.getConnection();
        miStatement = origenDatos.createStatement();
        miResultSet = miStatement.executeQuery( instruccionSQL_getProductos );
        
        while( miResultSet.next() )
        {
            productos.add( 
                new Producto( 
                        miResultSet.getString(1),  
                        miResultSet.getString(2), 
                        miResultSet.getString(3), 
                        miResultSet.getString(4), 
                        miResultSet.getString(5), 
                        miResultSet.getString(6), 
                        miResultSet.getString(7)  
                )//end Producto()
            );//end add
        }//end while
        desconectar();
        
        return productos;
    }//end method getProductos
    
    public void agregarProducto( Producto miProducto )
            throws java.sql.SQLException, ClassNotFoundException
    {       
        origenDatos = miConexion.getConnection();
        miPS = 
            origenDatos.prepareStatement( instruccionSQL_insertProducto );                
            miPS.setString( 1 , miProducto.getCodigoArticulo() );
            miPS.setString( 2 , miProducto.getSeccion() );
            miPS.setString( 3 , miProducto.getNombreArticulo() );
            miPS.setString( 4 , miProducto.getPrecio() );
            miPS.setString( 5 , miProducto.getFecha() );
            miPS.setString( 6 , miProducto.getImportado() );
            miPS.setString( 7 , miProducto.getPaisOrigen() );
        miPS.execute();
        
        desconectar();
        System.out.println( "Agregado exitosamente!" );
    }//end method agregarProducto
    
    public void actualizaProducto( Producto miProducto ) throws Exception
    {
        origenDatos = miConexion.getConnection();
        miPS = 
            origenDatos.prepareStatement( instruccionSQL_SQLUpdate );
            miPS.setString( 1 , miProducto.getSeccion() );
            miPS.setString( 2 , miProducto.getNombreArticulo() );
            miPS.setString( 3 , miProducto.getPrecio() );
            miPS.setString( 4 , miProducto.getFecha() );
            miPS.setString( 5 , miProducto.getImportado() );
            miPS.setString( 6 , miProducto.getPaisOrigen() );
            miPS.setString( 7 , miProducto.getCodigoArticulo() );
        miPS.execute();    
        
        desconectar();
        System.out.println( "Actualizacion exitosa!" );
    }//end method actualizaProducto
    
    public Producto getProducto( String codigo_producto ) throws
            java.sql.SQLException, Exception
    {
        Producto miProducto = null ;
        origenDatos = miConexion.getConnection();
        
        miPS = origenDatos.prepareStatement( instruccionSQL_getProducto );
            miPS.setString( 1, codigo_producto );
        
        miResultSet = miPS.executeQuery();
        if( miResultSet.next() )        
        {
            miProducto = new Producto
            (  
                miResultSet.getString(1),      
                miResultSet.getString(2), 
                miResultSet.getString(3), 
                miResultSet.getString(4), 
                miResultSet.getString(5), 
                miResultSet.getString(6), 
                miResultSet.getString(7) 
            );
        }//end block if
        
        else
            throw new Exception( "Error: No hemos encontrado el artículo!" );
        
        desconectar();
        
        return miProducto ;
    }//end method getProducto

    public void eliminaProducto( String codigo_producto )
            throws Exception
    {
        origenDatos = miConexion.getConnection();
        
        miPS = origenDatos.prepareStatement( instruccionSQL_SQLDelete );
            miPS.setString( 1, codigo_producto ) ;
        miPS.executeUpdate();
                
        desconectar();
    }//end method eliminaProducto
    
    void desconectar()
    {
        try 
        {
            miResultSet.close();
            miPS.close();
            miStatement.close();
            origenDatos.close();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }//end try-catch
    }//end method desconectar
}//end class ProductoDAO

