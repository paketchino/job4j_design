package ru.job4j.ood.isp;

public class OutPrint implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        menu.forEach(OutPrint::append);
    }

    private static void append(Menu.MenuItemInfo menuItemInfo) {
        String append = menuItemInfo.getName().concat(" ").concat(menuItemInfo.getNumber());
        System.out.println(append);
    }
}
