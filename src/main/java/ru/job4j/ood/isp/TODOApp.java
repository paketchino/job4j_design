package ru.job4j.ood.isp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class TODOApp {

    public static final ActionDelegate STUB_ACTION = System.out::println;
    private final static String EXIT = "EXIT";
    private final static String ADD = "ADD";
    private final static String OUT = "OUT";
    private final static String SELECT = "SELECT";

    public static void main(String[] args) throws IOException {
        SimpleMenu simpleMenu = new SimpleMenu();
        System.out.println("ADD");
        System.out.println("SELECT");
        System.out.println("OUT");
        System.out.println("EXIT");
        Scanner scanner = new Scanner(System.in);
        String select = scanner.next();
        while (!select.equals(EXIT)) {
            switch (select) {
                case ADD -> {
                    System.out.println("Enter name parent");
                    String parent = scanner.next();
                    System.out.println("Enter child name");
                    String child = scanner.next();
                    if (simpleMenu.add(parent, child, STUB_ACTION)) {
                        System.out.println("Succesful");
                    } else {
                        System.out.println("Unsuccsesful");
                    };
                } case SELECT -> {
                    System.out.println("Enter child name");
                    String childSelect = scanner.next();
                    System.out.println(simpleMenu.select(childSelect));
                } case OUT -> {
                    System.out.println("Output All");
                    System.out.println(System.lineSeparator());
                    OutPrint outPrint = new OutPrint();
                    outPrint.print(simpleMenu);
                }
            }
            select = scanner.next();
        }
    }
}
