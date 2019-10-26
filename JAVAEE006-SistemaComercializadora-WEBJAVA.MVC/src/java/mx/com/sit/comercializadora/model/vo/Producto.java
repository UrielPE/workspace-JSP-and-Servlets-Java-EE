/**
 *
 * @author uriel
 */
package mx.com.sit.comercializadora.model.vo;


public class Producto 
{
    private int id_producto;
    private int id_proveedor;
    private int id_cateogoria;
    private String descripcion;
    private double precio_unidad;
    private int existencia;
    
    public Producto(){
        super();
    }

    public Producto(int id_producto, int id_proveedor, int id_cateogoria, String descripcion, double precio_unidad, int existencia) {
        this.id_producto = id_producto;
        this.id_proveedor = id_proveedor;
        this.id_cateogoria = id_cateogoria;
        this.descripcion = descripcion;
        this.precio_unidad = precio_unidad;
        this.existencia = existencia;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getId_cateogoria() {
        return id_cateogoria;
    }

    public void setId_cateogoria(int id_cateogoria) {
        this.id_cateogoria = id_cateogoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio_unidad() {
        return precio_unidad;
    }

    public void setPrecio_unidad(double precio_unidad) {
        this.precio_unidad = precio_unidad;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", id_proveedor=" + id_proveedor + ", id_cateogoria=" + id_cateogoria + ", descripcion=" + descripcion + ", precio_unidad=" + precio_unidad + ", existencia=" + existencia + '}';
    }
}
