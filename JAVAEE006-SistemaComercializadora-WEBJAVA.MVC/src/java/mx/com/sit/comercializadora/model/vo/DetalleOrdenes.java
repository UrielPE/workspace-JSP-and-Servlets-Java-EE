/**
 *
 * @author uriel
 */
package mx.com.sit.comercializadora.model.vo;


public class DetalleOrdenes
{
    private int id_orden;
    private int detalle_orden;
    private int producto_id;
    private int cantidad;
    
    public DetalleOrdenes()
    {
        super();
    }

    public DetalleOrdenes(int id_orden, int detalle_orden, int producto_id, int cantidad) {
        this.id_orden = id_orden;
        this.detalle_orden = detalle_orden;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getDetalle_orden() {
        return detalle_orden;
    }

    public void setDetalle_orden(int detalle_orden) {
        this.detalle_orden = detalle_orden;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetalleOrdenes{" + "id_orden=" + id_orden + ", detalle_orden=" + detalle_orden + ", producto_id=" + producto_id + ", cantidad=" + cantidad + '}';
    }
}
