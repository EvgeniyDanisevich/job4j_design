package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleDynamicArray<E> container = new SimpleDynamicArray<>();
    private int capacity = 0;

    private boolean isPresent(E e) {
        for (E el : container) {
            if (Objects.equals(el, e)) {
                return true;
            }
        }
        return false;
    }

    private int getIndex(E e) {
        int index = 0;
        for (E el : container) {
            if (Objects.equals(el, e)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public void add(E e) {
        if (!isPresent(e)) {
            container.add(e);
            capacity++;
        }
    }

    public void remove(E e) {
        int index = getIndex(e);
        if (index >= 0) {
            container.remove(index);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return container.iterator();
    }
}
