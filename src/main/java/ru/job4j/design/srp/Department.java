package ru.job4j.design.srp;

import java.util.List;

public interface Department {
    String depFilter(List<Employee> employees);
}
