package br.com.silbeckpro.hotelcontinentaljpa;

import java.text.NumberFormat;
import java.util.Locale;


public class Debito extends Pagamento {
    
 
    @Override
    public String toString() {
        NumberFormat formato = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        String valorFormatado = formato.format(getValor());
        return "Pagamento de " + valorFormatado + " no débito efetuado com sucesso!";
    }
}
