/**
 *
 * @author uriel
 */
package mx.com.sit.comercializadora.model.vo;

import java.util.Date;

public class Orden 
{
    private int id_orden;
    private int id_empleado;
    private int id_cliente;
    private Date fecha_orden;
    private int descuento;
    
    public Orden(){
        super();
    }

    public Orden(int id_orden, int id_empleado, int id_cliente, 
            Date fecha_orden, int descuento) {
        this.id_orden = id_orden;
        this.id_empleado = id_empleado;
        this.id_cliente = id_cliente;
        this.fecha_orden = fecha_orden;
        this.descuento = descuento;
    }

    public int getId_orden() {
        return id_orden;
    }

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha_orden() {
        return fecha_orden;
    }

    public void setFecha_orden(Date fecha_orden) {
        this.fecha_orden = fecha_orden;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Orden{" + "id_orden=" + id_orden +
            ", id_empleado=" + id_empleado +
            ", id_cliente=" + id_cliente + ", fecha_orden=" + fecha_orden 
            + ", descuento=" + descuento + '}';
    }
}
