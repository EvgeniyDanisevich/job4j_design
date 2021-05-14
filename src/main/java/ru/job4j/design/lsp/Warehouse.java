package ru.job4j.design.lsp;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Storage {
    private final List<Food> foods = new ArrayList<>();

    @Override
    public void put(Food food) {
        this.foods.add(food);
    }

    @Override
    public List<Food> getFood() {
        return foods;
    }
}
