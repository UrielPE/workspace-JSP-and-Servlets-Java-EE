/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.interfaces;

import java.util.List;

public interface Crud 
{
    public abstract <T> int save( T object  );
    public abstract <T> List<T> list();
    public abstract <T> int update( T object );
    public abstract void delete( int id );
    public abstract void disconnect();
}//end interface Crud
