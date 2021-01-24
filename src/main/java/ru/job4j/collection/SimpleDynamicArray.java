package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleDynamicArray<T> implements Iterable<T> {
    private Object[] container;
    private int capacity = 0;
    private int modCount = 0;

    public SimpleDynamicArray() {
        container = new Object[10];
    }

    public SimpleDynamicArray(int cells) {
        container = new Object[cells];
    }

    public void add(T model) {
        if (capacity >= container.length) {
            Object[] increasedContainer = new Object[container.length + 10];
            System.arraycopy(container, 0, increasedContainer, 0, container.length);
            container = increasedContainer;
        }
        container[capacity++] = model;
        modCount++;
    }

    public boolean set(int index, T model) {
        container[Objects.checkIndex(index, capacity)] = model;
        modCount++;
        return true;
    }

    public boolean remove(int index) {
        container[Objects.checkIndex(index, capacity)] = null;
        System.arraycopy(container, index + 1, container, index, container.length - 1 - index);
        container[container.length - 1] = null;
        capacity--;
        modCount++;
        return true;
    }

    public T get(int index) {
        return (T) container[Objects.checkIndex(index, capacity)];
    }

    @Override
    public Iterator<T> iterator() {
        class SimpleDynamicArrayIterator implements Iterator<T> {
            private int iterationValue = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iterationValue < capacity;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (T) container[iterationValue++];
            }
        }

        return new SimpleDynamicArrayIterator();
    }
}