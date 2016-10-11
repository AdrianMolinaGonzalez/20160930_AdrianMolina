<%-- 
    Document   : Calculadora
    Created on : 10-oct-2016, 20:18:13
    Author     : Adrián
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilosweb.css" > 
        <title>Calculadora JSP</title>
    </head>
    <body>
     <h2>Calculadora</h2>
        
 
        <%
         
            
          try {  
            if(request.getParameter("calcular")!=null)
            {
               
                
                int num1=Integer.parseInt(request.getParameter("param1"));
                int num2=Integer.parseInt(request.getParameter("param2"));
                int total=0;
                
                   switch(request.getParameter("operacion"))
                   {
                       case "suma":
                           total=num1-num2;
                           %>
                           <p>Total: <%= total %></p>
                           <%
                           break;
                       case "resta":
                           total=num1-num2;
                           %>
                           <p>Total: <%= total %></p>
                           <%
                           break;
                       case "multiplicacion":
                           total=num1*num2;
                           %>
                           <p>Total: <%= total %></p>
                           <%
                           break;
                        case "division":
                            total=num1/num2;
                            %>
                           <p>Total: <%= total %></p>
                           <%
                           break;
                   }
                   %>
        
        <% 
                  
            }
            } catch(NumberFormatException ex){
            %>
                Alguno de los números no contenía dígitos válidos...<BR><BR>
            <%
            }
         
            %>
            
            <%! public String fechaActual() {
                        Calendar fecha = Calendar.getInstance();
                        String dia = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                        String mes = Integer.toString(fecha.get(Calendar.MONTH));
                        String anyo = Integer.toString(fecha.get(Calendar.YEAR));
                        return "Dia " + dia + " del " + mes + " de " + anyo;
                    }
            %>
            <%= fechaActual() %><br/><br/>
           
            
            <form action="Calculadora.jsp" method="POST">
            Introduce el primer número:
            <input type="text" name="param1" value=""/><br/>
            Introduce el segundo número:
            <input type="text" name="param1" value=""/><br/>
            <label for="operacion">Operacion:</label>&nbsp;&nbsp; 
                <input type="radio" name="operacion" value="suma">Suma
                <input type="radio" name="operacion" value="resta" >Resta
                <input type="radio" name="operacion" value="multiplicacion">Multiplicacion
                <input type="radio" name="operacion" value="division" >Division<br/><br/>
                <input type="submit" name="calcular" value="Calcular" />&nbsp;&nbsp;&nbsp;&nbsp;
                <input  type="reset" value="Limpiar" class="boton" /><br/><br/><br/>
                <a id='volver' href='index.html'>Volver al Inicio</a>
        </form> 
    
    </body>
</html>
