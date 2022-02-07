package ru.job4j.ood.lsd;

import java.time.LocalDate;
import java.time.Month;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Рассмотрим пример. Бухгалтерия считает по табелю сколько работник отработал
и если он отработал норму, то высчитывает для него зарплату. Далее мы наследуемся допустим для бухгалтерии магазина. В нем мы забываем про условие когда добавляем специфическое поведение
и когда запускаем пример, то получаем, что недобросовестный работник получает зарплату.
 */

public class WorkDays implements Iterable<Integer> {

    private Map<LocalDate, Integer> workDays = new LinkedHashMap<>();

    public void add(LocalDate date, int hours) {
        workDays.put(date, hours);
    }

    @Override
    public Iterator<Integer> iterator() {
        return workDays.values().iterator();
    }
}

class CountingRoom  {

    protected int normHours;

    protected int payPerHour;

    public CountingRoom(int normHours, int payPerHour) {
        this.normHours = normHours;
        this.payPerHour = payPerHour;
    }

    public int pay(WorkDays workDays) {
        int factHours = 0;
        for (Integer hoursPerDay : workDays) {
            factHours += hoursPerDay;
        }
        if (factHours < normHours) {
            throw new IllegalArgumentException("Worker didn't work enough!");
        }
        return factHours * payPerHour;
    }
}


/*
    Далее мы наследуемся допустим для бухгалтерии магазина. В нем мы забываем про условие когда добавляем специфическое поведение.
 */
class ShopCountingRoom extends CountingRoom {

    public ShopCountingRoom(int normHours, int payPerHour) {
        super(normHours, payPerHour);
    }

    @Override
    public int pay(WorkDays workDays) {
        int factHours = 0;
        for (Integer hoursPerDay : workDays) {
            factHours += hoursPerDay;
        }
        return factHours * payPerHour;
    }
}

/*
    Когда запускаем пример, то получаем, что недобросовестный работник получает зарплату.
 */

    class SecondRule {
    public static void main(String[] args) {

        WorkDays workDays = new WorkDays();
        workDays.add(LocalDate.of(2020, Month.DECEMBER, 1), 8);
        workDays.add(LocalDate.of(2020, Month.DECEMBER, 2), 6);
        workDays.add(LocalDate.of(2020, Month.DECEMBER, 3), 7);

        CountingRoom countingRoom = new ShopCountingRoom(3 * 8, 500);
        System.out.println(countingRoom.pay(workDays));
    }
}
