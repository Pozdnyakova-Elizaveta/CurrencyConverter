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
}
