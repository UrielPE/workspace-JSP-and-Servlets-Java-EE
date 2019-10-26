/**
 *
 * @author Uriel
 */
package com.modeloVO;


public class Producto
{
    //definicion variables de instancia
    private String codigoArticulo ;
    private String seccion;
    private String precio ;
    private String fecha ;
    private String importado ;
    private String paisOrigen ;
    private String nombreArticulo ;

    public Producto(String codigoArticulo, String seccion,String nombreArticulo, 
            String precio, String fecha, String importado, String paisOrigen) {
        this.codigoArticulo = codigoArticulo;
        this.seccion = seccion;
        this.nombreArticulo = nombreArticulo;
        this.precio = precio;
        this.fecha = fecha;
        this.importado = importado;
        this.paisOrigen = paisOrigen;
    }

    public Producto(String seccion, String nombreProducto, String precio, String fecha, String importado, String paisOrigen) {
        this.seccion = seccion;
        this.nombreArticulo = nombreProducto;
        this.precio = precio;
        this.fecha = fecha;
        this.importado = importado;
        this.paisOrigen = paisOrigen;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }
        
    public String getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(String codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getImportado() {
        return importado;
    }

    public void setImportado(String importado) {
        this.importado = importado;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoArticulo=" + codigoArticulo + 
                ", seccion=" + seccion + ", precio=" + precio + 
                ", fecha=" + fecha + ", importado=" + importado + 
                ", paisOrigen=" + paisOrigen + '}'+"\n";
    } 
}//end class Producto
