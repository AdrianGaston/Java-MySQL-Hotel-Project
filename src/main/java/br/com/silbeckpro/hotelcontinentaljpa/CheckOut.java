package br.com.silbeckpro.hotelcontinentaljpa;


public class CheckOut {
    private Reserva reserva;
    
    //Construtores
    public CheckOut() {
    }

    public CheckOut(Reserva reserva) {
        this.reserva = reserva;
    }
    
    //Getters & Setters
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }  
}
