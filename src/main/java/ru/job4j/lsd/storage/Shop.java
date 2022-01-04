package ru.job4j.lsd.storage;

import ru.job4j.lsd.product.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements AddProductInTheStorage {

    private final List<Food> shopStorage;

    public Shop(List<Food> shopStorage) {
        this.shopStorage = shopStorage;
    }

    @Override
    public void addFood(Food food) {
        shopStorage.add(food);
    }
}
