package ru.job4j.ood.isp;

import java.util.Scanner;

public class ConsoleInput implements Input {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String string) {
        return scanner.nextLine();
    }
}
