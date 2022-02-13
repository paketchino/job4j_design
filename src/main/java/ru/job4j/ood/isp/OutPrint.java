package ru.job4j.ood.isp;

public class OutPrint implements MenuPrinter {

    public static final ActionDelegate STUB_ACTION = System.out::println;
    public static final int DETENTION = 2;

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo menuItemInfo : menu) {
            String number = menuItemInfo.getNumber();
            System.out.println(getNumberCheck(number)
                    + menuItemInfo.getName()
                    + " " + menuItemInfo.getNumber()
                    + System.lineSeparator());
        }
    }

    private String getNumberCheck(String number) {
        int count = number == null ? 0 : number.split("\\.").length;
        return count < DETENTION ? "" : "----".repeat(count - 1).concat("");
    }

    public static void main(String[] args) {
        SimpleMenu simpleMenu = new SimpleMenu();
        simpleMenu.add(Menu.ROOT, "Задача", STUB_ACTION);
        simpleMenu.add("Задача", " Задача", STUB_ACTION);
        simpleMenu.add(" Задача", " Задача", STUB_ACTION);
        simpleMenu.add(" Задача", " Задача", STUB_ACTION);
        simpleMenu.add("Задача", " Задача", STUB_ACTION);
        OutPrint outPrint = new OutPrint();
        outPrint.print(simpleMenu);
    }
}
