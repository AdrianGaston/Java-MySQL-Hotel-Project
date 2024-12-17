package br.com.silbeckpro.hotelcontinentaljpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "reservas")
public class Reserva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 
    
    @ManyToOne
    @JoinColumn(name = "hospede_id", nullable = false)
    private Hospede hospede;
    
    private LocalDate checkin;
    private LocalDate checkout;
    
    @ManyToOne
    @JoinColumn(name = "quarto_id", nullable = false)
    private Quarto quarto;
    
    private Integer totalDias;
    private Double valorTotal;
    private String estatus;
    
    //Construtores
    public Reserva() {
    }

    public Reserva(int id, Hospede hospede, LocalDate checkin, LocalDate checkout, Quarto quarto, Integer totalDias, Double valorTotal, String estatus) {
        this.id = id;
        this.hospede = hospede;
        this.checkin = checkin;
        this.checkout = checkout;
        this.quarto = quarto;
        this.totalDias = totalDias;
        this.valorTotal = valorTotal;
        this.estatus = estatus;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public void setCheckin(LocalDate checkin) {
        this.checkin = checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalDate checkout) {
        this.checkout = checkout;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
    
    public void calcularValores() {
        this.totalDias = (int) ChronoUnit.DAYS.between(checkin, checkout);
        this.valorTotal = totalDias * quarto.getCategoria().getValorDiaria();
    }
    
    public Integer getTotalDias() {
        return totalDias;
    }
    
    public void setTotalDias(Integer totalDias) {
        this.totalDias = totalDias;
    }

    public Double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String checkInFormatado = checkin.format(formatoData);
        
        return "Reserva para '" + hospede + "' no dia " + checkInFormatado + " realizada com sucesso!";
    }
}
