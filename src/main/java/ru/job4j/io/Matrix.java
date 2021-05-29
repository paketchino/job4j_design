package ru.job4j.io;

import java.io.FileOutputStream;

public class Matrix {
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        return table;
    }
}


class Result {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            int[][] table = Matrix.multiple(9);
            for (int i = 0; i < table.length; i++) {
                for (int j = 0; j < table.length; j++) {
                    out.write(table[i][j]);
                }
                out.write("\n".getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
