package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.util.Date;

public class Meat extends Food {
    public Meat(String name, LocalDate expiryDate, LocalDate createDate, int price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
