package ru.job4j.design.srp;

import java.util.List;

public class HRDep implements Department {
    @Override
    public String depFilter(List<Employee> employees) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary")
                .append(System.lineSeparator());
        employees.sort((o1, o2) -> {
            if (o1.getSalary() < o2.getSalary()) {
                return 1;
            } else if (o1.getSalary() > o2.getSalary()) {
                return -1;
            }
            return 0;
        });
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
