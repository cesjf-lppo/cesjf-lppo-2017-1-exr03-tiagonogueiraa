package br.com.cesjf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Agenda {

    public static void main(String[] args) {
        
         try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
             String url = "jdbc:derby://localhost:1527//lppo-2017-1";  
             Connection conexao = DriverManager.getConnection(url, "usuario", "senha");
             System.out.println("Conexao aberta com sucesso");
             
             String sql = " CREATE TABLE contatos (nome VARCHAR (50), sobrenome VARCHAR (50) , telefone INTEGER atualizado TIMESTAMP)";
             Statement operacao = conexao.createStatement();
             operacao.executeUpdate(sql);
             System.out.println("Tabela criada!");
             
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver Indisponivel");
            Logger.getLogger(CarregaDriver.class.getName()).log(Level.SEVERE, null, ex);
            
            
        } catch (SQLException ex) {
            System.err.println("Problema ao acessar o banco ");
            Logger.getLogger(Agenda.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}

    

