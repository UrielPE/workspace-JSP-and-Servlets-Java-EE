/**
 *
 * @author URIEL
 */
package sit.ecommerce.model.vo;

import java.io.Serializable;

public class Marca implements Serializable
{
    private int codifo;
    private String nombre;
    private boolean visible;

    public Marca(){
    }//end constructor
    
    public Marca(int codifo, String nombre ) 
    {
        this.codifo = codifo;
        this.nombre = nombre;
    }//end constructor Marca
    
    public Marca(int codifo, String nombre, boolean visible) 
    {
        this.codifo = codifo;
        this.nombre = nombre;
        this.visible = visible;
    }//end constructor Marca

    public int getCodifo() {
        return codifo;
    }

    public void setCodifo(int codifo) {
        this.codifo = codifo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public String toString() {
        return "Marca{" + "codifo=" + codifo + ", nombre=" + nombre + ", visible=" + visible + '}';
    }//end method toString
}//end class Marca
