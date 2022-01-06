package example;

import org.joda.time.DateMidnight;
import org.joda.time.Days;
import java.time.temporal.ChronoUnit;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class LocalDatePeriod {

    private static LocalDate localDate = LocalDate.now();

    static double calculatePeriod(LocalDate createDateAndLocalDateNow,
                               LocalDate createDateAndExpiryDate) {
        double createDateAndLocalDateNowCount = ChronoUnit.DAYS.between(createDateAndLocalDateNow, localDate);
        double createDateAndExpiryDateCount = ChronoUnit.DAYS.between(createDateAndLocalDateNow, createDateAndExpiryDate);
        double rsl = ((createDateAndLocalDateNowCount / createDateAndExpiryDateCount) * 100) - 100;
        System.out.println("Period between start and end "
                + "date is : " + createDateAndLocalDateNowCount);
        System.out.println("Period between start and end "
                + "date is : " + createDateAndExpiryDateCount);
        System.out.println("Goods expired by"
                + " : " + rsl);
        return rsl;
    }

    public static void main(String[] args) {
        LocalDate expiryDateCount = LocalDate.parse("2015-12-01");
        LocalDate createDateCount = LocalDate.parse("2021-12-31");

        calculatePeriod(expiryDateCount, createDateCount);
    }
}
