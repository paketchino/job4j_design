package ru.job4j.srp;

import java.util.function.Predicate;

public class ITDepartment implements Report {

    private Store store;

    public ITDepartment(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder().append("<!DOCTYPE html>")
                .append(System.lineSeparator())
                .append("<html lang=\"ru\">")
                .append(System.lineSeparator())
                .append("<head>")
                .append(System.lineSeparator())
                .append("<meta charset=\"UTF-8\">")
                .append(System.lineSeparator())
                .append("<title> Name; Fired; Hired; Salary;</title>")
                .append(System.lineSeparator())
                .append("</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(System.lineSeparator());
        for (Employee em : store.findBy(filter)) {
                    text.append("<h1>").append(em.getName()).append("</h1>")
                            .append(System.lineSeparator())
                    .append("<h2>").append(em.getFired()).append("</h2>")
                            .append(System.lineSeparator())
                    .append("<h3>").append(em.getHired()).append("</h3>")
                            .append(System.lineSeparator())
                    .append("<h4>").append(em.getSalary()).append("</h4>")
                            .append(System.lineSeparator());
        }
        text.append("</body>")
                .append(System.lineSeparator())
                .append("</html>")
                .append(System.lineSeparator());
        return text.toString();
    }
}
