import org.example.CurrencyConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CurrencyConverterTest {
    @Test
    void currencyConverterClassCreationTest() {
        CurrencyConverter converter = new CurrencyConverter();
        Assertions.assertNotNull(converter);
    }
}
