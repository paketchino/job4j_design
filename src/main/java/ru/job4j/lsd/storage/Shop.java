package ru.job4j.lsd.storage;

import ru.job4j.lsd.product.Food;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {

    private List<Food> shopList = new ArrayList<>();

    /*
    Метод который проверяет был ли
    добавлен обьек в shopList
    return true || false
     */

    @Override
    public boolean addFood(Food food) {
        boolean rsl = false;
        if (accept(food)) {
            shopList.add(food);
            rsl = true;
        }
        return rsl;
    }

    /*
      Метод который провереряет прошел ли срок
      хранения у продуктов по условию expiryDateCalculation(food) > 75.0
      и изменяет цену с учетом скидки PriceAfterDiscount
      || expiryDateCalculation(food) > 25.0 && expiryDateCalculation(food) < 75.0
      return true || false
     */

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        if (expiryDateCalculation(food) > 75.0) {
            food.setPriceAfterDiscount();
            rsl = true;
        } else if (expiryDateCalculation(food) > 25.0 && expiryDateCalculation(food) < 75.0) {
            rsl = true;
        }
        return rsl;
    }
}
