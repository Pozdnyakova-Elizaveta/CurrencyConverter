import org.example.XmlResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.CbrApiService;

import java.time.LocalDate;


public class CbrApiServiceTest {
    @Test
    void cbrApiServiceClassCreationTest() {
        CbrApiService service = new CbrApiService();
        Assertions.assertNotNull(service);
    }
    @Test
    void getXmlResponseRateByDateApril5Test(){
        CbrApiService service = new CbrApiService();
        Assertions.assertEquals(XmlResponse.XML_RESPONSE_APRIL_5,
                service.getXmlResponseRateByDate(LocalDate.of(2025, 4, 5)));
    }
    @Test
    void getXmlResponseRateByDateApril4Test(){
        CbrApiService service = new CbrApiService();
        Assertions.assertEquals(XmlResponse.XML_RESPONSE_APRIL_4,
                service.getXmlResponseRateByDate(LocalDate.of(2025, 4, 4)));
    }
    @Test
    void getXmlResponseRateByDateApril3Test(){
        CbrApiService service = new CbrApiService();
        Assertions.assertEquals(XmlResponse.XML_RESPONSE_APRIL_3,
                service.getXmlResponseRateByDate(LocalDate.of(2025, 4, 3)));
    }
    @Test
    void getXmlResponseRateByDateApril2Test(){
        CbrApiService service = new CbrApiService();
        Assertions.assertEquals(XmlResponse.XML_RESPONSE_APRIL_2,
                service.getXmlResponseRateByDate(LocalDate.of(2025, 4, 2)));
    }
    @Test
    void getXmlResponseRateByDateApril1Test(){
        CbrApiService service = new CbrApiService();
        Assertions.assertEquals(XmlResponse.XML_RESPONSE_APRIL_1,
                service.getXmlResponseRateByDate(LocalDate.of(2025, 4, 1)));
    }
    @Test
    void getExchangeRateUSDApril5Test(){
        CbrApiService service = new CbrApiService();
        double res = Assertions.assertDoesNotThrow(()->
                service.getExchangeRate("USD", LocalDate.of(2025, 4, 5)));
        Assertions.assertEquals(84.2774, res);
    }
    @Test
    void getExchangeRateKZTApril3Test(){
        CbrApiService service = new CbrApiService();
        double res = Assertions.assertDoesNotThrow(()->
                service.getExchangeRate("KZT", LocalDate.of(2025, 4, 3)));
        Assertions.assertEquals(0.168046, res);
    }
    @Test
    void getExchangeRateNonExistentCurrencyTest(){
        String currency = "TTT";
        CbrApiService service = new CbrApiService();
        Exception exception = Assertions.assertThrows(Exception.class, () ->
                service.getExchangeRate(currency, LocalDate.of(2025,4,4)));
        String expectedMessage = "Валюта TTT не найдена";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
