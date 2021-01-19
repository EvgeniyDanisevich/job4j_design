package ru.job4j.generics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {
    private int capacity = 0;
    private T[] array;

    public SimpleArray(int cells) {
        array = (T[]) new Object[cells];
    }

    public Object getArray() {
        return array;
    }

    public boolean checkIndex(int index) {
        return index < capacity;
    }

    public boolean add(T model) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = model;
                capacity++;
                return true;
            }
        }
        return false;
    }

    public boolean set(int index, T model) {
        if (checkIndex(index)) {
            array[index] = model;
            return true;
        }
        return false;
    }

    public boolean remove(int index) {
        if (checkIndex(index)) {
            array[index] = null;
            System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
            return true;
        }
        return false;
    }

    public T get(int index) {
        if (!checkIndex(index)) {
            throw new NoSuchElementException();
        }
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return Arrays.asList(array).iterator();
    }
}
