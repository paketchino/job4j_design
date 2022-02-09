package ru.job4j.ood.lsd.storage;

import ru.job4j.ood.lsd.product.Food;

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

    @Override
    public List<Food> getFood() {
        return trashList;
    }

    /*
    Возвращают размер листа для проверки
    что продукт был добавлен
     */

    @Override
    public int getSize() {
        return trashList.size();
    }

}
