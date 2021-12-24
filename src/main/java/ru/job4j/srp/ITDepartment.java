package ru.job4j.srp;

import java.util.function.Predicate;

public class ITDepartment implements Report {

    private Store store;

    public ITDepartment(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee em : store.findBy(filter)) {
            text.append("<!DOCTYPE html>\n")
                    .append("<html lang=\"en").append(">\n")
                    .append("<head>\n")
                    .append("<meta charset=\"UTF-8\">\n")
                    .append("<title> Name; Fired; Hired; Salary;</title>\n")
                    .append("</head>\n")
                    .append("<body>\n")
                    .append("<h1>").append(em.getName()).append("</h1>\n")
                    .append("<h2>").append(em.getFired()).append("</h2>\n")
                    .append("<h3>").append(em.getHired()).append("</h3>\n")
                    .append("<h4>").append(em.getSalary()).append("</h4>\n")
                    .append("</body>\n")
                    .append("</html>\n");
        }
        return text.toString();
    }
}
