<%-- 
    Document   : InserirVisitante
    Created on : 27/03/2017, 21:38:16
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo visitante</title>
	     
    <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"  />

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" />

        <!-- Latest compiled and minified JavaScript -->
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
    </head>
    <body class="container">
        <h1>Novo visitante</h1>
	<p>
	<form class="form-inline" method="post">
	    <div class="form-group">
	    <div><input type="hidden" name="id" value="${visitante.id}" /> id: ${visitante.id}</div>
	    <label for="exampleInputName" >Nome:</label>
	    <input type="text" class="form-control" id="exampleInputName2" placeholder="Nome" name="nome" value="${visitante.nome}" size="50" />
	    </div><br><br>
	    
	    <div class="form-group">
	<label for="exampleInputName" >Idade:</label>
	<input value="${visitante.idade}" type="number" class="form-control" id="exampleInputName2" placeholder="Idade" name="idade" /><br><br>
	 <input class="btn btn-default" type="submit" value="Gravar"/>
	</form></p>
	  
    </body>
</html>
