package br.com.silbeckpro.hotelcontinentaljpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String descricao;
    private String capacidade;
    
    @Column(name = "valordiaria")
    private double valorDiaria;
    
    //Construtores
    public Categoria() {
    }

    public Categoria(int id, String descricao, String capacidade, double valorDiaria) {
        this.id = id;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.valorDiaria = valorDiaria;
    }
    
    //Getters & Setters
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
