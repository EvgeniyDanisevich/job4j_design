package ru.job4j.gc.cache;

import java.util.List;

public class CacheEmulator {
    public static void main(String[] args) {
        CacheModel cacheModel = new CacheModel(List.of("Names.txt", "Address.txt"));
        System.out.println(cacheModel.get("Names.txt"));
        System.out.println();
        System.out.println(cacheModel.get("Address.txt"));
    }
}
