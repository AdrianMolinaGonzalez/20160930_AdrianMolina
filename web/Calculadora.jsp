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
        
 <%! public String fechaActual() {
                        Calendar fecha = Calendar.getInstance();
                        String dia = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
                        String mes = Integer.toString(fecha.get(Calendar.MONTH));
                        String anyo = Integer.toString(fecha.get(Calendar.YEAR));
                        return "Dia " + dia + " del " + mes + " de " + anyo;
                    }
            %>
        <%
         
            
           
            if(request.getParameter("calcular")!=null)
            {
               
              try {
                  
                  
                int num1=Integer.parseInt(request.getParameter("param1"));
                int num2=Integer.parseInt(request.getParameter("param2"));
                int total=0;
                boolean error=false;
                String operador=null;
                
                   switch(request.getParameter("operacion"))
                   {
                       case "suma":
                           total=num1+num2;
                           operador="+";
                         
                           break;
                       case "resta":
                           total=num1-num2;
                           operador="-";
                           
                           break;
                       case "multiplicacion":
                           total=num1*num2;
                           operador="*";
                          
                           break;
                        case "division":
                        if(num2==0){
				%>
 				<p>El divisor es 0. </p>
 				<%
				error = true;
                                } else {
                            total=num1/num2;
                            operador="/";
                            }
                           
                   }
                    if(!error){
			%>
                        <p><%= fechaActual() %></p><br/><br/>
			<p><%=request.getHeader("user-agent") %></p>
                         <h2>El resultado de <%=num1 %> <%=operador %> <%=num2 %> = <%=total %></h2>
		 <%
		}
  
            } catch(NumberFormatException e){
            %>
                Alguno de los números no contenía dígitos válidos...<BR><BR>
         <%   
       }      
            
          
            }
     %>       
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
