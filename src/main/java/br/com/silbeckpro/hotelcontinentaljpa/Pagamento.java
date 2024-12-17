package br.com.silbeckpro.hotelcontinentaljpa;


public class Pagamento {
    private int id;
    private double valor;
    private String dataPagamento;
    private String statusPagamento;
    
    //Construtores
    public Pagamento() {
    }

    public Pagamento(int id, double valor) {
        this.id = id;
        this.valor = valor;
    }
    
    //Getters & Setters
    public int getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }  
}
