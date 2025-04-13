package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
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

    public double getExchangeRate(String currency, LocalDate date) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        String xml = getXmlResponseRateByDate(date);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new ByteArrayInputStream(xml.getBytes("Windows-1251")));
        NodeList valutes = doc.getElementsByTagName("Valute");
        for (int i = 0; i < valutes.getLength(); i++) {
            Node valute = valutes.item(i);
            if (valute.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) valute;
                String code = element.getElementsByTagName("CharCode").item(0).getTextContent();
                if (currency.equals(code)) {
                    String value = element.getElementsByTagName("Value").item(0).getTextContent();
                    String nominal = element.getElementsByTagName("Nominal").item(0).getTextContent();
                    return Double.parseDouble(value.replace(",", "."))/Double.parseDouble(nominal);
                }
            }
        }
        throw new Exception("Валюта " + currency + " не найдена");
    }
}
