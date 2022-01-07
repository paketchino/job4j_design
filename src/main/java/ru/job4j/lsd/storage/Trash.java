package ru.job4j.lsd.storage;

import ru.job4j.lsd.product.Food;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage {

    private List<Food> trashList = new ArrayList<>();

    /*
    Метод который проверяет был ли
    добавлен обьект
    return true || false
     */

    @Override
    public boolean addFood(Food food) {
        boolean rsl = false;
        if (accept(food)) {
           trashList.add(food);
           rsl = true;
       }
       return rsl;
    }

    /*
      Метод который провереряет прошел ли срок
      хранения у продуктов
      return true || false
     */

    @Override
    public boolean accept(Food food) {
        return expiryDateCalculation(food) >= 100;
    }

}
