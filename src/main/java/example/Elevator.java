package example;

import java.util.Scanner;

public class Elevator {

    private static final String BUTTON = "button";

    private static final String OUT = "out";

    private static final int[] LEVEL = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void run() {
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
                System.out.println("Вызывается ближайший лифт");
                if (currentFlor == elevator1) {
                    System.out.println("Вызывается первый лифт");
                }
                if (currentFlor >= 2) {
                    if ((elevator3 - currentFlor) == (elevator2 - currentFlor)) {
                        System.out.println("Вызывается второй лифт");
                    }
                    if ((elevator2 - currentFlor) < (elevator3 - currentFlor)) {
                        System.out.println("Вызывается второй лифт");
                    }
                    if ((elevator3 - currentFlor) < (elevator2 - currentFlor)) {
                        System.out.println("Вызывается третий лифт");
                    }
                }
                if (currentFlor < finishFlor) {
                    for (int i = currentFlor; i < LEVEL[finishFlor - 1]; i++) {
                        number = LEVEL[currentFlor];
                        System.out.println("Мы находимся на " + number + " этаже");
                        currentFlor++;
                    }
                }
                if (finishFlor > currentFlor) {
                    for (int i = currentFlor; i > LEVEL[finishFlor - 1]; i--) {
                        number = LEVEL[finishFlor];
                        System.out.println("Мы находимся на " + number + " этаже");
                        currentFlor--;
                    }
                }
//                elevator2 = currentFlor;
//                currentFlor = finishFlor;
//                finishFlor = currPostElev2;
            }
            button = sc.next();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
