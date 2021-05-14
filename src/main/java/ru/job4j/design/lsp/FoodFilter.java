package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.util.List;

public class FoodFilter {
    private final List<Food> foodList;

    private final Storage warehouse = new Warehouse();
    private final Storage shop = new Shop();
    private final Storage trash = new Trash();

    public FoodFilter(List<Food> foodList) {
        this.foodList = foodList;
    }

    public Storage getWarehouse() {
        return warehouse;
    }

    public Storage getShop() {
        return shop;
    }

    public Storage getTrash() {
        return trash;
    }

    private static double percent(LocalDate expiryDate, LocalDate createDate) {
        double expiryDays = expiryDate.getDayOfYear() - createDate.getDayOfYear();
        double spentDays = LocalDate.now().getDayOfYear() - createDate.getDayOfYear();
        return (spentDays * 100) / expiryDays;
    }

    public void filter() {
        ControlQuality controlQuality;
        for (Food food : foodList) {
            if (percent(food.getExpiryDate(), food.getCreateDate()) < 25.0) {
                controlQuality = new ControlQuality(warehouse);
                controlQuality.putStorage(food);
            } else if (percent(food.getExpiryDate(), food.getCreateDate()) >= 25.0
                    && percent(food.getExpiryDate(), food.getCreateDate()) <= 75.0) {
                controlQuality = new ControlQuality(shop);
                controlQuality.putStorage(food);
            } else if (percent(food.getExpiryDate(), food.getCreateDate()) > 75
                    && percent(food.getExpiryDate(), food.getCreateDate()) < 100) {
                controlQuality = new ControlQuality(shop);
                food.setPrice(food.getPrice() - food.getDiscount());
                food.setName(food.getName() + " со скидкой");
                controlQuality.putStorage(food);
            } else if (percent(food.getExpiryDate(), food.getCreateDate()) >= 100.0) {
                controlQuality = new ControlQuality(trash);
                controlQuality.putStorage(food);
            }
        }
    }
}
