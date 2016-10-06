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
public class registro extends HttpServlet {

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
            out.println("<title>Servlet registro</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"css/estilosweb.css\" > ");
            out.println("</head>");
            out.println("<body>");
            
            /*
            Si hay algún campo obligatorio vacio entramos en el if  que es un nuevo formulario
            en el que nos saldrán mensajes en los campos obligatorios que tengamos en blanco,si le damos 
            a enviar sin completar todos los obligatorios, nos seguirá reenviando a la página hasta que 
            los tengamos completos, si le damos a limpiar , nos llevará al documento html otra vez y si los 
            completamos , al darle al boton de enviar nos llevara al else  con el cual nos saldrá una página nueva 
            con los datos Completos y que tendrá un boton para poder volver al Menú de la aplicación.
            **/
            
            if(request.getParameter("nombre")=="" || request.getParameter("pass")=="" || request.getParameter("usuario")=="")
            {
            out.println("<form name=\"formulario\" action=\"registro\" method=\"post\">\n<fieldset>");
            out.println("<h3>Informacion personal</h3>\n<br/>");
            out.println("<label for=\"nombre\">*Nombre:</label>&nbsp;&nbsp; ");
            
            //con todos estos if  marco,relleno las casillas o muestro los errores según los datos que  haya introducido 
            if(request.getParameter("nombre")=="")
            {
               out.println("<input type=\"text\" name=\"nombre\" value=\"" + request.getParameter("nombre")+ "\">&nbsp;<h4>Introduce un Nombre</h4>\n<br/><br/>\n"); 
            }else{
               out.println("<input type=\"text\" name=\"nombre\" value=\"" + request.getParameter("nombre")+ "\">\n<br/><br/>\n");  
            }
            out.println("<label for=\"apellidos\">Apellidos:</label> ");
            out.println("<input type=\"text\" name=\"apellidos\" value=\"" + request.getParameter("apellidos")+ "\" >\n<br/><br/>");
            out.println("<label for=\"sexo\">Sexo:</label>&nbsp;&nbsp; ");
            if(request.getParameter("sexo")=="hombre")
            {
               out.println("<input type=\"radio\" name=\"sexo\" value=\"hombre\" checked>Hombre");
               out.println("<input type=\"radio\" name=\"sexo\" value=\"mujer\" >Mujer\n<br/><br/>");
            }else{
               out.println("<input type=\"radio\" name=\"sexo\" value=\"hombre\" >Hombre");
               out.println("<input type=\"radio\" name=\"sexo\" value=\"mujer\" checked>Mujer\n<br/><br/>"); 
            }
            out.println("<h3>Datos de acceso</h3>\n<br/>");
            out.println("<label for=\"usuario\">*Usuario:</label>&nbsp;&nbsp;");
            if(request.getParameter("usuario")=="")
            {
               out.println("<input type=\"text\" name=\"usuario\" value=\"" + request.getParameter("usuario")+ "\">&nbsp;<h4>Introduce un Usuario</h4>\n<br/><br/>\n"); 
            }else{
               out.println("<input type=\"text\" name=\"usuario\" value=\"" + request.getParameter("usuario")+ "\">\n<br/><br/>\n");  
            }
            out.println("<label for=\"pasword\">*Contraseña:</label>&nbsp;&nbsp;");
             if(request.getParameter("pass")=="")
            {
               out.println("<input type=\"password\" name=\"pass\" value=\"" + request.getParameter("pass")+ "\">&nbsp;<h4>Introduce una Contraseña</h4>\n<br/><br/>\n"); 
            }else{
               out.println("<input type=\"password\" name=\"pass\" value=\"" + request.getParameter("pass")+ "\">\n<br/><br/>\n");  
            }
            out.println("<h3>Informacion General</h3>");
            out.println("<label for=\"preferencias\">Preferencias:</label>&nbsp;&nbsp;");
            if(request.getParameter("deporte")==null)
            {
               out.println("<input type=\"checkbox\" name=\"preferencia\" value=\"deporte\">Deporte"); 
            }else{
               out.println("<input type=\"checkbox\" name=\"preferencia\" value=\"deporte\" checked>Deporte");
            }
             if(request.getParameter("lectura")==null)
            {
               out.println("<input type=\"checkbox\" name=\"preferencia\" value=\"lectura\">Lectura"); 
            }else{
               out.println("<input type=\"checkbox\" name=\"preferencia\" value=\"lectura\" checked>Lectura");
            }
              if(request.getParameter("cine")==null)
            {
               out.println("<input type=\"checkbox\" name=\"preferencia\" value=\"cine\">Cine"); 
            }else{
               out.println("<input type=\"checkbox\" name=\"preferencia\" value=\"cine\" checked>Cine");
            }
               if(request.getParameter("viajes")==null)
            {
               out.println("<input type=\"checkbox\" name=\"preferencia\" value=\"viajes\">Viajes"); 
            }else{
               out.println("<input type=\"checkbox\" name=\"preferencia\" value=\"viajes\" checked>Viajes");
            }
            out.println("<br/><br/>\n</fieldset>\n\n<br/><br/>");
            out.println("<input  type=\"submit\" value=\"Enviar\" class=\"boton\" onclick=\"location.href='registro'\"/>");
            out.println("<input  type=\"button\" value=\"Limpiar\" class=\"boton\" onclick=\"location.href='HTML/Registro.html'\"/>");
            out.println("</form>");
            }else{
                
                out.println("<h1>Datos Correctos</h1>");
                
                java.util.Enumeration<String> misParametros=request.getParameterNames();
            while(misParametros.hasMoreElements()){

	String nombre=(String) misParametros.nextElement();
	if(!nombre.startsWith("env")){
		if(!nombre.startsWith("pre")){
			String valor= (String) request.getParameter(nombre);
			out.println("<p>" + nombre + ":"  + valor + "</p>");
	}else{
			out.println(nombre + ":");
			out.println("<ul>");
		String[] valor = request.getParameterValues("preferencia");
            
                    for(int i=0; i< valor.length; i++)
                    {
                        out.println("<li>"+ valor[i] +"</li>");
                    }//for
                    out.println("</ul>");
            }}} 
            out.println("<br/><br/><a id='volver' href='index.html'>Volver al Inicio</a>");
            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
