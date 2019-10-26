/**
 *
 * @author uriel
 */
package mx.com.sit.comercializadora.constants;


public enum DaoContants
{
    CATEGORIA_QUERY_SELECT_ALL( "SELECT * FROM CATEGORIAS" ),
    CATEGORIA_INSERT( "INSERT INTO CATEGORIAS VALUES " ),
    CATEGORIA_DELETE( "DELETE FROM CATEGORIAS WHERE CATEGORIAID = ? " ),
    CATEGORIA_UPDATE( "UPDATE CATEGORIAS SET NOMBRECAT = ? WHERE CATEGORIAID = ? " ),
    CATEGORIA_SELECT_UNIQUE( "SELECT * FROM CATEGORIAS WHERE " );
    
    private String query;

    private DaoContants( String query ) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
} 
