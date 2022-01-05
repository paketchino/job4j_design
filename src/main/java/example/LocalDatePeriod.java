package example;

import java.time.LocalDate;
import java.time.Period;


public class LocalDatePeriod {

    static int calculatePeriod(LocalDate startDate,
                                           LocalDate endDate) {
        int rsl = 0;
        Period expiryDate = Period.between(startDate, endDate);
        Period createDate = Period.between(startDate, endDate);
        rsl = (int) (expiryDate.getMonths() / createDate.getMonths() * 1.0) / 100;
        System.out.println("Period between start and end "
                + "date is : " + rsl);
        return rsl;
    }

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.parse("2017-02-13");
        LocalDate endDate = LocalDate.parse("2018-08-20");

        calculatePeriod(startDate, endDate);
    }
}
