package ru.job4j.ood.lsd.sortfood;

import ru.job4j.ood.lsd.product.Food;

import java.util.ArrayList;
import java.util.List;

public class SimpleFoodList implements FoodList {

    private List<Food> listFood = new ArrayList<>();

    @Override
    public List<Food> getFoodList() {
        return listFood;
    }
}
