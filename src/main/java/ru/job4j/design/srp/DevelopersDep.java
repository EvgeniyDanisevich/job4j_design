package ru.job4j.design.srp;

import java.util.List;

public class DevelopersDep implements Department {
    public String depFilter(List<Employee> employees) {
        StringBuilder text = new StringBuilder();
        text.append("<html>").append("<body>");
        text.append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        text.append("</body>").append("</html>");
        return text.toString();
    }
}
