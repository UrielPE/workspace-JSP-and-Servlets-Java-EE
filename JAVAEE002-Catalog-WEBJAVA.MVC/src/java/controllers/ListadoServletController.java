package controllers;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.CatalogoDb;

/**
 *
 * @author Andrés Guzmán F
 */
@WebServlet(name = "ListadoController", urlPatterns = {"/catalogo/listado"})
public class ListadoServletController extends HttpServlet {

    private CatalogoDb modelo;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        modelo = (CatalogoDb) config.getServletContext().getAttribute("catalogoDb");
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        /* Asignamos la variable nombre a la vista jsp, mediante el contexto Request*/
        request.setAttribute("productos", modelo.obtenerTodos());
        request.setAttribute("titulo", "Listado de Productos");

        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        request.setAttribute("fecha", sdf.format(fecha));
        
        /* El Servlet selecciona la vista respuesta.jsp y
        reenvia los atributos dentro de la misma petición HTTP
         */
        getServletContext().getRequestDispatcher("/listado.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
