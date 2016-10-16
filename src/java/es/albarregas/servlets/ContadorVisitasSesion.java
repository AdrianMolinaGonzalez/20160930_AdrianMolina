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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Adrián
 */

public class ContadorVisitasSesion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContadorVisitasSesion</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"css/estilosweb.css\" >");
            out.println("</head>");
            HttpSession sesion= request.getSession(true);
            int contador=0;
            out.println("<body>");
            boolean isInvalidate= false;
            if(request.getParameter("eliminar") != null && request.getParameter("eliminar").equals("true"))
            {
                sesion.invalidate();
                isInvalidate=true;
            }else{
                if(sesion.getAttribute("contaSesion") != null){
                    contador=((Integer)sesion.getAttribute("contaSesion"));
                    
                }
                sesion.setAttribute("contaSesion", new Integer(contador + 1));
            }
            out.println("<form action=\"ContadorVisitasSesion\" method=\"POST\">");
                if(!isInvalidate){
                    out.println("<h1>Numero de visitas  " + (contador + 1) +"</h1> ");
                    out.println("Invalidar sesion: <input type=\"checkbox\" name=\"eliminar\" value=\"true\"><br/><br/>");
                }
                    out.println("&nbsp;<input  type=\"submit\"  value=\"Recargar\" class=\"boton\" /><br/><br/>");
                    out.println("<br/><br/><a id='volver' href='index.html'>Volver al Inicio</a>");
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
            
            doGet(request, response);
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
