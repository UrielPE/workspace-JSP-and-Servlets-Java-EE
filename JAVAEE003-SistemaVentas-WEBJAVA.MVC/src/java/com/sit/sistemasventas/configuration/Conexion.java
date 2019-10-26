/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.configuration;

import com.sun.istack.internal.logging.Logger;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class Conexion 
{
    private Connection connection;
    private DataSource dataSource;
    private BasicDataSource basicDataSource ;
    
    private String driver = "com.mysql.jdbc.Driver";
    private String username = "root";
    private String password = "";
    private String bd = "workspace_ventas";
    private String url = "jdbc:mysql://localhost:3306/" + bd;
    
    public Conexion()
    {
        try 
        {
            this.basicDataSource = new BasicDataSource();
                //Connection configuration
                this.basicDataSource.setDriverClassName( driver );
                this.basicDataSource.setUrl( url );
                this.basicDataSource.setUsername( username );
                this.basicDataSource.setPassword( password );
                
                //Pool configuration
                this.basicDataSource.setMaxTotal( 50 );
                this.basicDataSource.setMaxIdle( 50 );
                this.basicDataSource.setRemoveAbandonedOnBorrow( true );
                this.basicDataSource.setRemoveAbandonedTimeout( 5000 );
                this.basicDataSource.setMaxWaitMillis( 6000 );
            
            this.dataSource = this.basicDataSource;
            this.connection = this.dataSource.getConnection();
        }//end try
        
        catch (SQLException e) {
            Logger.getLogger( Conexion.class ).severe( e.getMessage() );
        }//end catch
    }//end constructor  
    
    public Connection getConnection(){
        
        return this.connection;
    }//end method getConnetion
    
    public void disconnect() throws SQLException{
        
        if( !this.connection.isClosed() )
            this.connection.close();
    }//end method disconnect
}//end class Conexion
