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
        boolean rsl = true;
        SimpleMenu simpleMenu = new SimpleMenu();
        System.out.println("1. Add");
        System.out.println("2. Select");
        System.out.println("3. Out");
        System.out.println("4. Exit");
        Scanner scanner = new Scanner(System.in);
        String select = scanner.next();
        while (!select.equals(EXIT)) {
            if (select.equals(ADD)) {
                System.out.println("Enter name parent");
                String parent = scanner.next();
                System.out.println("Enter child name");
                String child = scanner.next();
                simpleMenu.add(parent, child, STUB_ACTION);
            } else if (select.equals(SELECT)) {
                System.out.println("Enter child name");
                String child = scanner.next();
                System.out.println(simpleMenu.select(child));
            } else if (select.equals(OUT)) {
                System.out.println("Output All");
                OutPrint outPrint = new OutPrint();
                outPrint.print(simpleMenu);
            }
        }
    }
}
