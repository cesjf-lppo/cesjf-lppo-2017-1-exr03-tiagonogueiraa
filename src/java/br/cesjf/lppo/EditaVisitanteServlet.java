/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
 * @author tiago
 */
@WebServlet(name = "EditaReclamacaoServlet", urlPatterns = {"/Edita.html"})
public class EditaVisitanteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	Visitante visitante = new Visitante();
	Long id = Long.parseLong(request.getParameter("id"));

	try {
	    //pegar os dados do banco
	    Class.forName("org.apache.derby.jdbc.ClientDriver");
	    Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
	    Statement operacao = conexao.createStatement();
	    ResultSet resultado = operacao.executeQuery("SELECT * visitante WHERE id=" + id);

	    if (resultado.next()) {
		visitante.setId(resultado.getLong("id"));
		visitante.setNome(resultado.getString("nome"));
		visitante.setIdade(resultado.getInt("idade"));
		visitante.setEntrada(resultado.getDate("entrada"));
		visitante.setSaida(resultado.getDate("saida"));
	    }

	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(EditaVisitanteServlet.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SQLException ex) {
	    Logger.getLogger(EditaVisitanteServlet.class.getName()).log(Level.SEVERE, null, ex);
	}

	request.setAttribute("visitante", visitante);
	request.getRequestDispatcher("WEB-INF/EditaVisitante.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	Visitante visitante = new Visitante();

	visitante.setNome(request.getParameter("nome"));
	visitante.setIdade(Integer.parseInt(request.getParameter("idade")));

	try {
	    Class.forName("org.apache.derby.jdbc.ClientDriver");
	    
	    Connection conexao = DriverManager.getConnection("jdbc.derby://localhost:1527/lppo-2017-1", "usuario", "senha");
	    Statement operacao = conexao.createStatement();

	    operacao.executeUpdate("UPDATE visitante SET nome'"
		    + visitante.getNome() + "', idade="
		    + visitante.getIdade() + "WHERE ida="
		    + visitante.getId());

	} catch (ClassNotFoundException ex) {
	    Logger.getLogger(EditaVisitanteServlet.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SQLException ex) {
	    Logger.getLogger(EditaVisitanteServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
	
	response.sendRedirect("lista.html");

    }

}
