/**
 *
 * @author URIEL
 */
package sit.ecommerce.model.dao;

import com.sun.istack.internal.logging.Logger;
import java.util.List;
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.CallableStatement;

import sit.ecommerce.model.conexion.Conexion;
import sit.ecommerce.model.vo.Categoria;

public class CategoriaDao 
{
    private static Conexion conexion;
    private static ResultSet resultSet;
    private static Connection connection;
    private static CallableStatement callableStatement;
    
    public static List<Categoria> listarCategoriaSuperior()
    {
        List<Categoria> lista = null;
        
        try 
        {
            conexion = new Conexion();
            connection = conexion.getConnection();
            
            callableStatement = connection.prepareCall( "{call sp_listarCategoriaSuperior()}" );
            resultSet = callableStatement.executeQuery();
            
            lista = new ArrayList< Categoria >();
            while( resultSet.next() ){
                
                lista.add( 
                    new Categoria(
                        resultSet.getInt( 1 ),
                        resultSet.getString( 2 )
                    )
                );
            }//end while
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( CategoriaDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
            return lista;
        }//end finally
    }//end static method listar
    
    public static List<Categoria> listarSubCategoria( int catSuperior )
    {
        List<Categoria> lista = null;
        
        try 
        {
            conexion = new Conexion();
            connection = conexion.getConnection();
            
            callableStatement = connection.prepareCall( "{call sp_listarSubCategoria( ? )}" );
                callableStatement.setInt( 1 , catSuperior );
                
            resultSet = callableStatement.executeQuery();
            
            lista = new ArrayList< Categoria >();
            while( resultSet.next() ){
                
                lista.add( 
                    new Categoria(
                        resultSet.getInt( 1 ),
                        resultSet.getString( 2 )
                    )
                );
            }//end while
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( CategoriaDao.class ).warning( e.getMessage() );
        }//end catch
        
        finally{
            
            disconnect();
            return lista;
        }//end finally
    }//end static method listar
    
    public static boolean esSuperior( int catSuperior)
    {   
        try 
        {
            conexion = new Conexion();
            connection = conexion.getConnection();
            
            callableStatement = connection.prepareCall( "{call sp_contarSubCategoria( ? )}" );
                callableStatement.setInt( 1 , catSuperior );
                
            resultSet = callableStatement.executeQuery();
            resultSet.next();
                
            return resultSet.getInt( "cantidad" ) > 0;
        }//end try
        
        catch (Exception e) {
            
            Logger.getLogger( CategoriaDao.class ).warning( e.getMessage() );
            return false;
        }//end catch
        
        finally{
            
            disconnect();
        }//end finally
    }//end static method listar
    
    public static List<Categoria> listarTodoDeCategoria()
    {
        List<Categoria> lista = null;
        
        try 
        {
            conexion = new Conexion();
            connection = conexion.getConnection();
            
            callableStatement = connection.prepareCall( "{call sp_listarTodoDeCategoria()}" );
            
            resultSet = callableStatement.executeQuery();
            
            lista = new ArrayList< Categoria >();
            while( resultSet.next() ){
                
                lista.add( 
                    new Categoria(
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
    }//end method listarTodoDeCategoria
    
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
}//end class CategoriaDao
