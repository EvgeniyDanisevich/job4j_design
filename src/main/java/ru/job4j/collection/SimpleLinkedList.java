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
        private int nodeIndex;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void addFirst(E value) {
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
        node.nodeIndex = index;
        modCount++;
        size++;
        index++;
    }

    public E getFirst(int index) {
        Objects.checkIndex(index, size);
        if (first.nodeIndex == index) {
            return first.item;
        }
        return null;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) {
            return getFirst(index);
        }
        Node<E> n = first;
        for (int i = 0; i < index; i++) {
            n = n.next;
            if (n.nodeIndex == index) {
                return n.item;
            }
            get(n.nodeIndex);
        }
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        class SimpleLinkedListIterator implements Iterator<E> {
            private int iterationValue = 0;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iterationValue < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return get(iterationValue++);
            }
        }

        return new SimpleLinkedListIterator();
    }
}
