/**
 *
 * @author uriel.pena
 */
package sit.ecommerce.model.vo;


public class Item 
{
    private Producto producto;
    private int cantidad;

    public Item() {
    }

    public Item(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }    
    
    @Override
    public String toString() {
        return "Item{" + "producto=" + producto + ", cantidad=" + cantidad + '}';
    }
}
