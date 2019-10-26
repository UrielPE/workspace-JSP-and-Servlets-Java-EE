/**
 *
 * @author uriel
 */
package mx.com.sit.comercializadora.interfaces;

import java.util.List;

public interface DaoInterface 
{
    public <T> List<T> listAll();
    public <T> T findById( int index );
    
    public <T> boolean save( T object );
    public boolean delete( int index );
    public <T> boolean update( T object );
    
    public void closeResources();
}
