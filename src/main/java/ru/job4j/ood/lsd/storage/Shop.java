package ru.job4j.ood.lsd.storage;

import ru.job4j.ood.lsd.product.Food;

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
            if (expiryDateCalculation(food) > 75.0 && expiryDateCalculation(food) < 100) {
                food.setPriceAfterDiscount();
            }
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
        if (expiryDateCalculation(food) > 25.0 && expiryDateCalculation(food) < 100.0) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public List<Food> getFood() {
        return new ArrayList<>(shopList);
    }

    @Override
    public void clearList() {
        shopList.clear();
    }

    /*
   Возвращают размер листа для проверки
   что продукт был добавлен
    */

    @Override
    public int getSize() {
        return shopList.size();
    }
}
