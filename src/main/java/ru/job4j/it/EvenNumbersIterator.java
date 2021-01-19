package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    private final int[] ints;
    private int index = 0;

    public EvenNumbersIterator(int[] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        for (; index < ints.length; index++) {
            if (ints[index] % 2 == 0) {
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
        return ints[index++];
    }
}
