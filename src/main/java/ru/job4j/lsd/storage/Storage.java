package ru.job4j.lsd.storage;

import ru.job4j.lsd.product.Food;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public interface Storage {

    boolean addFood(Food food);

    boolean accept(Food food);

    /*
    Метод проверяет срок годности продукта
    если макс. срок хренения не соотвествует
    LocalDate.now(), то return 0
     */

    default double expiryDateCalculation(Food food) {
        LocalDate localDateNow = LocalDate.now();
        if (food.getExpiryDate().getYear() < localDateNow.getYear()) {
            return 0;
        }
        double countCreateDate = ChronoUnit.DAYS.between(food.getCreateDate(), localDateNow);
        double countExpireDate = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        return ((countExpireDate / countCreateDate) * 100.0) - 100.0;
    };
}
