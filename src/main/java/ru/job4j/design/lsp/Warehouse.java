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

    @Override
    public boolean accept(Food food) {
        boolean isAccept = false;
        if (percent(food.getExpiryDate(), food.getCreateDate()) < 25.0) {
            isAccept = true;
        }
        return isAccept;
    }
}
