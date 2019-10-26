/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.constants;


public enum CrudEmpleadoConstants 
{
    SELECT_ALL( "SELECT * FROM empleado;" ),
    SAVE( "INSERT INTO empleado values ( ?, ?, ?, ?, ?, ? );" ),
    UPDATE( "UPDATE empleado set Dni=?, Nombres=?, Telefono=?, Estado=?,"
        + "User=? WHERE IdEmpleado=?;" ),
    DELETE( "DELETE FROM empleado WHERE IdEmpleado=?;" ),
    SELECTUNIQUE( "SELECT * FROM empleado WHERE IdEmpleado=?;" );
    
    private String statement;
    
    private CrudEmpleadoConstants( String statement ){
        this.statement = statement;
    }//end constructor
    
    public String getStatement(){
        return this.statement;
    }//end getStatement method
}//end CrudEmpleadoConstants
