/**
 *
 * @author uriel
 */
package mx.com.sit.comercializadora.model.connectionBd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB 
{
    private Connection connection;
    
    private String driver = "com.mysql.jdbc.Driver";
    private String username = "root";
    private String password = "root";
    private String db = "pedidos";
    private String url = "jdbc:mysql://localhost:3306/" + db;
    
    public ConnectionDB()
    {    
        try 
        {
            Class.forName( driver );
            connection =  DriverManager.getConnection( url, username, password );

            if( connection != null )
                System.out.println( "Successful connection!" );
        } catch (Exception e) {
            
            e.printStackTrace();
        }//end try-catch
    }//end ConnectionDB constructor
    
    public Connection getConnection(){
        
        return this.connection;
    }//end method getConnection
    
    public void disconnect() throws SQLException{
        if( !connection.isClosed() )
            this.connection = null;
    }//end method disconnect
}//end class ConnectionDB
