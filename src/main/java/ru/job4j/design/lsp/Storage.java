package ru.job4j.design.lsp;

import java.util.List;

public interface Storage {
    void put(Food food);

    List<Food> getFood();
}
