package ru.job4j.srp;

import example.Elevator;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class HRDepartment implements Report, Comparator<Employee> {

    private Comparator<Employee> comparator;
    private final Store store;

    public HRDepartment(Store store, Comparator<Employee> comparator) {
        this.store = store;
        this.comparator = comparator;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        List<Employee> storage = store.findBy(filter);
        storage.sort(comparator);
        for (Employee em : storage) {
            text.append(em.getName()).append(";")
                    .append(em.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}
