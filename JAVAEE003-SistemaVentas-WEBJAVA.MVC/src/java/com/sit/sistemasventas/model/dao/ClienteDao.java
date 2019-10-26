/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.model.dao;

import com.sun.istack.internal.logging.Logger;

import com.sit.sistemasventas.interfaces.Crud;
import com.sit.sistemasventas.model.vo.Cliente;
import com.sit.sistemasventas.configuration.Conexion;
import com.sit.sistemasventas.constants.CrudClienteConstants;


import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.List;
import java.util.ArrayList;

public class ClienteDao implements Crud 
{
    private Connection connection;
    private Conexion conexion;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;
    
    @Override
    public <T> int save(T object) 
    {
        Cliente cliente = ( Cliente ) object;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement( 
                CrudClienteConstants.SAVE.getQuery() );
                this.preparedStatement.setString( 1, cliente.getDni() );
                this.preparedStatement.setString( 2, cliente.getNombres() );
                this.preparedStatement.setString( 3, cliente.getDireccion() );
                this.preparedStatement.setString( 4, cliente.getEstado() );
            
            if(this.preparedStatement.executeUpdate() == 1 )
            {
                Logger.getLogger( ClienteDao.class ).info( "Successful aggregation!" );
                
                return 1;
            }//end if
        }//end try 
        
        catch (Exception e) {
            
            Logger.getLogger( ClienteDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//end finally
        
        return 0;
    }//end method save

    @Override
    public <T> List<T> list() 
    {
        List<Cliente> clientes = null;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement(
                CrudClienteConstants.LIST_ALL.getQuery() );
            
            this.resultSet = this.preparedStatement.executeQuery();
            clientes = new ArrayList<Cliente>();
            while( this.resultSet.next() )
            {    
                clientes.add( new Cliente(
                    this.resultSet.getInt( 1 ),
                    this.resultSet.getString( 2 ),
                    this.resultSet.getString( 3 ),
                    this.resultSet.getString( 4 ),
                    this.resultSet.getString( 5 )    
                ) );
            }//end while
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( ClienteDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//end finally
        
        return ( List<T> ) clientes;
    }//end method list

    @Override
    public <T> int update(T object) 
    {
        Cliente cliente = ( Cliente ) object;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement(
                CrudClienteConstants.UPDATE.getQuery() );
                this.preparedStatement.setString( 1, cliente.getDni() );
                this.preparedStatement.setString( 2, cliente.getNombres() );
                this.preparedStatement.setString( 3, cliente.getDireccion() );
                this.preparedStatement.setString( 4, cliente.getEstado() );
                this.preparedStatement.setInt( 5, cliente.getIdCliente() );
                
            if( this.preparedStatement.executeUpdate() == 1 )
            {    
                Logger.getLogger( EmpleadoDao.class ).info( "Successful update!" );
                
                return 1;
            }//end if
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( ClienteDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//end disconnect
        
        return 0;
    }//end method update

    public Cliente getClienteDni( String dni )
    {
        Logger.getLogger( ClienteDao.class ).info( dni );
        Cliente cliente = null;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement(
                CrudClienteConstants.LIST_UNIQUE_FOR_DNI.getQuery() );
                    this.preparedStatement.setString( 1, dni );
                
            this.resultSet = this.preparedStatement.executeQuery();
            while( this.resultSet.next() ){
                
                cliente = new Cliente(
                    this.resultSet.getInt( 1 ),
                    this.resultSet.getString( 2 ),
                    this.resultSet.getString( 3 ),
                    this.resultSet.getString( 4 ),
                    this.resultSet.getString( 5 )
                );
            }//end while
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( ClienteDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//end finally
        
        return cliente;
    }//end method getClienteDni
            
    public Cliente getCliente( int id )
    {
        Cliente cliente = null;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement(
                CrudClienteConstants.LIST_UNIQUE.getQuery() );
                this.preparedStatement.setInt( 1, id );
                
            this.resultSet = this.preparedStatement.executeQuery();
            while( this.resultSet.next() ){
                
                cliente = new Cliente(
                    this.resultSet.getString( 2 ),
                    this.resultSet.getString( 3 ),
                    this.resultSet.getString( 4 ),
                    this.resultSet.getString( 5 )
                );
            }//end while
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( ClienteDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//end finally
        
        return cliente;
    }//end method getCliente
    
    @Override
    public void delete(int id) 
    {
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement(
                CrudClienteConstants.DELETE.getQuery() );
                this.preparedStatement.setInt( 1 , id );
            
            if( this.preparedStatement.executeUpdate() == 1 ){
                
                Logger.getLogger( ClienteDao.class ).info( "Successful removal!" );
            }//end if
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( ClienteDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//end finally
    }//end method delete

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
}//end class ClienteDao
