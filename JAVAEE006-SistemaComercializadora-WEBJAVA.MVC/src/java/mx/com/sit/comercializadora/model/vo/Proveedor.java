/**
 *
 * @author uriel
 */
package mx.com.sit.comercializadora.model.vo;


public class Proveedor 
{
    private int id_proveedor;
    private String nombre_proveerdor;
    private String contacto;
    private String telefono_movil;
    private String telefono_fijo;

    public Proveedor(){
        super();
    }
    
    public Proveedor(int id_proveedor, String nombre_proveerdor, String contacto, String telefono_movil, String telefono_fijo) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveerdor = nombre_proveerdor;
        this.contacto = contacto;
        this.telefono_movil = telefono_movil;
        this.telefono_fijo = telefono_fijo;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveerdor() {
        return nombre_proveerdor;
    }

    public void setNombre_proveerdor(String nombre_proveerdor) {
        this.nombre_proveerdor = nombre_proveerdor;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono_movil() {
        return telefono_movil;
    }

    public void setTelefono_movil(String telefono_movil) {
        this.telefono_movil = telefono_movil;
    }

    public String getTelefono_fijo() {
        return telefono_fijo;
    }

    public void setTelefono_fijo(String telefono_fijo) {
        this.telefono_fijo = telefono_fijo;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id_proveedor=" + id_proveedor + ", nombre_proveerdor=" + nombre_proveerdor + ", contacto=" + contacto + ", telefono_movil=" + telefono_movil + ", telefono_fijo=" + telefono_fijo + '}';
    } 
}
