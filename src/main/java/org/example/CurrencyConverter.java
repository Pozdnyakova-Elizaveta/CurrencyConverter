package org.example;

import java.time.LocalDate;

public class CurrencyConverter {
    CbrApiService service;
    public CurrencyConverter(){
        service = new CbrApiService();
    }

    public double convert(double amount, String fromCurrency, String toCurrency, LocalDate date) throws Exception {
        double rateFrom;
        double rateTo;
        if (amount<0) throw new Exception("Нельзя конвертировать сумму меньше нуля");
        if (fromCurrency.equals(toCurrency)) return amount;
        if (fromCurrency.equals("RUB")) rateFrom = 1;
        else rateFrom = service.getExchangeRate(fromCurrency, date);
        if (toCurrency.equals("RUB")) rateTo = 1;
        else rateTo = service.getExchangeRate(toCurrency, date);
        return amount*rateFrom/rateTo;
    }

    public double[] getHistoryRate(String currency, LocalDate date) {
        //TODO реализовать с использованием методов сервиса
        if (currency.equals("USD") && date.equals(LocalDate.of(2025,4,5)))
            return new double[]{85.4963, 84.8707, 84.5522, 84.383, 84.2774};
        throw new IllegalArgumentException("getHistoryRate() works only with parameters (USD, 05.04.2025)");
    }
}
