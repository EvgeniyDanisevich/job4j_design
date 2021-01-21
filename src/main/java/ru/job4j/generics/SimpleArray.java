package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private int capacity = 0;
    private T[] array;
    private int iterationValue = 0;

    public SimpleArray(int cells) {
        array = (T[]) new Object[cells];
    }

    public boolean add(T model) {
        if (capacity < array.length) {
            array[capacity++] = model;
            return true;
        }
        return false;
    }

    public boolean set(int index, T model) {
        array[Objects.checkIndex(index, capacity)] = model;
        return true;
    }

    public boolean remove(int index) {
        array[Objects.checkIndex(index, capacity)] = null;
        System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
        array[array.length - 1] = null;
        capacity--;
        return true;
    }

    public T get(int index) {
        return array[Objects.checkIndex(index, capacity)];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                if (iterationValue >= array.length) {
                    return false;
                }
                return array[iterationValue] != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[iterationValue++];
            }
        };
    }
}
