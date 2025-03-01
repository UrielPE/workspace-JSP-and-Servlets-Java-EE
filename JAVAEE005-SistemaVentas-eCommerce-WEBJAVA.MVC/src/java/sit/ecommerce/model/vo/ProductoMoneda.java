/**
 *
 * @author uriel.pena
 */
package sit.ecommerce.model.vo;

import java.io.Serializable;


public class ProductoMoneda implements Serializable
{
    private String moneda;
    private float precio;
    private float precio_nuevo;
    private int webid;

    public ProductoMoneda() {
    }

    public ProductoMoneda(String moneda, float precio, float precio_nuevo, int webid) {
        this.moneda = moneda;
        this.precio = precio;
        this.precio_nuevo = precio_nuevo;
        this.webid = webid;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPrecio_nuevo() {
        return precio_nuevo;
    }

    public void setPrecio_nuevo(float precio_nuevo) {
        this.precio_nuevo = precio_nuevo;
    }

    public int getWebid() {
        return webid;
    }

    public void setWebid(int webid) {
        this.webid = webid;
    }

    @Override
    public String toString() {
        return "ProductoMoneda{" + "moneda=" + moneda + ", precio=" 
            + precio + ", precio_nuevo=" + precio_nuevo + ", webid=" + webid + '}';
    } 
}
