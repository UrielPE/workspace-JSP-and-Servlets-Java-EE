/**
 *
 * @author uriel.pena
 */
package sit.ecommerce.model.dao;

import com.sun.istack.internal.logging.Logger;
import java.util.List;
import java.util.ArrayList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import sit.ecommerce.model.conexion.Conexion;
import sit.ecommerce.model.vo.Marca;

public class MarcaDAO 
{
    private static Conexion conexion;
    private static ResultSet resultSet;
    private static Connection connection;
    private static CallableStatement callableStatement;
    
    public static List<Marca> listarTodoMarcas()
    {
        List<Marca> lista = null;
        
        try 
        {
            conexion = new Conexion();
            connection = conexion.getConnection();
            
            callableStatement = connection.prepareCall( "{call sp_listarTodoDeMarca()}" );
            resultSet = callableStatement.executeQuery();
            
            lista = new ArrayList<Marca>();
            while( resultSet.next() ){
                lista.add(
                    new Marca(
                        resultSet.getInt( 1 ),
                        resultSet.getString( 2 )
                    )
                );
            }//end while
        }//end try 
        
        catch (Exception e) {
            
            e.printStackTrace();
        }//end catch
        
        finally{
           disconnect();
           return lista;
        }
    }//end method listarTodoMarcas
    
    public static int contarMarcas( int codigoMarca )
    {           
        try 
        {
            conexion = new Conexion();
            connection = conexion.getConnection();
            
            callableStatement = connection.prepareCall( "{call sp_contarProductosMarca( ? )}" );
            callableStatement.setInt( 1, codigoMarca );
            
            resultSet = callableStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt( 1 );
        }//end try 
        
        catch (Exception e) {
            
            e.printStackTrace();
            return 0;
        }//end catch
        
        finally{
           disconnect();
        }
    }//end method listarTodoMarcas
    
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
            
            Logger.getLogger( CategoriaDao.class ).warning( e.getMessage() );
        }//end catch
    }//end method disconnect
    
    public static void main(String[] args) {
        for( Marca m: MarcaDAO.listarTodoMarcas() )
            System.out.println( m );
    }
}//end clas MarcaDAO
