
package br.com.fatecpg.quiz;

public class Usuario {
    
    private String Login;
    private String nome;
    private long hash;
    private boolean administrador;

    public Usuario(String Login, String nome, long hash, boolean administrador) {
        this.Login = Login;
        this.nome = nome;
        this.hash = hash;
        this.administrador = administrador;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public boolean isAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }
}
