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
}
