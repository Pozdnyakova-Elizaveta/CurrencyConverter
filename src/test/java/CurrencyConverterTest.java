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
    @Test
    void converting200RUBToUSDTest() {
        CurrencyConverter converter = new CurrencyConverter();
        double res = Assertions.assertDoesNotThrow(()->
                converter.convert(200, "RUB", "USD", LocalDate.of(2025, 4, 5)));
        Assertions.assertEquals(2.373115449693512, res);
    }
    @Test
    void converting300RUBToKZTTest() {
        CurrencyConverter converter = new CurrencyConverter();
        double res = Assertions.assertDoesNotThrow(()->
                converter.convert(300, "RUB", "KZT", LocalDate.of(2025, 4, 3)));
        Assertions.assertEquals(1785.2254739773634, res);
    }
    @Test
    void getHistoryRateUSD5April(){
        CurrencyConverter converter = new CurrencyConverter();
        double[] expected = new double[]{85.4963, 84.8707, 84.5522, 84.383, 84.2774};
        double[] res = Assertions.assertDoesNotThrow(()->
                converter.getHistoryRate("USD", LocalDate.of(2025, 4, 5)));
        Assertions.assertArrayEquals(expected, res);
    }
    @Test
    void getHistoryRateKZT5April(){
        CurrencyConverter converter = new CurrencyConverter();
        double[] expected = new double[]{0.169831, 0.168247, 0.168046, 0.167743, 0.168027};
        double[] res = Assertions.assertDoesNotThrow(()->
                converter.getHistoryRate("KZT", LocalDate.of(2025, 4, 5)));
        Assertions.assertArrayEquals(expected, res);
    }
    @Test
    void currencyRatePredictionUSD5April(){
        CurrencyConverter converter = new CurrencyConverter();
        double[] expected = new double[]{85.4963, 84.8707, 84.5522, 84.383, 84.2774, 84.71592000000001,
                84.559844, 84.4976728, 84.48676736, 84.507520832};
        double[] res = Assertions.assertDoesNotThrow(()->
                converter.currencyRatePrediction("USD", LocalDate.of(2025, 4, 5)));
        Assertions.assertArrayEquals(expected, res);
    }
}
