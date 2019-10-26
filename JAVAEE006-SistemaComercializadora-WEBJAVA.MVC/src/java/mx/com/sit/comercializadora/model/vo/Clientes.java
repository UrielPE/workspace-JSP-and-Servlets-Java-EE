/**
 *
 * @author uriel
 */
package mx.com.sit.comercializadora.model.vo;

public class Clientes
{
    private int id_cliente;
    private String cedula_ruc;
    private String nombre_cita;
    private String nombre_contacto;
    private String direccion_cliente;
    private String fax;
    private String email;
    private String telefono_movil;
    private String telefono_hogar;
    
    public Clientes(){
        super();
    }

    public Clientes(int id_cliente, String cedula_ruc, String nombre_cita, String nombre_contacto, String direccion_cliente, String fax, String email, String telefono_movil, String telefono_hogar) {
        this.id_cliente = id_cliente;
        this.cedula_ruc = cedula_ruc;
        this.nombre_cita = nombre_cita;
        this.nombre_contacto = nombre_contacto;
        this.direccion_cliente = direccion_cliente;
        this.fax = fax;
        this.email = email;
        this.telefono_movil = telefono_movil;
        this.telefono_hogar = telefono_hogar;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getCedula_ruc() {
        return cedula_ruc;
    }

    public void setCedula_ruc(String cedula_ruc) {
        this.cedula_ruc = cedula_ruc;
    }

    public String getNombre_cita() {
        return nombre_cita;
    }

    public void setNombre_cita(String nombre_cita) {
        this.nombre_cita = nombre_cita;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getDireccion_cliente() {
        return direccion_cliente;
    }

    public void setDireccion_cliente(String direccion_cliente) {
        this.direccion_cliente = direccion_cliente;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(String telefono_movil) {
        this.telefono_movil = telefono_movil;
    }

    public String getTelefono_hogar() {
        return telefono_hogar;
    }

    public void setTelefono_hogar(String telefono_hogar) {
        this.telefono_hogar = telefono_hogar;
    }

    @Override
    public String toString() {
        return "Clientes{" + "id_cliente=" + id_cliente + ", cedula_ruc=" + cedula_ruc + ", nombre_cita=" + nombre_cita + ", nombre_contacto=" + nombre_contacto + ", direccion_cliente=" + direccion_cliente + ", fax=" + fax + ", email=" + email + ", telefono_movil=" + telefono_movil + ", telefono_hogar=" + telefono_hogar + '}';
    }
}
