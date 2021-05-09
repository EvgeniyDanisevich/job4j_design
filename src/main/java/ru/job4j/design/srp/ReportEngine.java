package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

public class ReportEngine implements Report {

    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter, Department department) {
        return department.depFilter(store.findBy(filter));
    }
}