/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import java.util.List;

import com.sit.sistemasventas.configuration.Conexion;
import com.sit.sistemasventas.constants.CrudProductoConstants;
import com.sit.sistemasventas.model.vo.Producto;
import com.sit.sistemasventas.interfaces.Crud;
import com.sun.istack.internal.logging.Logger;
import java.util.ArrayList;

public class ProductoDao implements Crud
{
    private Conexion conexion;
    private Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    @Override
    public <T> int save(T object) 
    {
        Producto producto = (Producto) object;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement( 
                CrudProductoConstants.SAVE.getQuery() );
                this.preparedStatement.setString( 1, producto.getNombres() );
                this.preparedStatement.setDouble( 2, producto.getPrecio() );
                this.preparedStatement.setInt( 3, producto.getStock() );
                this.preparedStatement.setString( 4, producto.getEstado() );
                
            if( this.preparedStatement.executeUpdate() == 1 )
            {    
                Logger.getLogger( ProductoDao.class ).info( "Successful aggregation!" );
                
                return 1;
            }//end if
        }//end try
        
        catch (Exception e) {
            Logger.getLogger( ProductoDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            disconnect();
        }//end finally
        
        return 0;
    }//end save method

    @Override
    public <T> List<T> list() 
    {
        List<Producto> productos = null;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement( 
                CrudProductoConstants.LIST_ALL.getQuery()  );
            
            this.resultSet = this.preparedStatement.executeQuery();
            productos = new ArrayList<Producto>();
            
            while ( this.resultSet.next() ) {
                
                productos.add( new Producto(
                    this.resultSet.getInt( 1 ),
                    this.resultSet.getString( 2 ),
                    this.resultSet.getDouble( 3 ),
                    this.resultSet.getInt( 4 ),
                    this.resultSet.getString( 5 )
                ) );
            }//end while
        }//end try
        
        catch (Exception e) {
            Logger.getLogger( ProductoDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            disconnect();
        }//end finally
        
        return (List<T>) productos;
    }//end list method

    public Producto getProducto( int id )
    {
        Producto producto = null;
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement( 
                CrudProductoConstants.SELECT_UNIQUE.getQuery() );
                this.preparedStatement.setInt( 1 , id );
                
            this.resultSet = this.preparedStatement.executeQuery();
            while( this.resultSet.next() )
            {    
                producto = new Producto(
                    this.resultSet.getInt( 1 ),
                    this.resultSet.getString( 2 ),
                    this.resultSet.getDouble( 3 ),
                    this.resultSet.getInt( 4 ),
                    this.resultSet.getString( 5 )
                );
            }//end while
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( ProductoDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//end method finally
        
        return producto;
    }//end method getProducto
    
    public int stockUpdate( int id, int stock )
    {
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement(
                CrudProductoConstants.STOCK_UPDATE.getQuery() );
            
                this.preparedStatement.setInt( 1, stock );
                this.preparedStatement.setInt( 2, id );
                
            if( this.preparedStatement.executeUpdate() == 1 )
            {
                System.out.printf( "Successful update!" );
                return 1;
            }//end if
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( ProductoDao.class ).warning( e.getMessage() );
        }//end catch
        
        return 0;
    }
    
    @Override
    public <T> int update(T object) 
    {
        Producto producto = (Producto) object;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement( 
                CrudProductoConstants.UPDATE.getQuery() );
                this.preparedStatement.setString( 1, producto.getNombres() );
                this.preparedStatement.setDouble( 2, producto.getPrecio() );
                this.preparedStatement.setInt( 3, producto.getStock() );
                this.preparedStatement.setString( 4, producto.getEstado() );
                this.preparedStatement.setInt( 5, producto.getIdProducto() );
            
            if( this.preparedStatement.executeUpdate() == 1 )
            {    
                Logger.getLogger( EmpleadoDao.class ).info( "Successful update!" );
                
                return 1;
            }//end if
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( ProductoDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            disconnect();
        }//end finally
        
        return 0;
    }//end update method

    @Override
    public void delete( int id ) 
    {
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement( 
                CrudProductoConstants.DELETE.getQuery() );
                this.preparedStatement.setInt( 1 , id);
            
            if( this.preparedStatement.executeUpdate() == 1 ){
                
                Logger.getLogger( EmpleadoDao.class ).info( "Successful removal!" );
            }//end if
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( ProductoDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//end finally
    }//end delete method

    @Override
    public void disconnect() 
    {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch ( Exception e ) {
            Logger.getLogger(EmpleadoDao.class ).warning( e.getMessage() );
        }//end try-catch
    }//end disconnect method
}//end class ProductoDao
