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
        if (rsl()) {
            return true;
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (rsl()) {
            return number[count++];
        }
        return -1;
    }

    private boolean rsl() {
        for (int i = count; i < number.length; i++) {
            if (number[count] % 2 == 0) {
                count = i;
                return true;
            }
            count++;
        }
        return false;
    }
}
