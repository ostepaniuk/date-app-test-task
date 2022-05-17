import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static String addDays(String d, int numberOfDaysToAdd) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
        LocalDate date = LocalDate.parse(d, formatter);
        LocalDate date2 = date.plusDays(numberOfDaysToAdd);
        return date2.format(formatter);
    }
}