/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrián
 */
public class formulario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet formulario</title>");
            out.println("<link rel=\"stylesheet\" href=\"css/estilosweb.css\" > ");                
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 >Formulario</h1>");
            out.println("<br/><p>No has accedido al formulario</p><br/>");
            out.println("<a id='volver' href='index.html'>Volver al Inicio</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
             try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet formulario</title>");
            out.println("<link rel=\"stylesheet\" href=\"../css/formulario.css\" > ");
            out.println("<link rel=\"stylesheet\" href=\"css/estilosweb.css\" > ");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Datos del formulario</h1>");
            out.println("<p>" + "Nombre -" + request.getParameter("nombre") + "</p>");
            out.println("<p>"+ "Apellidos -" + request.getParameter("apellidos") + "</p><br/>" );
             out.println("<a id='volver' href='index.html'>Volver al Inicio</a>");
            out.println("</body>");
            out.println("</html>");
             }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
