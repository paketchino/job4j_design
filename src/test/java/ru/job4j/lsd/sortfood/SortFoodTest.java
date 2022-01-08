package ru.job4j.lsd.sortfood;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.lsd.product.Apple;
import ru.job4j.lsd.product.Food;
import ru.job4j.lsd.product.Milk;
import ru.job4j.lsd.storage.Shop;
import ru.job4j.lsd.storage.Storage;
import ru.job4j.lsd.storage.Trash;
import ru.job4j.lsd.storage.Warehouse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

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

    @Test
    public void whenFreshFoodTo25ThenNeedMoveInWarehouse() {
        List<Storage> storages = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        storages.add(warehouse);
        Food apple = new Apple("Apple", LocalDate.of(2022, 12, 31),
                LocalDate.of(2022, 1, 1), 100, 30);
        ControlQuality controlQuality = new ControlQuality(storages);
        controlQuality.sortFood(apple);
        assertThat(warehouse.getSize(), is(1));
    }

    @Test
    public void whenNotFreshFoodThenPutOfDiscount() {
        List<Storage> storages = new ArrayList<>();
        Shop shop = new Shop();
        storages.add(shop);
        Food apple = new Apple("Apple", LocalDate.of(2022, 1, 10),
                LocalDate.of(2022, 1, 1), 100, 30);
        ControlQuality controlQuality = new ControlQuality(storages);
        controlQuality.sortFood(apple);
        assertThat(apple.getPrice(), is(70.0));
        assertThat(shop.getSize(), is(1));
    }

    @Test
    public void whenNotFreshFoodInLastYearThenMoveInTrash() {
        List<Storage> storages = new ArrayList<>();
        Trash trash = new Trash();
        storages.add(trash);
        LocalDate expiryDate = LocalDate.parse("2021-11-30");
        LocalDate createDate = LocalDate.parse("2021-01-01");
        Food milk = new Milk("Milk", expiryDate, createDate, 80, 20);
        ControlQuality controlQuality = new ControlQuality(storages);
        controlQuality.sortFood(milk);
        assertThat(trash.getSize(), is(1));
    }

    @Test
    public void whenNotFreshFoodThenMoveInTrash() {
        List<Storage> storages = new ArrayList<>();
        Trash trash = new Trash();
        storages.add(trash);
        LocalDate expiryDate = LocalDate.parse("2022-01-06");
        LocalDate createDate = LocalDate.parse("2022-01-01");
        Food milk = new Milk("Milk", expiryDate, createDate, 80, 20);
        ControlQuality controlQuality = new ControlQuality(storages);
        controlQuality.sortFood(milk);
        assertThat(trash.getSize(), is(1));
    }

    @Test
    public void whenFreshFoodThenMoveInWarehouse() {
        List<Storage> storages = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        storages.add(warehouse);
        LocalDate expiryDate = LocalDate.parse("2022-12-31");
        LocalDate createDate = LocalDate.parse("2022-01-01");
        Food milk = new Milk("Milk", expiryDate, createDate, 80, 20);
        ControlQuality controlQuality = new ControlQuality(storages);
        controlQuality.sortFood(milk);
        assertThat(warehouse.getSize(), is(1));
    }

    @Test
    public void whenMoveFreshFoodInTrash() {
        List<Storage> storages = new ArrayList<>();
        Trash trash = new Trash();
        storages.add(trash);
        LocalDate expiryDate = LocalDate.parse("2022-01-31");
        LocalDate createDate = LocalDate.parse("2021-12-01");
        Food milk = new Milk("Milk", expiryDate, createDate, 80, 20);
        ControlQuality controlQuality = new ControlQuality(storages);
        controlQuality.sortFood(milk);
        assertThat(trash.getSize(), is(0));
    }

    @Test
    public void whenNotFreshFoodInShop() {
        List<Storage> storages = new ArrayList<>();
        Shop shop = new Shop();
        storages.add(shop);
        LocalDate expiryDate = LocalDate.parse("2022-01-06");
        LocalDate createDate = LocalDate.parse("2022-01-01");
        Food milk = new Milk("Milk", expiryDate, createDate, 80, 20);
        ControlQuality controlQuality = new ControlQuality(storages);
        controlQuality.sortFood(milk);
        assertThat(shop.getSize(), is(0));
    }

    @Test
    public void whenMoveFoodPutOfDiscountInWarehouse() {
        List<Storage> storages = new ArrayList<>();
        Warehouse warehouse = new Warehouse();
        storages.add(warehouse);
        Food apple = new Apple("Apple", LocalDate.of(2022, 1, 10),
                LocalDate.of(2022, 1, 1), 100, 30);
        ControlQuality controlQuality = new ControlQuality(storages);
        controlQuality.sortFood(apple);
        assertThat(warehouse.getSize(), is(0));
    }
}