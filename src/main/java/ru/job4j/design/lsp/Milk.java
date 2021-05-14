package ru.job4j.design.lsp;

import java.time.LocalDate;
import java.util.Date;

public class Milk extends Food {
    public Milk(String name, LocalDate expiryDate, LocalDate createDate, int price, int discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
