package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private int capacity = 0;
    private T[] array;

    public SimpleArray(int cells) {
        array = (T[]) new Object[cells];
    }

    public boolean add(T model) {
        if (capacity < array.length) {
            array[capacity] = model;
            if (model != null) {
                capacity++;
            }
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
        class SimpleArrayIterator implements Iterator<T> {
            private int iterationValue = 0;

            @Override
            public boolean hasNext() {
                return iterationValue < capacity;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[iterationValue++];
            }
        }

        return new SimpleArrayIterator();
    }
}
