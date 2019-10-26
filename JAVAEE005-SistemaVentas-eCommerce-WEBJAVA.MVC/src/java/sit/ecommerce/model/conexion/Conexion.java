/**
 *
 * @author URIEL
 */
package sit.ecommerce.model.conexion;

import com.sun.istack.internal.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion 
{
    private Connection connection;
    
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "root";
    private String password = "";
    private String bd = "workspace_ecommerce";
    private String url = "jdbc:mysql://localhost:3306/"+bd;
    
    public Conexion()
    {
        try 
        {
            Class.forName( driver );
            
            this.connection = DriverManager.getConnection(
                url, user, password  );
            
            if( this.connection != null )
                Logger.getLogger( Conexion.class ).info( "Succesfull connection!" );
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( Conexion.class ).warning( e.getMessage() );
        }//end catch
    }//end constructor
    
    public Connection getConnection()
    {
        return this.connection;
    }//end method getConnection
    
    public void disconnect() throws SQLException
    {    
        if(!this.connection.isClosed())
            this.connection.close();
    }//end method disconnect
}//end class Conexion
