package ru.job4j.lsd.sortfood;

import ru.job4j.lsd.product.Food;
import ru.job4j.lsd.storage.Shop;
import ru.job4j.lsd.storage.Trash;
import ru.job4j.lsd.storage.Warehouse;

import java.time.LocalDate;
import java.time.Period;

public class SortFood implements ControlQuality {

    private Shop shop;
    private Trash trash;
    private Warehouse warehouse;
    private LocalDate today = LocalDate.now();

    public SortFood(Shop shop, Trash trash, Warehouse warehouse) {
        this.shop = shop;
        this.trash = trash;
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "SortFood{" + "shop=" + shop
                + ", trash="
                + trash
                + ", warehouse="
                + warehouse
                + ", today="
                + today
                + '}';
    }

    public SortFood(Shop shop) {
        this.shop = shop;
    }

    public SortFood(Trash trash) {
        this.trash = trash;
    }

    public SortFood(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    private int expiryDateCalculation(Food food) {
        int countExpiryDate = Period.between(food.getExpiryDate(), today).getDays();
        int countCreateDate = Period.between(food.getCreateDate(), today).getDays();
        return (int) ((countExpiryDate / countCreateDate * 1.0) / 100.0);
    }


    @Override
    public boolean sortFood(Food food) {
        boolean rsl = false;
        if (expiryDateCalculation(food) < 25) {
            warehouse.addFood(food);
            rsl = true;
        } else if (expiryDateCalculation(food) >= 25 && expiryDateCalculation(food) <= 75) {
            shop.addFood(food);
            rsl = true;
        } else if (expiryDateCalculation(food) >= 75) {
            food.setPriceAfterDiscount();
            shop.addFood(food);
            rsl = true;
        } else {
            trash.addFood(food);
            rsl = true;
        }
        return rsl;
    }

}
