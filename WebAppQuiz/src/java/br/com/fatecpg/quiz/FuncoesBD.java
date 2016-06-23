/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author david_000
 */
public class FuncoesBD {
    private String Servidor = "org.apache.derby.jdbc.ClientDriver";
    private String urlbanco = "jdbc:derby://localhost:1527/quiz";
    private String usuarioB = "app";
    private String senhaB = "app";
    Connection con = null; 
    public String sqlc = "";
    public boolean cadUsuario(Usuario usu){
        PreparedStatement stmt;
        
        try{
            Class.forName(Servidor);
            con = DriverManager.getConnection(urlbanco, usuarioB, senhaB);
            stmt = con.prepareStatement("INSERT INTO usuario(login, nome, hash, administrador) VALUES (?,?,?,?)");
            stmt.setString(1, usu.getLogin());
            stmt.setString(2, usu.getNome());
            stmt.setLong(3, usu.getHash());
            stmt.setBoolean(4, usu.isAdministrador());
            sqlc = stmt.toString();
            stmt.executeUpdate();
            return true;
        }catch(Exception ex){
            System.out.println("erro: "+ ex.getMessage() +"\n" +ex.getLocalizedMessage());
            return false;
        }
        
    }
    
    public boolean cadQuestao(Questao ques){
        PreparedStatement stmt;
        
        try{
            Class.forName(Servidor);
            con = DriverManager.getConnection(urlbanco, usuarioB, senhaB);
            stmt = con.prepareStatement("INSERT INTO questao(pergunta, resposta, alt1, alt2, alt3, alt4) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, ques.getPergunta());
            stmt.setString(2, ques.getResposta());
            stmt.setString(3, ques.getAlt1());
            stmt.setString(4, ques.getAlt2());
            stmt.setString(5, ques.getAlt3());
            stmt.setString(6, ques.getAlt4());
            
            sqlc = stmt.toString();
            stmt.executeUpdate();
            return true;
        }catch(Exception ex){
            System.out.println("erro: "+ ex.getMessage() +"\n" +ex.getLocalizedMessage());
            return false;
        }
        
    }
    
    public boolean cadHistorico(HistoricoQuiz his){
        PreparedStatement stmt;
        
        try{
            Class.forName(Servidor);
            con = DriverManager.getConnection(urlbanco, usuarioB, senhaB);
            stmt = con.prepareStatement("INSERT INTO historico(login, nome_usuario, pontuacao) VALUES (?,?,?)");
            stmt.setString(1, his.getLogin());
            stmt.setString(2, his.getNome_usuario());
            stmt.setDouble(3, his.getPontuacao());
            sqlc = stmt.toString();
            stmt.executeUpdate();
            return true;
        }catch(Exception ex){
            System.out.println("erro: "+ ex.getMessage() +"\n" +ex.getLocalizedMessage());
            return false;
        }
        
    }
    
    
    
}
