package org.example;

import java.time.LocalDate;

public class CurrencyConverter {
    public CurrencyConverter(){

    }

    public void convert(double amount, String fromCurrency, String toCurrency, LocalDate date) throws Exception {
        if (amount<0) throw new Exception("Нельзя конвертировать сумму меньше нуля");
        throw new IllegalArgumentException("convert() works only with amount less than zero");
    }
}
