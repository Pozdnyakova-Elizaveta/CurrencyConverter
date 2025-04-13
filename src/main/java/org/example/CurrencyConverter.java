package org.example;

import java.time.LocalDate;
import java.util.Arrays;

public class CurrencyConverter {
    CbrApiService service;
    public CurrencyConverter(){
        service = new CbrApiService();
    }

    /**
     * Конвертация из одной валюты в другую
     * @param amount число-сумма
     * @param fromCurrency текущая валюта
     * @param toCurrency валюта для конвертации
     * @param date дата, для которой запрашивается курс валют
     * @return число - сумма после конвертации
     * @throws Exception переданная сумма меньше нуля
     */
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

    public double[] getHistoryRate(String currency, LocalDate date) throws Exception {
        double[] rates = new double[5];
        for (int i=0; i!=rates.length; i++)
            rates[4-i] = service.getExchangeRate(currency, date.minusDays(i));
        return rates;
    }

    public double[] currencyRatePrediction(String currency, LocalDate date) throws Exception {
        double[] rates = getHistoryRate(currency, date);
        double[] ratesPrediction = Arrays.copyOf(rates, 10);
        double sum=0;
        for (int i=0; i!=rates.length; i++){
            sum+=rates[i];
        }
        for (int i=rates.length; i!=ratesPrediction.length; i++){
            if (i!=rates.length) sum = sum-rates[i-1-rates.length]+ratesPrediction[i-1];
            ratesPrediction[i] = sum/5;
        }
        return ratesPrediction;
    }
}
