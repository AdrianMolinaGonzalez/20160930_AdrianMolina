<%-- 
    Document   : tienda
    Created on : 17-oct-2016, 18:39:46
    Author     : Adrián
--%>

<%@page import="java.util.Iterator"%>
<%@page import="es.albarregas.beans.libro"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/tienda.css" > 
        <title>Tienda</title>
    </head>
    <body>
        
       
            <%!
            public String comprobar(ArrayList<libro> compra,libro milibro)
                {
                     Iterator<libro> it= compra.iterator();
            
            
                    //compruebo si ya tengo ese libro guardado
                    while(it.hasNext()){
                
                        libro libro1=it.next();
                        
                    //si encuentro el libro le añado la cantidad nueva a la que ya tengo  
                    if(libro1.getNombreLibro().equals(milibro.getNombreLibro())){
              
                     libro1.setCantidad(libro1.getCantidad()+milibro.getCantidad());
                     return "lo_tengo";
                    }    
                }
                return "no_lo_tengo";
}
            %>
            
            
            <%! 
                //me creo el arraylist donde guardaré mis objetos libro, es decir, "mi compra"
                ArrayList<libro> compra=new ArrayList<>();
                %>
                
        <%  
            
            HttpSession sesion=request.getSession(true);
            if(request.getParameter("finalizar")==null)
            {
            %>
            
         <h1>Tienda On-line</h1>
        <img style="width:20%;" src="../imagenes/librosonline.jpg" alt=""/>
        <form action="../JSP/tienda.jsp" >
            <h2>Seleccione un libro:</h2>
            <%
            
         
  
            //si  pulso el boton añadir...
            if(request.getParameter("añadir")!=null ){
               try{ 
                libro milibro=new libro();
                
                //si no he elegido libro o la cantidad es 0 o menor me muestra un error
                if(request.getParameter("libros")== null || request.getParameter("libros")== "" || Integer.parseInt(request.getParameter("cantidad"))<=0)
                {
                    %><p style="color:#cc0000;">No has seleccionado un libro o la Cantidad no es valida</p><%
                }else{
                    
                
                milibro.setNombreLibro(request.getParameter("libros"));
                milibro.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                
                //llamo al metodo que comprueba si tengo ya el libro, si no lo tengo lo almaceno
                if(comprobar(compra,milibro).equals("no_lo_tengo"))
                {
                   compra.add(milibro);
                }//if comprobar
                
                sesion.setAttribute("libros",compra);
                
                //muestro la cantidad y el nombre del libro por pantalla
                %>
                <p> Añadido a la lista <%= request.getParameter("cantidad")%> unidades del libro <%= request.getParameter("libros")%></p>
                <%
                }}catch(NumberFormatException e){

                  %><p style="color:#cc0000;">Lo que se ha introducido o no es un número entero  o esta vacio</p><%
                      
            }//catch
            
            //compruebo si ya tengo ese libro guardado
            
            
    }//if añadir
               
            %>

            <select name="libros" size="6" >
                <option>HARRY POTTER Y EL LEGADO MALDITO</option>
                <option>LOS HEREDEROS DE LA TIERRA</option>
                <option>PATRIA</option>
                <option>UN MONSTRUO VIENE A VERME</option>
                <option>LA CHICA DEL TREN</option>
                <option>JUEGO DE TRONOS</option>
                <option>LA ESPÍA</option>
                <option>BORN TO RUN</option>
            </select>
            <br/><br/>
            <label for="nombre">Cantidad:</label>&nbsp;&nbsp; 
            <input type="text" id="cantidad" name="cantidad" value="" />
            <br/><br/>
            <input  type="submit" name="añadir" value="Añadir a la Cesta"  />&nbsp;&nbsp;&nbsp;
            <input  type="reset" name="limpiar" value="Limpiar" />&nbsp;&nbsp;&nbsp;
            <input  type="submit" name="finalizar" value="Finalizar Compra"  />
        </form>
            <%
              
            }//if finalizar null
 if(request.getParameter("finalizar")!=null ){
        
           %>
           <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="../css/tienda.css" > 
        <title>Tienda</title>
    </head>
    <body>
           <%
            
            ArrayList<libro> compra= (ArrayList)sesion.getAttribute("libros");
            
            //si el carro esta vacio muestra un mensaje, en caso contrario muestra la compra.
            if(compra==null)
            {
                %>  <h1>Gracias por pasarse.</h1>
                    <br/><br/><br/><br/>
                    <a id='volver' href='../index.html'>Volver al Inicio</a>
                <%
            }else{

            Iterator<libro> it= compra.iterator();
            
            int i =0;
            
            
%>
                <h3>Gracias por elegirnos para su compra.</h3>
                <br/><br/><br/>
    <table align="center">
            <tr><td>CANTIDAD</td><td>TITULO</td></tr>
            <%


            while(it.hasNext()){
                
                libro libro2=it.next();
                %>
                <tr><td><%= libro2.getCantidad() %></td><td><%= libro2.getNombreLibro() %></td></tr>
                <%
            }//while
                sesion.invalidate();
 %>
    </table><br/><br/><br/><a id='volver' href='../index.html'>Volver al Inicio</a></body>
 <%
}}//if finalizar
                %>
        
    </body>
</html>
