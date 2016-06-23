/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.quiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
            stmt = con.prepareStatement("INSERT INTO usuario(login, nome, hash, administrador) VALUES ('?', '?', ?, ?)");
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
            stmt = con.prepareStatement("INSERT INTO questao(pergunta, resposta, alt1, alt2, alt3, alt4) VALUES ('?', '?', '?', '?', '?', '?')");
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
            stmt = con.prepareStatement("INSERT INTO historico(login, nome_usuario, pontuacao) VALUES ('?', '?',?)");
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
    
    public boolean altUsuario(String login_atual , Usuario usu){
        PreparedStatement stmt;
        
        try{
            Class.forName(Servidor);
            con = DriverManager.getConnection(urlbanco, usuarioB, senhaB);
            stmt = con.prepareStatement("UPDATE usuario SET login = '?' nome = '?', hash = ?, administracao = ? WHERE login = '?'");
            stmt.setString(1, usu.getLogin());
            stmt.setString(2, usu.getNome());
            stmt.setLong(3, usu.getHash());
            stmt.setBoolean(4, usu.isAdministrador());
            stmt.setString(5, login_atual);
            
            stmt.executeUpdate();
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }
    
    public boolean altQuestao(String pergunta_atual, Questao ques){
        PreparedStatement stmt;
        
        try{
            Class.forName(Servidor);
            con = DriverManager.getConnection(urlbanco, usuarioB, senhaB);
            stmt = con.prepareStatement("UPDATE questao SET pergunta = '?', resposta = '?', alt1 = '?', alt2 = '?', alt3 = '?', alt4 = '?' WHERE login = '?'");
            stmt.setString(1, ques.getPergunta());
            stmt.setString(2, ques.getResposta());
            stmt.setString(3, ques.getAlt1());
            stmt.setString(4, ques.getAlt2());
            stmt.setString(5, ques.getAlt3());
            stmt.setString(6, ques.getAlt4());
            stmt.setString(7, pergunta_atual);
            
            stmt.executeUpdate();
            return true;
        }catch(Exception ex){
            return false;
        }
        
    }
    
    public boolean excluir(String tabela, String coluna, String primary_key){
        PreparedStatement stmt;
        try{
            Class.forName(Servidor);
            con = DriverManager.getConnection(urlbanco, usuarioB, senhaB);
            stmt = con.prepareStatement("DELETE FROM ? WHERE ? = '?'");
            stmt.setString(1, tabela);
            stmt.setString(2, coluna);
            stmt.setString(3, primary_key);
            stmt.executeUpdate();
            return true;
        }catch(Exception ex){
            return false;
        } 
    }
    
    public static ArrayList<Usuario> getUsuarios(){
        ArrayList<Usuario> list = new ArrayList<>();
        
        Connection con; 
        Statement stmt;
        ResultSet rs;
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/quiz";
            con = DriverManager.getConnection(url,"app","app");
            String sql = "SELECT * FROM usuario";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Usuario q = new Usuario(
                                rs.getString("login"),
                                rs.getString("nome"),
                                rs.getLong("hash"),
                                rs.getBoolean("administracao")
                                );
                list.add(q);    
            }
                return list;
        }catch(Exception ex){
            return null;
        }
    }
    
    public static ArrayList<Questao> getQuestoes(){
        ArrayList<Questao> list = new ArrayList<>();
        
        Connection con; 
        Statement stmt;
        ResultSet rs;
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/quiz";
            con = DriverManager.getConnection(url,"app","app");
            String sql = "SELECT * FROM questao";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Questao q = new Questao(
                                rs.getString("pergunta"),
                                rs.getString("resposta"),
                                rs.getString("alt1"),
                                rs.getString("alt2"),
                                rs.getString("alt3"),
                                rs.getString("alt4")
                                );
                list.add(q);    
            }
                return list;
        }catch(Exception ex){
            return null;
        }
    }
    
    public static ArrayList<HistoricoQuiz> getHistorico(){
        ArrayList<HistoricoQuiz> list = new ArrayList<>();
        
        Connection con; 
        Statement stmt;
        ResultSet rs;
        
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String url = "jdbc:derby://localhost:1527/quiz";
            con = DriverManager.getConnection(url,"app","app");
            String sql = "SELECT * FROM historico";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                HistoricoQuiz h = new HistoricoQuiz(
                                rs.getInt("codigo"),
                                rs.getString("login"),
                                rs.getString("nome_usuario"),
                                rs.getDouble("pontuacao")
                                );
                list.add(h);    
            }
                return list;
        }catch(Exception ex){
            return null;
        }
    }
}
