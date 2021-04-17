package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Event implements Iterator<Integer> {
    private final int[] number;
    private int count = 0;

    public Event(int[] number) {
        this.number = number;
    }

    @Override
    public boolean hasNext() {
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        for (int i = 0; i < number.length; i++) {
            if (number[i] % 2 == 0) {
                 return number[number[i]];
            }
        }
        return number[count];
    }
}
