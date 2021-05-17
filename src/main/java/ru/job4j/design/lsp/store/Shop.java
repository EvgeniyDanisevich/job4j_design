package ru.job4j.design.lsp.store;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Storage {
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
        if (percent(food.getExpiryDate(), food.getCreateDate()) >= 25.0
            && percent(food.getExpiryDate(), food.getCreateDate()) <= 75.0) {
            isAccept = true;
        } else if (percent(food.getExpiryDate(), food.getCreateDate()) > 75
            && percent(food.getExpiryDate(), food.getCreateDate()) < 100) {
            food.setPrice(food.getPrice() - food.getDiscount());
            food.setName(food.getName() + " со скидкой");
            isAccept = true;
        }
        return isAccept;
    }
}
