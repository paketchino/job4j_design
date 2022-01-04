package ru.job4j.lsd.storage;

import ru.job4j.lsd.product.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements AddProductInTheStorage {

    private final List<Food> warehouseStorage;

    public Warehouse(List<Food> warehouseStorage) {
        this.warehouseStorage = warehouseStorage;
    }

    @Override
    public void addFood(Food food) {
        warehouseStorage.add(food);
    }
}
