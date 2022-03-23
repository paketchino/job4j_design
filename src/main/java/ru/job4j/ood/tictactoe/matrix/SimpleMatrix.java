package ru.job4j.ood.tictactoe.matrix;

public class SimpleMatrix implements Matrix {

    @Override
    public int[] matrixStorage(int[][] matrix) {
        return new int[0];
    }

    @Override
    public boolean checkRightCondition() {
        return false;
    }
}
