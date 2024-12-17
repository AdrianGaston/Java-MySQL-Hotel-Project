package br.com.silbeckpro.hotelcontinentaljpa;

import java.text.NumberFormat;
import java.util.Locale;


public class Credito extends Pagamento {
    private boolean aVista;
    private int numeroParcelas;

    public Credito() {
    }

    public Credito(boolean aVista, int numeroParcelas) {
        this.aVista = aVista;
        this.numeroParcelas = numeroParcelas;
    }
    
    @Override
    public String toString() {
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorFormatado = formato.format(getValor());
        if (aVista) {
            return "Pagamento de " + valorFormatado + " no crédito à vista efetuado com sucesso!";
        } else {
            return "Pagamento de " + valorFormatado + " no crédito em " + numeroParcelas + "x efetuado com sucesso!";
        }
    }
}
