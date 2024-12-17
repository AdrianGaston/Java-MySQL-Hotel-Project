package br.com.silbeckpro.hotelcontinentaljpa;


public class Usuario {
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String tipo;
    
    //Getters & Setters
    public int getId() {
        return id;
    }   

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {    
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Olá '" + nome + "', sua permissão é de tipo '" + tipo + "'. Seja bem-vindo(a)!";
    }   
}
