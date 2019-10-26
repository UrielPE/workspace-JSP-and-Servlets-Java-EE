/**
 *
 * @author Uriel
 */
package com.modelo.conexion;

import javax.sql.DataSource;
import java.sql.Connection;
import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;


public class ConexionPOOL
{
    BasicDataSource basicDataSource ;
    DataSource dataSource ;
    
    public ConexionPOOL()
    {
        
            basicDataSource = new BasicDataSource();
                basicDataSource.setDriverClassName( "com.mysql.jdbc.Driver" );
                basicDataSource.setUsername( "root" );
                basicDataSource.setPassword( "" );
                basicDataSource.setUrl( "jdbc:mysql://localhost:3306/proyecto_jsp" );

                basicDataSource.setMaxTotal(50);
                basicDataSource.setMaxIdle( 50 );
                basicDataSource.setRemoveAbandonedOnBorrow(true);
                basicDataSource.setRemoveAbandonedTimeout( 5000 );
                basicDataSource.setMaxWaitMillis( 6000 );

                dataSource = basicDataSource;
    }

    public DataSource getConnection() 
    {
        return dataSource;
    }    
}//end class
