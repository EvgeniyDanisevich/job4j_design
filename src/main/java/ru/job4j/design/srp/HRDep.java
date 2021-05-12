package ru.job4j.design.srp;

import java.util.List;

public class HRDep implements Department {
    @Override
    public String depFilter(List<Employee> employees) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary")
                .append(System.lineSeparator());
        employees.sort((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()));
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
