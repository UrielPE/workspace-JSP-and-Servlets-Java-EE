/**
 *
 * @author URIEL
 */
package com.sit.sistemasventas.model.vo;

public class Empleado
{
    private int idEmpleado;
    private String dni;
    private String nombre;
    private String telefono;
    private String estado;
    public String user;
    
    public Empleado(){
    }
    
    public Empleado( String user, String dni ){
        
        this.user = user;
        this.dni = dni;
    }
    
    public Empleado( String dni, String nombre, String telefono,
        String estado, String user )
    {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = estado;
        this.user = user;
    }
    
    public Empleado( int idEmpleado, String dni, String nombre, String telefono,
        String estado, String user )
    {
        this.idEmpleado = idEmpleado;
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estado = estado;
        this.user = user;
    }//end constructor

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + 
        ", dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + 
        ", estado=" + estado + ", user=" + user + '}';
    }
}// end class Empleado
