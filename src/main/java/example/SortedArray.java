package example;

import java.util.Arrays;
import java.util.Collections;

public class SortedArray {

    public void sort() {
        int[] resultArr = new int[25];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i] = (int) (Math.random() * 100);
        }
        System.out.println(Arrays.toString(resultArr));
        for (int i = 0; i < resultArr.length - 1; i++) {
            for (int j = 0; j < resultArr.length - i - 1; j++) {
                if (resultArr[j] > resultArr[j + 1]) {
                    int b = resultArr[j];
                    resultArr[j] = resultArr[j + 1];
                    resultArr[j + 1] = b;
                }
            }
        }
        System.out.println(Arrays.toString(resultArr));
        }

    public static void main(String[] args) {
        SortedArray array = new SortedArray();
        array.sort();
    }
}
