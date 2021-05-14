package ru.job4j.design.lsp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class FoodFilterTest {
    private final List<Food> foodList = List.of(
            new Bread(
                    "Черный хлеб",
                    LocalDate.of(2021, 5, 20),
                    LocalDate.of(2021, 5, 14),
                    100,
                    20
            ),
            new Bread(
                    "Белый хлеб",
                    LocalDate.of(2021, 5, 15),
                    LocalDate.of(2021, 5, 1),
                    150,
                    10
            ),
            new Milk(
                    "Сметана",
                    LocalDate.of(2021, 5, 12),
                    LocalDate.of(2021, 5, 8),
                    70,
                    10
            ),
            new Milk(
                    "Молоко",
                    LocalDate.of(2021, 5, 13),
                    LocalDate.of(2021, 5, 9),
                    60,
                    5
            ),
            new Meat(
                    "Говядина",
                    LocalDate.of(2021, 5, 25),
                    LocalDate.of(2021, 5, 10),
                    300,
                    20
            ),
            new Meat(
                    "Свинина",
                    LocalDate.of(2021, 5, 26),
                    LocalDate.of(2021, 5, 2),
                    250,
                    20
            ));

    @Test
    public void whenGetWarehouse() {
        FoodFilter foodFilter = new FoodFilter(foodList);
        foodFilter.filter();
        assertEquals(List.of(foodList.get(0)), foodFilter.getWarehouse().getFood());
    }

    @Test
    public void whenGetShop() {
        FoodFilter foodFilter = new FoodFilter(foodList);
        foodFilter.filter();
        assertEquals(List.of(foodList.get(1), foodList.get(4), foodList.get(5)), foodFilter.getShop().getFood());
    }

    @Test
    public void whenGetTrash() {
        FoodFilter foodFilter = new FoodFilter(foodList);
        foodFilter.filter();
        assertEquals(List.of(foodList.get(2), foodList.get(3)), foodFilter.getTrash().getFood());
    }
}