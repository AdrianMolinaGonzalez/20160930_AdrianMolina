/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrián
 */
public class ContadorVisitasCookie extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContadorVisitasCookie</title>");
            out.println("<link rel=\"stylesheet\" href=\"css/estilosweb.css\" >");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ContadorVisitasCookie at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
            
            Cookie cookie=null;
            Cookie[] cookies=request.getCookies();
            if(cookies !=null)
            {
                for (int i=0 ; i< cookies.length;i++)
                {
                    if(cookies[i].getName().equals("CONTADOR")){
                        cookie=cookies[i];
                        break;
                    }
                }
            }
            if(cookie==null){
                cookie=new Cookie("CONTADOR","0");
            }else if (request.getParameter("borrar") !=null){
                cookie.setValue("0");
            }
            int contador= Integer.parseInt(cookie.getValue());
            cookie.setValue(Integer.toString(contador+1));
            cookie.setMaxAge(604800);
            
            response.addCookie(cookie);
            try (PrintWriter out = response.getWriter()) {
                
            if(request.getParameter("recargar")==null)
            {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContadorVisitasCookie</title>");
            out.println("<link rel=\"stylesheet\" href=\"css/estilosweb.css\" >");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"ContadorVisitasCookie\" method=\"POST\">");
            out.println("<h1>Numero de veces que se ha visitado la página  " + cookie.getValue()+ "</h1>");
            out.println("<br/>");
            out.println("<ul>");
            out.println("<li><p>Dominio: " + cookie.getDomain() + "</p></li>");
            out.println("<li><p>Nombre: " + cookie.getName() + "</p></li>");
            out.println("<li><p>Path: " + cookie.getPath() + "</p></li>");
            out.println("<li><p>Seguridad: " + cookie.getSecure() + "</p></li>");
            out.println("<li><p>Valor: " + cookie.getValue() + "</p></li>");
            out.println("<li><p>Version: " + cookie.getVersion() + "</p></li></ul>");
            out.println("&nbsp;<input  type=\"submit\" name=\"recargar\" value=\"Recargar\" class=\"boton\" /><br/><br/>");
            out.println("<br/><br/><a id='volver' href='index.html'>Volver al Inicio</a>");
            out.println("</body>");
            out.println("</html>");
            }else
                {
                    
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ContadorVisitasServlet</title>");
            out.println("<link rel=\"stylesheet\" href=\"css/estilosweb.css\" >");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form action=\"ContadorVisitasCookie\" method=\"POST\">");
            out.println("<h1>Numero de veces que se ha visitado la página  " + cookie.getValue()+ "</h1>");
            out.println("<br/><br/><br/>");
            out.println("&nbsp;<input  type=\"submit\" name=\"recargar\" value=\"Recargar\" class=\"boton\" />&nbsp;&nbsp;&nbsp;&nbsp;");
            out.println("&nbsp;<input  type=\"submit\" name=\"borrar\" value=\"borrar\" class=\"boton\" />&nbsp;&nbsp;&nbsp;&nbsp;");
            out.println("</body>");
            out.println("</html>");
                }
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
