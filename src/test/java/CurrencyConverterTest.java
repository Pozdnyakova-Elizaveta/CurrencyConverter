import org.example.CurrencyConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CurrencyConverterTest {
    @Test
    void currencyConverterClassCreationTest() {
        CurrencyConverter converter = new CurrencyConverter();
        Assertions.assertNotNull(converter);
    }
    @Test
    void convertingAmountLessThanZeroTest() {
        CurrencyConverter converter = new CurrencyConverter();
        Exception exception = Assertions.assertThrows(Exception.class, () ->
                converter.convert(-1, "RUB", "USD", LocalDate.of(2025,4,4)));
        String expectedMessage = "Нельзя конвертировать сумму меньше нуля";
        String actualMessage = exception.getMessage();
        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}
