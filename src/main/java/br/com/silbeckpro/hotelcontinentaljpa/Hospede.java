package br.com.silbeckpro.hotelcontinentaljpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Hospede {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String cpf;
    private String nome;
    private String cep;
    private String endereco;
    private String cidade;
    private String telefone;
    
    //Construtores
    public Hospede() {
    }

    public Hospede(String cpf, String nome, String cep, String endereco, String cidade, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.cep = cep;
        this.endereco = endereco;
        this.cidade = cidade;
        this.telefone = telefone;
    }
    
    public Hospede(int id, String cpf, String nome, String cep, String endereco, String cidade, String telefone) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.cep = cep;
        this.endereco = endereco;
        this.cidade = cidade;
        this.telefone = telefone;
    }
    
    //Getters & Setters
    public int getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nome;
    }
}
