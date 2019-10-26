/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.constants;


public enum CrudVentaConstants 
{
    SERIE_NUM( "SELECT max( NumeroSerie ) FROM ventas;" ),
    SALE_ID( "SELECT max(IdVentas) FROM ventas;" ),
    SAVE( "INSERT INTO ventas values( ?, ?, ?, ?, ?, ?, ? );" ),
    SAVE_SALE_DETAIL( "INSERT INTO detalle_ventas values( ?, ?, ?, ?, ? );" ) ;
    
    public final String query;
    
    private CrudVentaConstants( String query ){
        
        this.query = query;
    }//end constructor   

    public String getQuery(){
        
        return query;
    }//end method getQuery
}//end class CrudVentaConstants
