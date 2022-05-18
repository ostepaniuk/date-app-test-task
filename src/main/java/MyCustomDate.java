import java.util.*;

public class MyCustomDate {

    private final int day;
    private final int month;
    private final int year;

    List<Month> allMonths = Arrays.asList(Month.values());
    private final Map<Month, Integer> daysInMonth;

    public MyCustomDate(String date) {

        String[] strParts = date.split("\\.");
        this.day = Integer.parseInt(strParts[0]);
        this.month = Integer.parseInt(strParts[1]);
        this.year = Integer.parseInt(strParts[2]);
        daysInMonth = generateDaysInMonthMap(year);
    }

    public MyCustomDate addDays(int noOfDaysToAdd) {

        int newDay = day;
        int newMonth = month;
        Month currentMonth = allMonths.get(month - 1);
        int newYear = year;

        for (int d = 0; d < noOfDaysToAdd; d++) {
            newDay++;
            if (newDay > daysInMonth.get(currentMonth)) {
                newDay = 1;
                newMonth++;
                if (newMonth > 12) {
                    newMonth = 1;
                    newYear++;
                }
            }
        }

        return new MyCustomDate(newDay + "." + newMonth + "." + newYear);
    }

    @Override
    public String toString() {
        String dd = String.valueOf(day);
        String mm = String.valueOf(month);
        if (day < 10) {
            dd = "0" + day;
        }
        if (month < 10) {
            mm = "0" + month;
        }

        return dd + "." + mm + "." + year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyCustomDate date = (MyCustomDate) o;
        return day == date.day && month == date.month && year == date.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    private Map<Month, Integer> generateDaysInMonthMap(int year) {
        Map<Month, Integer> daysInMonth = new HashMap<>();
        daysInMonth.put(Month.January, 31);
        if (isLeapYear(year))
            daysInMonth.put(Month.February, 29);
        else
            daysInMonth.put(Month.February, 28);
        daysInMonth.put(Month.February, 28);
        daysInMonth.put(Month.March, 31);
        daysInMonth.put(Month.April, 30);
        daysInMonth.put(Month.May, 31);
        daysInMonth.put(Month.June, 30);
        daysInMonth.put(Month.July, 31);
        daysInMonth.put(Month.August, 31);
        daysInMonth.put(Month.September, 30);
        daysInMonth.put(Month.October, 31);
        daysInMonth.put(Month.November, 30);
        daysInMonth.put(Month.December, 31);
        return daysInMonth;
    }

    private boolean isLeapYear(int year) {
        boolean leap;
        if (year % 4 == 0) {
            // if the year is century
            if (year % 100 == 0) {
                // if year is divided by 400
                // then it is a leap year
                leap = year % 400 == 0;
            }
            // if the year is not century
            else
                leap = true;
        } else
            leap = false;
        return leap;
    }
}