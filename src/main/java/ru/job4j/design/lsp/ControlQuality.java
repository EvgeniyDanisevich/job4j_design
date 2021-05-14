package ru.job4j.design.lsp;

public class ControlQuality {
    private final Storage storage;

    public ControlQuality(Storage storage) {
        this.storage = storage;
    }

    public void putStorage(Food food) {
        storage.put(food);
    }
}
