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
public class formularioCompleto extends HttpServlet {

  
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet formulario Completo</title>");
            out.println("<link rel=\"stylesheet\" href=\"css/estilosweb.css\" > ");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 >Formulario Completo</h1>");
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
            out.println("<link rel=\"stylesheet\" href=\"css/estilosweb.css\" > ");
            out.println("<link rel=\"stylesheet\" href=\"../css/formulario.css\" >  ");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 >Datos del formulario</h1>");
            out.println("<h3 >Datos Personales:</h3>");
            out.println("<p>" + "Usuario -" + request.getParameter("usuario") + "</p>");
            out.println("<p>"+ "Contraseña -" + request.getParameter("clave") + "</p>" );
            out.println("<p>"+ "Edad -" + request.getParameter("edad") + "</p>" );
            out.println("<h3 >Otros Datos: </h3>");
            out.println("<p>"+ "Estado Civil -" + request.getParameter("estado") + "</p>" ); 
             String[] aficiones = request.getParameterValues("aficiones");
            if(aficiones !=null)
            {
                out.println("<p>Tus aficiones son: </p><ul>");
                    for(int i=0; i< aficiones.length; i++)
                    {
                        out.println("<li>"+ aficiones[i] +"</li>");
                    }//for
                    out.println("</ul>");
            }//if
                    else{
                          out.println("<p>No tiene aficiones.</p>");
                            }//else
            out.println("<p>"+ "Comentario -" + request.getParameter("comentario") + "</p>" );
            out.println("<h3 >Medios Tecnol&oacute;gicos:</h3>");
            out.println("<p>"+ "Dispones de Internet -" + request.getParameter("internet") + "</p>" );
            out.println("<p>"+ "Sistema Operativo -" + request.getParameter("sistema") + "</p>" + "</br>" );
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
