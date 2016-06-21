/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.quiz;

/**
 *
 * @author david_000
 */
public class Alternativa {
    String codigo;
    String resposta;
    boolean certa;
    int codigo_pergunta;

    public Alternativa(String codigo, String resposta, boolean certa, int codigo_pergunta) {
        this.codigo = codigo;
        this.resposta = resposta;
        this.certa = certa;
        this.codigo_pergunta = codigo_pergunta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public boolean isCerta() {
        return certa;
    }

    public void setCerta(boolean certa) {
        this.certa = certa;
    }

    public int getCodigo_pergunta() {
        return codigo_pergunta;
    }

    public void setCodigo_pergunta(int codigo_pergunta) {
        this.codigo_pergunta = codigo_pergunta;
    }
}
