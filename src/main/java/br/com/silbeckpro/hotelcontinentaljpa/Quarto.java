package br.com.silbeckpro.hotelcontinentaljpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Quarto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String numero;

    @ManyToOne
    @JoinColumn(name = "categoria_quarto_id", nullable = false)
    private Categoria categoria;
    
    //Construtores
    public Quarto() {
    }

    public Quarto(String numero, Categoria categoria) {
        this.numero = numero;
        this.categoria = categoria;
    }
    
    //Getters & Setters
    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return this.numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Quarto)) return false;
        Quarto other = (Quarto) obj;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}