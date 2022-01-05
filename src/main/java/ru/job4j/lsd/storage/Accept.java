package ru.job4j.lsd.storage;

import ru.job4j.lsd.product.Food;

public interface Accept {

    boolean accept(Food food);
}
