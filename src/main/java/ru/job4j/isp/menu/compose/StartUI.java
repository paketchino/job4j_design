package ru.job4j.isp.menu.compose;

import ru.job4j.isp.menu.Action;
import ru.job4j.isp.menu.MultiLV;
import ru.job4j.isp.menu.SingleLV;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class StartUI {

    public void init(List<ActionItem> itemList) {
        MultiLV startMenu = new MultiLV("Задача 1.");
        MultiLV subMenu = new MultiLV("---- Задача 1.1.");
        MultiLV finishMenu = new MultiLV("--------- Задача 1.1.2.");
        SingleLV singleLV = new SingleLV("Задача 2");
        startMenu.add(subMenu);
        startMenu.add(finishMenu);
        itemList.add(startMenu);
        itemList.add(singleLV);
    }

    public void output(List<ActionItem> itemList) {
        Scanner scanner = new Scanner(System.in);
        boolean rsl = true;
        while (rsl) {
            ListIterator<ActionItem> listIterator = itemList.listIterator();
            while (listIterator.hasNext()) {
                ActionItem actionItem = listIterator.next();
                if (actionItem.getList().size() > 0) {
                    itemList.addAll(itemList.indexOf(actionItem) + 1, actionItem.getList());
                    listIterator = itemList.listIterator();
                    listIterator.next();
                }
                System.out.println("Select : ");
                int select = scanner.nextInt();
                System.out.println(actionItem.getName());
                if (select == (4)) {
                    rsl = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<ActionItem> list = new ArrayList<>();
        StartUI startUI = new StartUI();
        startUI.init(list);
        startUI.output(list);
    }
}
