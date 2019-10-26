/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrés Guzmán F
 */
public class CatalogoDb {

    private List<Producto> productos = new ArrayList<Producto>();

    public CatalogoDb() {
        productos.add(new Producto(1, "Panasonic  Pantalla LCD", 259990));
        productos.add(new Producto(2, "Sony  Cámara digital DSC-W320B", 123490));
        productos.add(new Producto(3, "Apple  iPod shuffle ", 69990));
        productos.add(new Producto(4, "Sony  Notebook Z110 ", 1499990));
        productos.add(new Producto(5, "Hewlett Packard  Multifuncional F2280", 37990));
        productos.add(new Producto(6, "Bianchi  Bicicleta Aro 26", 69990));
        productos.add(new Producto(7, "Mica  Cómoda 5 Cajones", 69990));
        productos.add(new Producto(8, "Movistar  Celular Nokia X6 ", 299990));
        productos.add(new Producto(9, "Bicicleta elíptica Oxford modelo be-50090", 79990));
    }

    public List<Producto> obtenerTodos() {
        return productos;
    }

    public Producto buscarPorNombre(String nombre) {
        Producto resultado = null;

        for (Producto producto : productos) {

            if (producto.getNombre().toUpperCase().contains(nombre.toUpperCase())) {
                resultado = producto;
                break;
            }
        }
        return resultado;
    }

    public Producto buscarProductoPorId(int id) {
        Producto resultado = null;

        for (Producto producto : productos) {

            if (producto.getId() == id) {
                resultado = producto;
                break;
            }
        }
        return resultado;
    }
}
