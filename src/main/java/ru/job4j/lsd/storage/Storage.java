package ru.job4j.lsd.storage;

import ru.job4j.collection.List;
import ru.job4j.lsd.product.Food;

public interface Storage {

    boolean addFood(Food food);

    boolean accept(Food food);

    int expiryDateCalculation(Food food);
}
