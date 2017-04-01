/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(name = "NovoVisitanteServlet", urlPatterns = {"/NovoVisitante.html"})
public class NovoVisitanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	//pegar o jsp e responder para o usuário
	request.getRequestDispatcher("WEB-INF/InserirVisitante.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	//pegar dados do formulario e inserir no banco
	Visitante visitante = new Visitante();

	visitante.setNome((request.getParameter("nome")));
	visitante.setIdade(Integer.parseInt(request.getParameter("idade")));

	try {
	    Class.forName("org.apache.derby.jdbc.ClientDriver");

	    String url = "jdbc:derby://localhost:1527/lppo-2017-1";

	    Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
	    
	    Statement operacao = conexao.createStatement();

	    String sql = "INSERT INTO visitante(nome, idade) VALUES ('"
		    + visitante.getNome() + "',"
		    + visitante.getIdade()+ ")";
	    operacao.executeUpdate(sql);

	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(NovoVisitanteServlet.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SQLException ex) {
	    Logger.getLogger(NovoVisitanteServlet.class.getName()).log(Level.SEVERE, null, ex);
	}

	response.sendRedirect("lista.html");
    }

}
