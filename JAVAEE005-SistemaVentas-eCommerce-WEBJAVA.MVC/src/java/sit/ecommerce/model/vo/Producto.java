/**
 *
 * @author uriel.pena
 */
package sit.ecommerce.model.vo;

import java.io.Serializable;


public class Producto implements Serializable
{
    private int webid;
    private String nombre;
    private float precio;
    private float precio_nuevo;
    private int stock;
    private boolean nuevo;
    private boolean recomendado;
    private String descripcion;
    private boolean visible;
    private int cod_marca;
    private int cod_categoria;
    private String imagen;

    public Producto() {
    }
    
    public Producto(int webid, String nombre, float precio, float precio_nuevo, int stock, boolean nuevo, boolean recomendado, String descripcion, boolean visible, int cod_marca, int cod_categoria, String imagen) {
        this.webid = webid;
        this.nombre = nombre;
        this.precio = precio;
        this.precio_nuevo = precio_nuevo;
        this.stock = stock;
        this.nuevo = nuevo;
        this.recomendado = recomendado;
        this.descripcion = descripcion;
        this.visible = visible;
        this.cod_marca = cod_marca;
        this.cod_categoria = cod_categoria;
        this.imagen = imagen;
    }
    
    public int getWebid() {
        return webid;
    }

    public void setWebid(int webid) {
        this.webid = webid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isNuevo() {
        return nuevo;
    }

    public void setNuevo(boolean nuevo) {
        this.nuevo = nuevo;
    }

    public boolean isRecomendado() {
        return recomendado;
    }

    public void setRecomendado(boolean recomendado) {
        this.recomendado = recomendado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getCod_marca() {
        return cod_marca;
    }

    public void setCod_marca(int cod_marca) {
        this.cod_marca = cod_marca;
    }

    public int getCod_categoria() {
        return cod_categoria;
    }

    public void setCod_categoria(int cod_categoria) {
        this.cod_categoria = cod_categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }  

    @Override
    public String toString() {
        return "Producto{" + "webid=" + webid + ", nombre=" + nombre + ", "
            + "precio=" + precio + ", precio_nuevo=" + precio_nuevo + ", "
            + "stock=" + stock + ", nuevo=" + nuevo + ", "
            + "recomendado=" + recomendado + ", descripcion=" 
            + descripcion + ", visible=" + visible + ", cod_marca=" 
            + cod_marca + ", cod_categoria=" + cod_categoria + ", imagen=" + imagen + '}';
    }
}//end class Producto
