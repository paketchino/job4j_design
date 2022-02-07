package ru.job4j.ood.lsd.sortfood;

import ru.job4j.ood.lsd.product.Food;
import ru.job4j.ood.lsd.storage.Storage;

import java.util.List;

public class ControlQuality {

    private List<Storage> storage;

    public ControlQuality(List<Storage> storage) {
        this.storage = storage;
    }

    /*
     Метод который сортирует еду
     */

    public void sortFood(Food food) {
        for (Storage storage : storage) {
            storage.addFood(food);
        }
    }
}
