package ru.job4j.lsd.sortfood;

import ru.job4j.lsd.product.Food;
import ru.job4j.lsd.storage.Shop;
import ru.job4j.lsd.storage.Storage;
import ru.job4j.lsd.storage.Trash;
import ru.job4j.lsd.storage.Warehouse;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Storage> storage;

    public ControlQuality(List<Storage> storage) {
        this.storage = storage;
    }

    public void sortFood(Food food) {
        for (Storage storage : storage) {
            if (storage.accept(food)) {
                storage.addFood(food);
            }
        }
    }
}
