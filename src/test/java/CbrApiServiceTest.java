import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.CbrApiService;
public class CbrApiServiceTest {
    @Test
    void cbrApiServiceClassCreationTest() {
        CbrApiService service = new CbrApiService();
        Assertions.assertNotNull(service);
    }
}
