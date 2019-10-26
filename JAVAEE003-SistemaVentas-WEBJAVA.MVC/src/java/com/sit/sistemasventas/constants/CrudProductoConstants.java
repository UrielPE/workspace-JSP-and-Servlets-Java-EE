/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.constants;


public enum CrudProductoConstants 
{
    LIST_ALL( "SELECT * FROM producto" ),
    SAVE( "INSERT INTO producto( Nombres, Precio, Stock, Estado ) values ( ?, ?, ?, ? );" ),
    DELETE( "DELETE FROM producto WHERE IdProducto = ?;" ),
    UPDATE( "UPDATE producto SET Nombres=?, Precio=?, Stock=?, Estado=? WHERE IdProducto=?;" ),
    SELECT_UNIQUE( "SELECT * FROM producto WHERE IdProducto=?;" ),
    STOCK_UPDATE( "UPDATE producto set Stock=? WHERE IdProducto=?;" );
    
    private String query;
       
    private CrudProductoConstants( String query ) {
        
        this.query = query;
    }//end constructor
    
    public String getQuery(){
        
        return this.query;
    }//end getQuery method 
}//end class CrudProductoConstants
