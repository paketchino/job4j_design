package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportEngine implements Report {

    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder sb = new StringBuilder();
        sb.append("Name;Hired;Fired;Salary");
        for (Employee employee : store.findBy(filter)) {
            sb.append(employee.getName()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
            .append(System.lineSeparator());
        }
        return sb.toString();
    }
}
