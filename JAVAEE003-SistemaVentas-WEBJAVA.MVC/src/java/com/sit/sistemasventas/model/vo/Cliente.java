/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.model.vo;


public class Cliente 
{
    private int IdCliente;
    private String dni;
    private String nombres;
    private String direccion;
    private String estado;
    
    public Cliente(){
    }//end empty constructor

    public Cliente(String dni, String nombres, String direccion, String estado) 
    {
        this.dni = dni;
        this.nombres = nombres;
        this.direccion = direccion;
        this.estado = estado;
    }//end constructor

    public Cliente(int IdCliente, String dni, String nombres, String direccion, 
        String estado) 
    {
        this.IdCliente = IdCliente;
        this.dni = dni;
        this.nombres = nombres;
        this.direccion = direccion;
        this.estado = estado;
    }//end constructor

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}//end class Cliente
