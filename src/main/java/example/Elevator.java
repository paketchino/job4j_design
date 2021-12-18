package example;

import java.util.Scanner;

public class Elevator {

    private static final String BUTTON = "button";

    private static final String OUT = "out";

    public static void run() {
        int elevator3 = 1;
        int elevator1 = 1;
        int elevator2 = 1;
        int currPostElev2 = elevator2;
        int currPostElev3 = elevator3;
        int result = 0;
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
                int conditionThree = Math.abs(elevator3 - currentFlor);
                int conditionTwo = Math.abs(elevator2 - currentFlor);
                if (currentFlor == elevator1) {
                    System.out.println("Вызывается первый лифт");
                    result = finishFlor;
                    System.out.println("Мы прибыли на " + result +  " этаж");
                } else if (conditionThree == conditionTwo) {
                    System.out.println("Вызывается ближайший лифт");
                    result = finishFlor;
                    System.out.println("Мы прибыли на " + result +  " этаж");
                    elevator2 = finishFlor;
                    finishFlor = currPostElev2;
                    currPostElev2 = elevator2;
                } else if (conditionThree < conditionTwo && conditionThree < currentFlor) {
                    System.out.println("Вызывается третий лифт");
                    result = finishFlor;
                    System.out.println("Мы прибыли на " + result +  " этаж");
                    elevator3 = finishFlor;
                    finishFlor = currPostElev3;
                    currPostElev3 = elevator3;
                } else if (conditionTwo < conditionThree && conditionTwo < currentFlor) {
                    System.out.println("Вызывается втотрой лифт");
                    result = finishFlor;
                    System.out.println("Мы прибыли на " + result +  " этаж");
                    currentFlor = finishFlor;
                    finishFlor = elevator2;
                    elevator2 = currPostElev2;
                } else if (currentFlor == currPostElev2) {
                    System.out.println("Вызывается втотрой лифт");
                    result = finishFlor;
                    System.out.println("Мы прибыли на " + result +  " этаж");
                    currentFlor = finishFlor;
                    finishFlor = elevator2;
                    elevator2 = currPostElev2;
                } else if (currentFlor == currPostElev3) {
                    System.out.println("Вызывается третий лифт");
                    result = finishFlor;
                    System.out.println("Мы прибыли на " + result +  " этаж");
                    currentFlor = finishFlor;
                    finishFlor = elevator2;
                    elevator2 = currPostElev2;
                }
            }
            button = sc.next();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
