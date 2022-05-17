import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DateUtilTest {

    @DisplayName("Number of days should be added correctly to the given date")
    @ParameterizedTest(name = "{index} => initialDate={0}, daysToAdd={1}, resultingDate={2}")
    @CsvSource({
            "10.01.2008, 10, 20.01.2008",
            "29.06.2020, 8, 07.07.2020"
    })

    public void dateUtilTest(String initialDate, int daysToAdd, String resultingDate) {
        assertEquals(DateUtil.addDays(initialDate, daysToAdd), resultingDate);
    }

}
