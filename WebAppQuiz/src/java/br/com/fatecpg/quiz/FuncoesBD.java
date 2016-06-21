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
    
}
