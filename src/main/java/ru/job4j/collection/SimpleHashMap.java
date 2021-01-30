package ru.job4j.collection;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<SimpleHashMap.Node<K, V>> {
    private int count = 0;
    private int capacity = 16;
    private int modCount = 0;
    private Object[] table = new Object[capacity];

    static class Node<K, V> {
        private final int hash;
        private final K key;
        private final V value;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        @Override
        public String toString() {
            return "Node{"
                    + "key=" + key
                    + ", value=" + value
                    + '}';
        }
    }

    public int hash(Object key) {
        return (key == null) ? 0 : (key.hashCode() % capacity);
    }

    private Object[] increase(Object[] table) {
        capacity = capacity * 2;
        Object[] tableNew = new Object[capacity];
        for (Object object : table) {
            Node<K, V> temp = (Node<K, V>) object;
            if (temp != null) {
                tableNew[(tableNew.length - 1) & temp.hash] = temp;
            }
        }
        table = tableNew;
        modCount++;
        return table;
    }

    public boolean insert(K key, V value) {
        if ((float) (count / capacity) >= 0.75) {
            table = increase(table);
        }
        int index = (table.length - 1) & hash(key);
        if (table[index] == null) {
            table[index] = new Node<>(hash(key), key, value);
            count++;
            modCount++;
            return true;
        }
        return false;
    }

    public V get(K key) {
        Node<K, V> node = (Node<K, V>) table[(table.length - 1) & hash(key)];
        if (node.getKey().equals(key)) {
            return node.getValue();
        }
        return null;
    }

    public boolean delete(K key) {
        int index = (table.length - 1) & hash(key);
        Node<K, V> node = (Node<K, V>) table[index];
        if (node.getKey().equals(key)) {
            if (table[index] != null) {
                table[index] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Node<K, V>> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int iteratorValue = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (; iteratorValue < table.length; iteratorValue++) {
                    if (table[iteratorValue] != null) {
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Node<K, V> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (Node<K, V>) table[iteratorValue++];
            }
        };
    }
}
