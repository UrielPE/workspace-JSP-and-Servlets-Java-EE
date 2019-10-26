/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.model.vo;

import java.util.Date;

public class Venta 
{
    private Integer id;
    private Integer item;
    private Integer idCliente;
    private Integer idEmpleado;
    private Integer idProducto;
    private String numSerie;
    private String descripcionP;
    private Date fecha;
    private Double precio;
    private Integer cantidad;
    private Double subTotal;
    private Double monto;
    private String estado;
    
    public Venta(){
    }

    public Venta(Integer idProducto, Integer item, String descripcionP, Double precio, 
        Integer cantidad, Double subTotal) 
    {
        this.idProducto = idProducto;
        this.item = item;
        this.descripcionP = descripcionP;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
    }

    public Venta(Integer id, Integer item, Integer idCliente, Integer idEmpleado,
        Integer idProducto, String numSerie, String descripcionP, Date fecha, 
        Double precio, Integer cantidad, Double subTotal, Double monto, String estado) 
    {
        this.id = id;
        this.item = item;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idProducto = idProducto;
        this.numSerie = numSerie;
        this.descripcionP = descripcionP;
        this.fecha = fecha;
        this.precio = precio;
        this.cantidad = cantidad;
        this.subTotal = subTotal;
        this.monto = monto;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
     
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Venta{" + "id=" + id + ", item=" + item + ", idCliente=" + idCliente + ", idEmpleado=" + idEmpleado + ", idProducto=" + idProducto + ", numSerie=" + numSerie + ", descripcionP=" + descripcionP + ", fecha=" + fecha + ", precio=" + precio + ", cantidad=" + cantidad + ", subTotal=" + subTotal + ", monto=" + monto + ", estado=" + estado + '}';
    }
    
}//end class Venta
