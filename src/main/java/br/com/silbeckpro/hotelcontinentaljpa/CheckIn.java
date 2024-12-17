package br.com.silbeckpro.hotelcontinentaljpa;


public class CheckIn {
    private Reserva reserva;
    
    //Construtores
    public CheckIn() {
    }

    public CheckIn(Reserva reserva) {
        this.reserva = reserva;
    }
    
    //Getters & Setters
    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "CheckIn{" + "reserva=" + reserva + '}';
    }
}
