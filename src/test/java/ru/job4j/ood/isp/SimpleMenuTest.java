package ru.job4j.ood.isp;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleMenuTest {

    public static final ActionDelegate STUB_ACTION = System.out::println;

    @Test
    public void whenAddThenReturnSame() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream resultBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultBuffer));
        OutPrint outPrint = new OutPrint();

        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        outPrint.print(menu);
        assertEquals("Сходить в магазин 1."
                + System.lineSeparator() + System.lineSeparator() + "----Купить продукты 1.1."
                + System.lineSeparator() + System.lineSeparator() + "--------Купить хлеб 1.1.1."
                + System.lineSeparator() + System.lineSeparator() + "--------Купить молоко 1.1.2."
                + System.lineSeparator() + System.lineSeparator()
                + "Покормить собаку 2." + System.lineSeparator() + System.lineSeparator(),
                resultBuffer.toString());
        System.setOut(stdout);
    }

    @Test
    public void whenNeedToCheckSelect() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        assertEquals(
                menu.select("Покормить собаку").get().getName(),
                "Покормить собаку"
        );
    }

    @Test
    public void whenOutputThenCheckOutput() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream resultBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(resultBuffer));
        OutPrint outPrint = new OutPrint();

        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Задача", STUB_ACTION);
        menu.add("Задача", "--- Задача", STUB_ACTION);
        menu.add("--- Задача", "--------- Задача", STUB_ACTION);
        menu.add("--- Задача", "--------- Задача", STUB_ACTION);
        menu.add("Задача", "--- Задача", STUB_ACTION);
        outPrint.print(menu);
        assertEquals("Задача 1."
                + System.lineSeparator() + System.lineSeparator()
                + "------- Задача 1.1."
                + System.lineSeparator() + System.lineSeparator()
                + "----------------- Задача 1.1.1."
                + System.lineSeparator() + System.lineSeparator(), resultBuffer.toString());
        System.setOut(stdout);
    }

}