package example;

import java.util.Arrays;

public class SequenceNumber {

    public int[] method(int[] oldEl) {
        int[] resultArray = new int[1];
        int count = 0;
        for (int i = 0; i < oldEl.length; i++) {
            for (int j = 0; j < oldEl.length; j++) {
                if (oldEl[i] == oldEl[j]) {
                    count++;
                    if (count >= 3) {
                        resultArray[0] = oldEl[i];
                        count = 0;
                    }
                }
            }
        }
        return resultArray;
    }

    public static void main(String[] args) {
        String name = "dajkslda";
        System.out.println(name);
        System.out.println();
        Object s =  " dada";
        int v = 2;
        String a = "5" + 2;

    }
}
