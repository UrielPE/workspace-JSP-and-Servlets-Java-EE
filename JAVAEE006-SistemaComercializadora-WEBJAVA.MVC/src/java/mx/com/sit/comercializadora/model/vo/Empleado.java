/**
 *
 * @author uriel
 */
package mx.com.sit.comercializadora.model.vo;

import java.util.Date;

public class Empleado 
{
    private int id_empleado;
    private String nombre;
    private String apellido;
    private Date fechaNacimiento;
    private int reporta_a;
    private int extencion;
    private String jefe;

    public Empleado(){
    }

    public Empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Empleado(int id_empleado, String nombre, String apellido, Date fechaNacimiento, int reporta_a, int extencion) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.reporta_a = reporta_a;
        this.extencion = extencion;
    }
    
    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getReporta_a() {
        return reporta_a;
    }

    public void setReporta_a(int reporta_a) {
        this.reporta_a = reporta_a;
    }

    public int getExtencion() {
        return extencion;
    }

    public void setExtencion(int extencion) {
        this.extencion = extencion;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

}
