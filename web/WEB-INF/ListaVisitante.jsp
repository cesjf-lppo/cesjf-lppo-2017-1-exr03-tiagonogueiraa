<%-- 
    Document   : ListaVisitante
    Created on : 02/04/2017, 16:27:40
    Author     : tiago
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Visitante</title>
    </head>
    <body>
        <h1>Lista Visitante</h1><table border="1">
	    <thead>
		<tr>
		    <th>ID</th>
		    <th>Nome</th>
		    <th>Idade</th>
		    <th>Entrada</th>
		    <th>Saida</th>
		</tr>
	    </thead>
	    <c:forEach var="visitante" items="${visitantes}">
	    <tbody>
		<tr>
		    <td>${visitante.id}</td>
		    <td>${visitante.nome}</td>
		    <td>${visitante.idade}</td>
		    <td>${visitante.entrada}</td>
		    <td>${visitante.saida}</td>
		    <td><a href="ExcluiVisitante.html?id=${visitante.id}">X</a></td>	
		</tr>
	    </c:forEach>
	    </tbody>
	</table>

    </body>
</html>
