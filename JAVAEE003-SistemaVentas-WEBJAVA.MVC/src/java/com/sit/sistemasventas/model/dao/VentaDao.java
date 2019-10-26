/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.model.dao;

import com.sit.sistemasventas.configuration.Conexion;
import com.sit.sistemasventas.constants.CrudVentaConstants;
import com.sit.sistemasventas.interfaces.Crud;

import com.sit.sistemasventas.model.vo.Venta;

import com.sun.istack.internal.logging.Logger;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.List;

public class VentaDao implements Crud
{
    private Conexion conexion;
    private ResultSet resultSet;
    private Connection connection;
    private PreparedStatement preparedStatement;
    
    public String generarSerie()
    {
        String numeroSerie = "";
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement( 
                CrudVentaConstants.SERIE_NUM.getQuery() );
            
            this.resultSet = this.preparedStatement.executeQuery();
            while( this.resultSet.next() ){
                
                numeroSerie = this.resultSet.getString( 1 );
            }//end while
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( VentaDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//disconnect
        
        return numeroSerie;
    }//end method generarSerie
    
    public String getIdVenta(){
        
        String idVenta = "";
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement(
                CrudVentaConstants.SALE_ID.getQuery() );
            
            this.resultSet = this.preparedStatement.executeQuery();
            while( this.resultSet.next() ){
                
                idVenta = this.resultSet.getString( 1 );
            }//end while
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( VentaDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//end finally
        
        return idVenta;
    }//end method getIdVenta
    
    public int saveDetalleVenta( Object obj )
    {
        Venta venta = (Venta) obj;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection =  this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement(
                CrudVentaConstants.SAVE_SALE_DETAIL.getQuery() );
                this.preparedStatement.setInt( 1, 1 );
                this.preparedStatement.setInt( 2, venta.getId() );
                this.preparedStatement.setInt( 3, venta.getIdProducto() );
                this.preparedStatement.setInt( 4, venta.getCantidad() );
                this.preparedStatement.setDouble( 5, venta.getPrecio() );
            
            if( this.preparedStatement.executeUpdate() == 1 )
            {    
                Logger.getLogger( VentaDao.class ).info( "Successful aggregation!" );
                
                return 1;
            }//end if
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( VentaDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//end finally
        
        return 0;
    }//end method saveDetalleVenta
    
    @Override
    public <T> int save(T object) 
    {
        Venta venta = ( Venta ) object;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement(
                CrudVentaConstants.SAVE.getQuery() );
                this.preparedStatement.setInt( 1, 0 );
                this.preparedStatement.setInt( 2, venta.getIdCliente() );
                this.preparedStatement.setInt( 3, venta.getIdEmpleado() );
                this.preparedStatement.setString( 4, venta.getNumSerie() );
                this.preparedStatement.setDate( 5 , 
                    new java.sql.Date(
                        venta.getFecha().getTime()
                    ) 
                );
                this.preparedStatement.setDouble( 6, venta.getMonto() );
                this.preparedStatement.setString( 7, venta.getEstado() );
            
            if( this.preparedStatement.executeUpdate() == 1 )
            {    
                Logger.getLogger( VentaDao.class ).info( "Successful aggregation!" );
                
                return 1;
            }//end if
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( VentaDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//end finally
        
        return 0;
    }//end method save

    @Override
    public <T> List<T> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> int update(T object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void disconnect() 
    {
        try 
        {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch ( Exception e ) {
            Logger.getLogger(EmpleadoDao.class ).warning( e.getMessage() );
        }//end try-catch
    }//end method disconnect
}//end class VentaDao
