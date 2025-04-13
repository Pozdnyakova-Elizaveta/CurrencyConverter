package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CbrApiService {
    private final String URL = "https://www.cbr.ru/scripts/XML_daily.asp?date_req=";
    private final HttpClient httpClient;
    public CbrApiService(){
        this.httpClient = HttpClient.newHttpClient();
    }

    /**
     * Получение курса валют с помощью API
     * @param date дата, для которой запрашивается курс валют
     * @return строка с xml-ответом курса
     * @throws IOException ошибка ввода-вывода при отправке запроса
     * @throws InterruptedException поток выполнения был прерван во время ожидания ответа
     */
    public String getXmlResponseRateByDate(LocalDate date) throws IOException, InterruptedException {
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + formattedDate))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );
        return response.body();
    }

    /**
     * Получение текущего курса валюты относительно рубля
     * @param currency код валюты
     * @param date дата, для которой запрашивается курс валюты
     * @return число, сколько рублей в 1 единице этой валюты
     * @throws Exception возникли ошибки при парсинге xml
     */
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
