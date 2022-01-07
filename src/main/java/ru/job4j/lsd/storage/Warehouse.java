package ru.job4j.lsd.storage;

import ru.job4j.lsd.product.Food;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {

    private List<Food> warehouseList = new ArrayList<>();

    /*
     Метод который проверяет был ли
     добавлен обьект в warehouseList.
     return true || false
     */

    @Override
    public boolean addFood(Food food) {
        boolean rsl = false;
        if (accept(food)) {
            warehouseList.add(food);
            rsl = true;
        }
        return rsl;
    }

    /*
      Метод который проверяет прошел ли срок
      хранения у продуктов expiryDateCalculation(food) < 25.0
      return true || false
     */

    @Override
    public boolean accept(Food food) {
        boolean rsl = false;
        if (expiryDateCalculation(food) < 25) {
            rsl = true;
        }
        return rsl;
    }
}
