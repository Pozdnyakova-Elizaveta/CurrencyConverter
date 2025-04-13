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
        else if (currency.equals("KZT") && date.equals(LocalDate.of(2025,4,5)))
            return new double[]{0.169831, 0.168247, 0.168046, 0.167743, 0.168027};
        throw new IllegalArgumentException("getHistoryRate() works only with parameters (USD, 05.04.2025), (KZT, 05.04.2025)");
    }

    public double[] currencyRatePrediction(String currency, LocalDate date) {
        //TODO реализовать с использованием getHistoryRate()
        if (currency.equals("USD") && date.equals(LocalDate.of(2025, 4, 5)))
            return new double[]{85.4963, 84.8707, 84.5522, 84.383, 84.2774, 84.71592000000001,
                84.559844, 84.4976728, 84.48676736, 84.507520832};
        else if (currency.equals("KZT") && date.equals(LocalDate.of(2025, 4, 5)))
            return new double[]{0.169831, 0.168247, 0.168046, 0.167743, 0.168027, 0.1683788, 0.16808836,
                    0.168056632, 0.1680587584, 0.16812191008};
        throw new IllegalArgumentException("currencyRatePrediction() works only with parameters (USD, 05.04.2025), (KZT, 05.04.2025)");
    }
}
