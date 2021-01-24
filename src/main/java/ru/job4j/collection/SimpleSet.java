package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleDynamicArray<E> container = new SimpleDynamicArray<>();
    private int capacity = 0;
    private int modCount = 0;

    public void add(E e) {
        for (E el : container) {
            if (el.equals(e)) {
                return;
            }
        }
        container.add(e);
        modCount++;
        capacity++;
    }

    public void remove(E e) {
        int index = 0;
        for (E el : container) {
            if (el.equals(e)) {
                container.remove(index);
                modCount++;
                break;
            }
            index++;
        }
        capacity--;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int iterationValue = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iterationValue < capacity;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container.get(iterationValue++);
            }
        };
    }
}
