/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.model.dao;

import com.sit.sistemasventas.configuration.Conexion;
import com.sit.sistemasventas.constants.CrudEmpleadoConstants;
import com.sit.sistemasventas.model.vo.Empleado;
import com.sit.sistemasventas.interfaces.Crud;

import com.sun.istack.internal.logging.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao implements Crud
{
    private Conexion conexion;
    private ResultSet resultSet;
    private Connection connection;
    private PreparedStatement preparedStatement;
    
    public Empleado validar( Empleado empleado )
    {
        this.conexion = new Conexion();
        this.connection = conexion.getConnection();
        
        Empleado newEmpleado = null;
        String query = "SELECT * FROM empleado WHERE User = ? and Dni = ?;";
        try 
        { 
            this.preparedStatement = this.connection.prepareStatement( query );
                this.preparedStatement.setString( 1, empleado.getUser()); 
                this.preparedStatement.setString( 2, empleado.getDni() );
            
            this.resultSet = this.preparedStatement.executeQuery();
            while( this.resultSet.next() ){
                newEmpleado = new Empleado(
                    resultSet.getInt( 1 ),
                    resultSet.getString( 2 ),
                    resultSet.getString( 3 ),
                    resultSet.getString( 4 ),
                    resultSet.getString( 5 ),
                    resultSet.getString( 6 )
                );
            }//end while
        }//end try
        
        catch (Exception e) {
            Logger.getLogger( EmpleadoDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            //method that close resource
            disconnect();
        }//end finally
        
        return newEmpleado;
    }//end method validar
    
    @Override
    public <T> int save( T object) 
    {   
        Empleado empleado = ( Empleado ) object;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement( 
                CrudEmpleadoConstants.SAVE.getStatement() );
                this.preparedStatement.setInt( 1, 0 );
                this.preparedStatement.setString( 2, empleado.getDni() );
                this.preparedStatement.setString( 3, empleado.getNombre());
                this.preparedStatement.setString( 4, empleado.getTelefono());
                this.preparedStatement.setString( 5, empleado.getEstado());
                this.preparedStatement.setString( 6, empleado.getUser());        
                
           if( this.preparedStatement.executeUpdate() == 1 ){
                Logger.getLogger( EmpleadoDao.class ).info( "Successful aggregation!" );
                
                return 1;
            }//end if
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( EmpleadoDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
        }//end finally
        
        return 0;
    }//end save method

    @Override
    public <T> List<T> list() 
    {
        List<Empleado> empleados = null;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement(
                CrudEmpleadoConstants.SELECT_ALL.getStatement() );
            
            this.resultSet = this.preparedStatement.executeQuery();
            empleados = new ArrayList<Empleado>();
            
            while( this.resultSet.next() ){
                empleados.add( new Empleado(
                    this.resultSet.getInt(1),
                    this.resultSet.getString(2),
                    this.resultSet.getString(3),
                    this.resultSet.getString(4),
                    this.resultSet.getString(5),
                    this.resultSet.getString(6)
                ));
            }//end while 
            
            //method that close resource
            disconnect();
        }//end try
        
        catch (Exception e) {
            Logger.getLogger( EmpleadoDao.class ).warning( e.getMessage() );
        }//catch
        
        return (List<T>) empleados;
    }//end list method

    @Override
    public <T> int update(T object) 
    {
        Empleado empleado = (Empleado) object;
        
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement( 
                CrudEmpleadoConstants.UPDATE.getStatement() );
                this.preparedStatement.setString( 1, empleado.getDni() );
                this.preparedStatement.setString( 2, empleado.getNombre() );
                this.preparedStatement.setString( 3, empleado.getTelefono());
                this.preparedStatement.setString( 4, empleado.getEstado() );
                this.preparedStatement.setString( 5, empleado.getUser() );
                this.preparedStatement.setInt( 6, empleado.getIdEmpleado() );
                
            if( this.preparedStatement.executeUpdate() == 1 ){
                Logger.getLogger( EmpleadoDao.class ).info( "Successful update!" );
                
                return 1;
            }//end if
        }//end try
        
        catch (Exception e) {
            Logger.getLogger( EmpleadoDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            disconnect();
        }//end method finally
        
        return 0;
    }//end update method

    @Override
    public void delete(int id) 
    {
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement(
                CrudEmpleadoConstants.DELETE.getStatement());
                this.preparedStatement.setInt( 1 , id );
            
            if( this.preparedStatement.executeUpdate() == 1 ){
                Logger.getLogger( EmpleadoDao.class ).info( "Successful removal!" );
            }//end if
        }//end try
        
        catch (Exception e) {
            Logger.getLogger( EmpleadoDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            disconnect();
        }//end finally
    }//end delete method
    
    public Empleado getIdEmpleado( int id )
    {
        Empleado empleado = null;
        try 
        {
            this.conexion = new Conexion();
            this.connection = this.conexion.getConnection();
            
            this.preparedStatement = this.connection.prepareStatement( 
                CrudEmpleadoConstants.SELECTUNIQUE.getStatement() );
                this.preparedStatement.setInt( 1, id );
            
            this.resultSet = this.preparedStatement.executeQuery();
            while( this.resultSet.next() )
            {    
                empleado = new Empleado(
                    this.resultSet.getInt( 1 ),
                    this.resultSet.getString( 2 ),
                    this.resultSet.getString( 3 ),
                    this.resultSet.getString( 4 ),
                    this.resultSet.getString( 5 ),
                    this.resultSet.getString( 6 )
                );
            }//end while
        }//end try
        
        catch (Exception e) {
            Logger.getLogger( EmpleadoDao.class ).info( e.getMessage() );
        }//end catch
        
        finally{
            disconnect();
        }//end finally
        
        return empleado;
    }//end getIdEmpleado method
    
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
    }//end method diconnect  
}//end class EmpleadoDao