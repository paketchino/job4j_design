package ru.job4j.ood.tictactoe.matrix;

public interface Matrix {

    /**
     * Будет двухмерный массив по которому
     * мы будем проходить и искать верное условие
     * Пример: ищем совпадение по вертекали на
     * соотвествие трех одинаковых символов
     * @param matrix массив
     * @return массив из трех подряд совпадений
     */
    int[] matrixStorage(int[][] matrix);

    /**
     * Проверяет условия валидности
     * @return true || false
     */
    boolean checkRightCondition();
}
