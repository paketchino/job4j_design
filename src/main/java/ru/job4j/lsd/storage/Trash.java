package ru.job4j.lsd.storage;

import ru.job4j.lsd.product.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements AddProductInTheStorage {

    private final List<Food> trashStorage;

    public Trash(List<Food> trashStorage) {
        this.trashStorage = trashStorage;
    }

    @Override
    public void addFood(Food food) {
        trashStorage.add(food);
    }
}
