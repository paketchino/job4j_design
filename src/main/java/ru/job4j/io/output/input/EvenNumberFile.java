package ru.job4j.io.output.input;

import java.io.FileInputStream;
import java.util.Arrays;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("even.txt")) {
            StringBuilder text = new StringBuilder();
            int num;
            while ((num = in.read()) != -1) {
                text.append((char)num);
            }
            String []lines = text.toString().split(System.lineSeparator());
            for (String line : lines ) {
                int numbers = Integer.parseInt(line);
                if (numbers % 2 == 0) {
                    System.out.println(numbers);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
