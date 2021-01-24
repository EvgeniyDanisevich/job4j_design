package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int indexIn = 0;
    private int indexOut = 0;

    public T poll() {
        for (int i = 0; i < indexIn; i++) {
            pushOut(in.pop());
        }
        T t = out.pop();
        indexOut--;
        indexIn = 0;
        for (int i = 0; i < indexOut; i++) {
            push(out.pop());
        }
        indexOut = 0;
        return t;
    }

    public void push(T value) {
        in.push(value);
        indexIn++;
    }

    private void pushOut(T value) {
        out.push(value);
        indexOut++;
    }
}