package ru.job4j.ood.lsd.storage;

import ru.job4j.ood.lsd.product.Food;
import ru.job4j.ood.lsd.sortfood.FoodList;
import ru.job4j.ood.lsd.sortfood.SimpleFoodList;

import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
import java.util.List;

public interface Storage {

    boolean addFood(Food food);

    boolean accept(Food food);

    List<Food> getFood();

    void clearList();

    /*
    Метод проверяет срок годности продукта
    если макс. срок хранения не соотвествует текущему
    году, то return 100
     */

    default double expiryDateCalculation(Food food) {
        double rsl = 0;
        LocalDate localDateNow = LocalDate.now();
        if (food.getExpiryDate().getYear() < localDateNow.getYear()) {
            return 100;
        }
        double countCreateDate = ChronoUnit.DAYS.between(food.getCreateDate(), localDateNow);
        double countExpireDate = ChronoUnit.DAYS.between(food.getCreateDate(), food.getExpiryDate());
        rsl = (countCreateDate / countExpireDate) * 100.0;
        return rsl;
    };

    int getSize();
}
