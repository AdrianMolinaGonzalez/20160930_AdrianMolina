<%-- 
    Document   : Saludo
    Created on : 10-oct-2016, 20:10:55
    Author     : Adrián
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.time.LocalTime" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/estilosweb.css" > 
        <title>Saludo JSP</title>
    </head>
    <body>
        <%
            String tipo_saludo="";
            String usted="";
            //dependiendo del sexo le digo que muestre Señor o Señora
            if(request.getParameter("sexo").equals("hombre"))
            {
                usted="Señor";
                } 
            else
            {
                usted="Señora";
            }
             
            //Dependiendo de la franja horaria mostrare Buenos Dias, Buenas Tardes o Buenas Noches
            if(LocalTime.now().getHour() > 8 && LocalTime.now().getHour() < 14)
            {
                tipo_saludo="Buenas Dias";
            }
            else if(LocalTime.now().getHour() >= 14 && LocalTime.now().getHour() < 9)
            {
                tipo_saludo="Buenas Tardes";
            }
            else
            {
                tipo_saludo="Buenas Noches";
            }
            %>
            
            <h1>Saludo</h1>
            <br/>
            <p><%= tipo_saludo %> , <%= usted %> <%= request.getParameter("nombre") %> </p><br/><br/><br/>
            <a id='volver' href='index.html'>Volver al Inicio</a>
    </body>
</html>
