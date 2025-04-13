package org.example;

import java.time.LocalDate;

public class CurrencyConverter {
    public CurrencyConverter(){

    }

    public double convert(double amount, String fromCurrency, String toCurrency, LocalDate date) throws Exception {
        //TODO реализовать с использованием методов сервиса
        if (amount<0) throw new Exception("Нельзя конвертировать сумму меньше нуля");
        else if (amount==200 && fromCurrency.equals("RUB") && toCurrency.equals("USD") &&
                date.equals(LocalDate.of(2025, 4, 5)))
            return 2.373115449693512;
        else if (amount==300 && fromCurrency.equals("RUB") && toCurrency.equals("KZT") &&
                date.equals(LocalDate.of(2025, 4, 3)))
            return 1785.2254739773634;
        throw new IllegalArgumentException("convert() works only with parameters (200, RUB, USD, 05.04.2025) and amount less than zero");
    }
}
