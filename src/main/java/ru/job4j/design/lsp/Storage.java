package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.util.List;

public interface Storage {
    void put(Food food);

    List<Food> getFood();

    boolean accept(Food food);

    default double percent(LocalDate expiryDate, LocalDate createDate) {
        double expiryDays = expiryDate.getDayOfYear() - createDate.getDayOfYear();
        double spentDays = LocalDate.now().getDayOfYear() - createDate.getDayOfYear();
        return (spentDays * 100) / expiryDays;
    }
}
