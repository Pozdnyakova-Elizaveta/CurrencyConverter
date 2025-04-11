package org.example;

import java.time.LocalDate;

public class CbrApiService {
    public CbrApiService(){

    }

    public String getXmlResponseRateByDate(LocalDate date) {
        //TODO подключить api
        if (date.equals(LocalDate.of(2025, 4, 5))) return XmlResponse.XML_RESPONSE_APRIL_5;
        else if (date.equals(LocalDate.of(2025, 4, 4))) return XmlResponse.XML_RESPONSE_APRIL_4;
        else if (date.equals(LocalDate.of(2025, 4, 3))) return XmlResponse.XML_RESPONSE_APRIL_3;
        else if (date.equals(LocalDate.of(2025, 4, 2))) return XmlResponse.XML_RESPONSE_APRIL_2;
        else if (date.equals(LocalDate.of(2025, 4, 1))) return XmlResponse.XML_RESPONSE_APRIL_1;
        throw new IllegalArgumentException("getXmlResponseRateByDate() works only April 5, 4, 3, 2, 1");
    }

    public double getExchangeRate(String currency, LocalDate date) {
        //TODO реализовать с использованием getXmlResponseRateByDate
        if (currency.equals("USD") && date.equals(LocalDate.of(2025, 4, 5))) return 84.2774;
        throw new IllegalArgumentException("getXmlResponseRateByDate() works only with parameters (USD, 05.04.2025)");
    }
}
