package ru.job4j.ood.lsd.sortfood;

import ru.job4j.ood.lsd.product.Apple;
import ru.job4j.ood.lsd.product.Food;
import ru.job4j.ood.lsd.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality implements ResortFood {

    private List<Storage> storage;
    private FoodList foodList;

    public ControlQuality(List<Storage> storage, FoodList foodList) {
        this.storage = storage;
        this.foodList = foodList;
    }

    /*
     Метод который сортирует еду
     */

    public void sortFood(List<Food> foodList) {
        for (Food food : foodList) {
            for (Storage storage : storage) {
                if (storage.accept(food)) {
                    storage.addFood(food);
                }
            }
        }
    }

    @Override
    public void resort() {
        for (Storage storage1 : storage) {
            foodList.getFoodList().addAll(storage1.getFood());
        }
        storage.clear();
    }
}
