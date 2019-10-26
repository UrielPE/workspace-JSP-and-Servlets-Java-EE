/**
 *
 * @author uriel
 */
package mx.com.sit.comercializadora.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import mx.com.sit.comercializadora.interfaces.DaoInterface;
import mx.com.sit.comercializadora.model.connectionBd.ConnectionDB;
import mx.com.sit.comercializadora.model.vo.Categoria;
import mx.com.sit.comercializadora.constants.DaoContants;

public class CategoriaDao implements DaoInterface
{
    private ConnectionDB connectionDB;
    private PreparedStatement statement;
    private ResultSet resultSet;

    @Override
    public <T> List<T> listAll() 
    {
        List<Categoria> listCategorias = new ArrayList<Categoria>();
        
        try 
        {
            connectionDB = new ConnectionDB();
            statement = connectionDB.getConnection().prepareStatement(
                DaoContants.CATEGORIA_QUERY_SELECT_ALL.getQuery() );   
            
            resultSet = statement.executeQuery();
            while( resultSet.next() )
            {
                listCategorias.add(
                    new Categoria( 
                        resultSet.getInt( 1 ) ,
                        resultSet.getString( 2 )
                    )
                );
            }//end while
        } 
        
        catch (Exception e) 
        {
            Logger.getLogger( CategoriaDao.class.getName())
                .log( Level.WARNING , null, e);
        }
        
        finally
        {    
            closeResources();
        }//end try-catch-finally
        
        Logger.getLogger( CategoriaDao.class.getName())
          .log( Level.INFO , "Successful query get all!\n");

        return (List<T>) listCategorias;
    }//end method listAll

    @Override
    public <T> T findById(int index) 
    {
        Categoria categoria = null;
        
        try 
        {
            connectionDB = new ConnectionDB();
            statement = connectionDB.getConnection().prepareStatement(
                DaoContants.CATEGORIA_SELECT_UNIQUE.getQuery() + " CATEGORIAID = ?" );
                
                statement.setInt( 1, index );
            
            resultSet = statement.executeQuery();
            while( resultSet.next() )
            {
                categoria = new Categoria( 
                    resultSet.getInt( 1 ) ,
                    resultSet.getString( 2 )
                );
            }//end while
        } 
        
        catch (Exception e) {
            
            Logger.getLogger( CategoriaDao.class.getName())
                .log( Level.WARNING , null, e);
        }
        finally{closeResources();}
        
        return (T) categoria;
    }

    @Override
    public <T> boolean save( T object) {
        Categoria categoria = ( Categoria ) object ;
        
        try 
        {
            connectionDB = new ConnectionDB();
            statement = connectionDB.getConnection().prepareStatement(
                DaoContants.CATEGORIA_INSERT.getQuery() + " ( ?, ? );" );
                
                statement.setInt( 1 , categoria.getId_categoria() );
                statement.setString( 2 , categoria.getNombre_categoria() );
            
            if(statement.executeUpdate() == 1) 
            {
                Logger.getLogger( CategoriaDao.class.getName())
                    .log( Level.INFO , "Successful insert categoria!");
                
                connectionDB.disconnect();
            }
        } 
        
        catch (Exception e) 
        {   
            Logger.getLogger( CategoriaDao.class.getName())
                .log( Level.INFO , null, e);
            
            return false;
        }
        
        return true;
    }

    @Override
    public boolean delete(int index) 
    {
        try 
        {
            connectionDB = new ConnectionDB();
            statement = connectionDB.getConnection().prepareStatement(
                DaoContants.CATEGORIA_DELETE.getQuery() );
                
                statement.setInt( 1 , index );
            
            if(statement.executeUpdate() == 1) 
            {
                Logger.getLogger( CategoriaDao.class.getName())
                    .log( Level.INFO , "Successful delete categoria!");
                
                connectionDB.disconnect();
            }
        } 
        
        catch (Exception e) 
        {   
            Logger.getLogger( CategoriaDao.class.getName())
                .log( Level.INFO , null, e);
            
            return false;
        }
        
        return true;
    }

    @Override
    public <T> boolean update(T object) 
    {
        Categoria categoria = ( Categoria ) object ;
        
        try 
        {
            connectionDB = new ConnectionDB();
            statement = connectionDB.getConnection().prepareStatement(
                DaoContants.CATEGORIA_UPDATE.getQuery() );
                
                statement.setString( 1 , categoria.getNombre_categoria() );
                statement.setInt( 2 , categoria.getId_categoria() );
            
            if(statement.executeUpdate() == 1) 
            {
                Logger.getLogger( CategoriaDao.class.getName())
                    .log( Level.INFO , "Successful update categoria!");
                
                connectionDB.disconnect();
            }
        } 
        
        catch (Exception e) 
        {   
            Logger.getLogger( CategoriaDao.class.getName())
                .log( Level.INFO , null, e);
            
            return false;
        }
        
        return true;
    }

    @Override
    public void closeResources() {
        try {
            if( !resultSet.isClosed() )
                this.resultSet.close();
            if( !statement.isCloseOnCompletion() )
                this.statement.close();
            
            this.connectionDB.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDao.class.getName())
                .log(Level.SEVERE, null, ex);
        }//end try-catch
    }//end method closeResources
}
