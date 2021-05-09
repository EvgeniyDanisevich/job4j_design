package ru.job4j.design.srp;

import java.util.List;

public class AccountingDep implements Department {
    @Override
    public String depFilter(List<Employee> employees) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append("$").append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
