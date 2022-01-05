package ru.job4j.lsd.storage;

import ru.job4j.lsd.product.Food;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Trash implements Storage, Accept {

    private List<Food> trashList = new ArrayList<>();

    private LocalDate today = LocalDate.now();

    @Override
    public boolean addFood(Food food) {
        boolean rsl = false;
       if (accept(food)) {
           trashList.add(food);
           rsl = true;
       }
       return rsl;
    }

    @Override
    public boolean accept(Food food) {
        return expiryDateCalculation(food) < 25;
    }

    @Override
    public int expiryDateCalculation(Food food) {
        int countExpiryDate = Period.between(food.getExpiryDate(), today).getDays();
        int countCreateDate = Period.between(food.getCreateDate(), today).getDays();
        return (int) ((countExpiryDate / countCreateDate * 1.0) / 100.0);
    }
}
