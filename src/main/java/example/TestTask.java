package example;

import java.util.Arrays;
import java.util.stream.Stream;

public class TestTask {

    public void sorted() {
        int[] storage;
        storage = new int[3];
        for (int i = 0; i < storage.length; i++) {
            int pos = i;
            storage[i] = (int) (Math.random() * storage.length);
            System.out.println(storage[i]);
            if (storage[1] < storage[0]) {

            }
//            int min = storage[i];
//            for (int j = i + 1; j < storage.length; j++) {
//                pos = j;
//                min = storage[j];
//            }
//            storage[pos] = storage[i];
//            System.out.println(storage[i] = min);
        }
    }


    public static void main(String[] args) {
        TestTask testTask = new TestTask();
        testTask.sorted();
    }
}
