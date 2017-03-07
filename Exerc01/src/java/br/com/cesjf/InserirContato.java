package br.com.cesjf;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "InserirContato", urlPatterns = {"/Inserir"})
public class InserirContato extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String telefone = request.getParameter("telefone");
        
        Logger.getLogger(InserirContato.class.getName()).log(Level.INFO, "POST: " +nome+"" +sobrenome+""+telefone+"");
        
        try {Class.forName("jdbc:derby://localhost:1527/Agenda");
        String url = "";
            
        } catch (Exception e) {
        }
        
    }

    

}
