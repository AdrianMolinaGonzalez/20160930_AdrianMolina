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
public class Parametros extends HttpServlet {

        @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Par&aacute;metros</title>");
            out.println("<link rel=\"stylesheet\" href=\"css/estilosweb.css\" > ");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Par&aacute;metros Iniciales</h2>");
            out.println("<table border=1 borderColor=blue>");
            out.println("<tr><td colspan=2>Clasificaci&oacute;n 2016/17 Jornada 7</td></tr>");
            out.println("<tr><td>Pos</td><td>Club/Puntos</td></tr>");
            java.util.Enumeration<String> parametros = request.getParameterNames();
            
            while(parametros.hasMoreElements()){
                String elemento = parametros.nextElement();
                String valor = request.getParameter(elemento);
                out.println("<tr><td>" + elemento + "</td>"+"<td>"+valor +"</td></tr>");
            }
            out.println("</table><br/><br/>");
            out.println("<a id='volver' href='index.html'>Volver al Inicio</a>");
            out.println("</body>");
            out.println("</html>");
            
        }

}
