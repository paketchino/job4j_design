package example;

import java.util.Scanner;

public class Elevator {

    private static final String BUTTON = "button";

    private static final String OUT = "out";

    public static void run() {
        int result = 0;
        int number = 0;
        int elevator3 = 1;
        int elevator1 = 1;
        int elevator2 = 1;
        int currPostElev1 = 0;
        int currPostElev2 = 0;
        int currPostElev3 = 0;
        Scanner sc = new Scanner(System.in);
        String button = sc.next();
        while (!button.equals(OUT)) {
            if (button.equals(BUTTON)) {
                System.out.println("Ввведите этаж на котором вы находитесь : ");
                int currentFlor = sc.nextInt();
                if (currentFlor > 9) {
                    System.out.println("Неправильно введеное значение");
                    continue;
                }
                System.out.println("Введите этаж на который Вам нужно доехать : ");
                int finishFlor = sc.nextInt();
                if (finishFlor > 9) {
                    System.out.println("Неправильно введеное значение");
                    continue;
                }
                int conditionOne = Math.abs(elevator3 - currentFlor);
                int conditionTwo = Math.abs(elevator2 - currentFlor);
                if (currentFlor == elevator1) {
                    System.out.println("Вызывается первый лифт");
                    result = finishFlor;
                    System.out.println("Мы прибыли на " + result +  " этаж");
                } else if ((conditionOne == conditionTwo) ||
                        (conditionTwo < conditionOne)) {
                    System.out.println("Вызывается второй лифт");
                    result = finishFlor;
                    System.out.println("Мы прибыли на " + result +  " этаж");
                    elevator2 = currentFlor;
                    currentFlor = finishFlor;
                    finishFlor = currPostElev2;
                    } else {
                        System.out.println("Вызывается третий лифт");
                        result = finishFlor;
                        System.out.println("Мы прибыли на " + result +  " этаж");
                        elevator3 = currentFlor;
                        currentFlor = finishFlor;
                        finishFlor = currPostElev3;
                }
            }
            button = sc.next();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
