package ru.job4j.design.lsp;

import java.util.List;

public class ControlQuality {
    private final List<Storage> storageList;

    public ControlQuality(List<Storage> storageList) {
        this.storageList = storageList;
    }

    public void putToStorage(Food food) {
        storageList.stream()
                .filter(storage -> storage.accept(food))
                .forEach(storage -> storage.put(food));
    }
}
