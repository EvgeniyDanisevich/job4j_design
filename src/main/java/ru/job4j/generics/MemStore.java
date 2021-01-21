package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (mem.contains(findById(id))) {
            mem.set(Integer.parseInt(id), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (mem.contains(findById(id))) {
            mem.remove(findById(id));
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return mem.get(Integer.parseInt(id));
    }
}