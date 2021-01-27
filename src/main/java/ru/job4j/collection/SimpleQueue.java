package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int capacityIn = 0;
    private int capacityOut = 0;

    public T poll() {
        if (capacityOut == 0) {
            while (capacityIn != 0) {
                out.push(in.pop());
                capacityOut++;
                capacityIn--;
            }
        }
        T t = out.pop();
        capacityOut--;
        return t;
    }

    public void push(T value) {
        in.push(value);
        capacityIn++;
    }
}