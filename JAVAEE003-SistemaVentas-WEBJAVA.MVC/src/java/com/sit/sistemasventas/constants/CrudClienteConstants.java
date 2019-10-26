/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.constants;


public enum CrudClienteConstants 
{
    LIST_ALL( "SELECT * FROM cliente;" ),
    LIST_UNIQUE( "SELECT * FROM cliente WHERE IdCliente=?;" ),
    LIST_UNIQUE_FOR_DNI( "SELECT * FROM cliente WHERE Dni=?;" ),
    SAVE( "INSERT INTO cliente( Dni, Nombres, Direccion, Estado ) VALUES ( ?, ?, ?, ? );" ),
    DELETE( "DELETE FROM cliente WHERE IdCliente=?;" ),
    UPDATE( "UPDATE cliente SET Dni=?, Nombres=?, Direccion=?, Estado=? WHERE IdCliente=?;" );
    
    
    private String query;
    
    private CrudClienteConstants( String query ){
        
        this.query = query;
    }//end constructor

    public String getQuery(){
        
        return this.query;
    }//end method getQuery
}//end enum CrudClienteConstants
