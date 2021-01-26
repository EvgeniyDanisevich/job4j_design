package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements Iterable<E> {
    private int size = 0;
    private int modCount = 0;
    private Node<E> first;
    private Node<E> last;
    private int index = 0;

    private static class Node<E> {
        private final E item;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private void addFirst(E value) {
        if (first == null) {
            first = new Node<>(null, value, null);
            modCount++;
            size++;
            index++;
        }
    }

    public void add(E value) {
        if (first == null) {
            addFirst(value);
            last = first;
            return;
        }
        Node<E> node = new Node<>(null, value, null);
        last.next = node;
        node.prev = last;
        last = node;
        modCount++;
        size++;
        index++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    @Override
    public Iterator<E> iterator() {
        class SimpleLinkedListIterator implements Iterator<E> {
            private final int expectedModCount = modCount;
            private Node<E> current = first;
            private Node<E> currentNext = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                current = currentNext;
                return current != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                currentNext = current.next;
                return current.item;
            }
        }

        return new SimpleLinkedListIterator();
    }
}
