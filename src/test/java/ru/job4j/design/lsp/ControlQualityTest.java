package ru.job4j.design.lsp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControlQualityTest {
    private final List<Food> foodList = List.of(
            new Bread(
                    "Черный хлеб",
                    LocalDate.of(2021, 5, 22),
                    LocalDate.of(2021, 5, 15),
                    100,
                    20
            ),
            new Bread(
                    "Белый хлеб",
                    LocalDate.of(2021, 5, 23),
                    LocalDate.of(2021, 5, 15),
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
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storage> storageList = new ArrayList<>();
        storageList.add(warehouse);
        storageList.add(shop);
        storageList.add(trash);
        ControlQuality controlQuality = new ControlQuality(storageList);
        foodList.forEach(controlQuality::putToStorage);
        assertEquals(List.of(foodList.get(0), foodList.get(1)), warehouse.getFood());
    }

    @Test
    public void whenGetShop() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storage> storageList = new ArrayList<>();
        storageList.add(warehouse);
        storageList.add(shop);
        storageList.add(trash);
        ControlQuality controlQuality = new ControlQuality(storageList);
        foodList.forEach(controlQuality::putToStorage);
        assertEquals(List.of(foodList.get(4), foodList.get(5)), shop.getFood());
    }

    @Test
    public void whenGetTrash() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();
        List<Storage> storageList = new ArrayList<>();
        storageList.add(warehouse);
        storageList.add(shop);
        storageList.add(trash);
        ControlQuality controlQuality = new ControlQuality(storageList);
        foodList.forEach(controlQuality::putToStorage);
        assertEquals(List.of(foodList.get(2), foodList.get(3)), trash.getFood());
    }
}