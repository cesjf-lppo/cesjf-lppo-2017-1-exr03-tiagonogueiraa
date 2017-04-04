/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lppo;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ListaVisitanteSaidaServlet", urlPatterns = {"/ListaSaida.html"})
public class ListaVisitanteSaidaServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	//criar lista
	List<Visitante> visitantes = new ArrayList<>();
	
	//pegar os dados do banco
	try {
	    //configurando conexao
	    Class.forName("org.apache.derby.jdbc.ClientDriver");
	    Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario" , "senha");
	    Statement operacao = conexao.createStatement();
	    ResultSet resultado = operacao.executeQuery("SELECT * FROM visitante WHERE saida IS NULL");

	    while(resultado.next()){
		Visitante v = new Visitante();
		v.setId(resultado.getLong("id"));
		v.setNome(resultado.getString("nome"));
		v.setIdade(resultado.getInt("idade"));
		v.setEntrada(resultado.getDate("entrada"));
		v.setSaida(resultado.getDate("saida"));
		visitantes.add(v);	
		
	    }
    }	catch (ClassNotFoundException ex) {
	    Logger.getLogger(ListaVisitanteSaidaServlet.class.getName()).log(Level.SEVERE, null, ex);
	} catch (SQLException ex) {
	    Logger.getLogger(ListaVisitanteSaidaServlet.class.getName()).log(Level.SEVERE, null, ex);
	}
    request.setAttribute("visitantes", visitantes);
    request.getRequestDispatcher("WEB-INF/ListaSaida.jsp").forward(request, response);
    }
    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	Long id = 
    

    }
    }

