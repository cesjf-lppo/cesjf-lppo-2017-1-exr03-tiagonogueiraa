<%-- 
    Document   : teste
    Created on : 23/02/2017, 20:45:48
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    int a =20;
    float b= a*1.56f;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Teste de JSP</h1>
        <p>
    <font size="3" face="Verdana" color="red"><% out.println("Meu texto do Java");%></font>
        <p>
            <%
                if(Math.random() <0.5)
                {out.println("Hoje haverá Sol<b>");
                } else
                {out.println("Hoje <b>Choverá<b>");}
            %>
        <p>
            <b> <%= b %></b>
    </body>
</html>
