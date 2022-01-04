package ru.job4j.lsd.sortfood;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.lsd.product.Apple;
import ru.job4j.lsd.product.Food;
import ru.job4j.lsd.product.Milk;
import ru.job4j.lsd.product.Oil;
import ru.job4j.lsd.storage.Trash;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class SortFoodTest {

    @Test
    public void whenNeedToCreateAndBuyFoodAfterDiscount() {
        LocalDate expiryDateApple = LocalDate.of(2022, 12, 31);
        LocalDate createDateApple = LocalDate.of(2022, 1, 1);
        Food apple = new Apple("Apple", expiryDateApple, createDateApple, 100, 30);
        apple.setPriceAfterDiscount();
        LocalDate expiryDateMilk = LocalDate.of(2022, 3, 30);
        LocalDate createDateMilk = LocalDate.of(2021, 12, 25);
        Food milk = new Milk("Milk", expiryDateMilk, createDateMilk, 130, 10);
        milk.setPriceAfterDiscount();
        assertThat(apple.getPrice(), is(70.0));
        assertThat(milk.getPrice(), is(117.0));
    }

    @Ignore
    @Test
    public void whenNeedToMoveFoodInTrash() {
        LocalDate expiryDateOil = LocalDate.of(2021, 11, 30);
        LocalDate createDateOil = LocalDate.of(2021, 9, 29);
        Food oil = new Oil("Oil", expiryDateOil, createDateOil, 100, 5);
        List<Food> trashStorage = new ArrayList<>();
        Trash trash = new Trash(trashStorage);
        SortFood sortFood = new SortFood(trash);
        sortFood.sortFood(oil);
        assertTrue(sortFood.sortFood(oil));
    }
}