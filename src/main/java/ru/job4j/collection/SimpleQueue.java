package ru.job4j.collection;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private SimpleStack<T> simpleStack = new SimpleStack<>();
    private int capacityIn = 0;
    private int capacityOut = 0;

    public T poll() {
        while (capacityIn != 0) {
            out.push(in.pop());
            capacityOut++;
            capacityIn--;
        }
        capacityOut--;
        return out.pop();
    }

    public void push(T value) {
        while (capacityOut != 0) {
            in.push(out.pop());
            capacityOut--;
            capacityIn++;
        }
        in.push(value);
        capacityIn++;
    }
}