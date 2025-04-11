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
        throw new IllegalArgumentException("getXmlResponseRateByDate() works only April 5, 4, 3, 2");
    }
}
