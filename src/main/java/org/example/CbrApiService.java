package org.example;

import java.time.LocalDate;

public class CbrApiService {
    public CbrApiService(){

    }

    public String getXmlResponseRateByDate(LocalDate date) {
        //TODO подключить api
        if (date.equals(LocalDate.of(2025, 4, 5))) return XmlResponse.XML_RESPONSE_APRIL_5;
        throw new IllegalArgumentException("getXmlResponseRateByDate() works only April 5");
    }
}
