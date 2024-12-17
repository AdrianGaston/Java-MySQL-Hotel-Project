package br.com.silbeckpro.hotelcontinentaljpa;

import java.text.NumberFormat;
import java.util.Locale;


public class Dinheiro extends Pagamento {
    
    @Override
    public String toString() {
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorFormatado = formato.format(getValor());
        return "Pagamento de " + valorFormatado + " em dinheiro efetuado com sucesso!";
    }
}
