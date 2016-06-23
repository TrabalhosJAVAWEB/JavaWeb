/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.quiz;

import java.util.Date;

/**
 *
 * @author david_000
 */
public class HistoricoQuiz {
    private int codigo;
    private String login;
    private String nome_usuario;
    private double pontuacao;

    public HistoricoQuiz(int codigo, String login, String nome_usuario, double pontuacao) {
        this.codigo = codigo;
        this.login = login;
        this.nome_usuario = nome_usuario;
        this.pontuacao = pontuacao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(double pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    
}
