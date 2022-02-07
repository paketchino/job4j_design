package ru.job4j.ood.srp;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenNeedToSortedDecreaseSalaryAndDeleteDateAndFired() throws JAXBException {
        MemStore storage = new MemStore();
        Employee workerFirst = new Employee("Ivan", 100);
        Employee workerSecond = new Employee("Sergey", 220);
        Employee workerThird = new Employee("Roman", 130);
        storage.add(workerFirst);
        storage.add(workerSecond);
        storage.add(workerThird);
        Report report = new HRDepartment(storage, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            }
        }.reversed());
        StringBuilder excepted = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(storage.get(1).getName()).append(";")
                .append(storage.get(1).getSalary()).append(";")
                .append(System.lineSeparator())
                .append(storage.get(2).getName()).append(";")
                .append(storage.get(2).getSalary()).append(";")
                .append(System.lineSeparator())
                .append(storage.get(0).getName()).append(";")
                .append(storage.get(0).getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(report.generate(em-> true), is(excepted.toString()));
    }

    @Test
    public void whenNeedToInputDateInHTML() {
        MemStore storage = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerFirst = new Employee("Ivan", now, now, 100);
        storage.add(workerFirst);
        ITDepartment itDep = new ITDepartment(storage);
        StringBuilder except = new StringBuilder()
                .append("<!DOCTYPE html>")
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
                .append(System.lineSeparator())
                .append("<h1>").append(workerFirst.getName()).append("</h1>")
                .append(System.lineSeparator())
                .append("<h2>").append(workerFirst.getFired()).append("</h2>")
                .append(System.lineSeparator())
                .append("<h3>").append(workerFirst.getHired()).append("</h3>")
                .append(System.lineSeparator())
                .append("<h4>").append(workerFirst.getSalary()).append("</h4>")
                .append(System.lineSeparator())
                .append("</body>")
                .append(System.lineSeparator())
                .append("</html>")
                .append(System.lineSeparator());
        assertThat(itDep.generate(em -> true), is(except.toString()));
    }

    @Test
    public void whenNeedToInputSerializableToXML() throws DatatypeConfigurationException {
        MemStore storage = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerFirst = new Employee("Ivan", now, now, 100);
        storage.add(workerFirst);
        XMLSerialization xml = new XMLSerialization(storage);
        XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) now);
        StringBuilder except = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<employeeList>\n")
                .append("    <employeeList>\n")
                .append("        <fired>").append(date).append("</fired>\n")
                .append("        <hired>").append(date).append("</hired>\n")
                .append("        <name>").append(workerFirst.getName()).append("</name>\n")
                .append("        <salary>").append(workerFirst.getSalary()).append("</salary>\n")
                .append("    </employeeList>\n")
                .append("</employeeList>\n");
        assertThat(xml.generate(em -> true), is(except.toString()));
    }

    @Test
    public void whenNeedToInputToJSONSerialization() throws JAXBException {
        MemStore storage = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerFirst = new Employee("Ivan", now, now, 100);
        storage.add(workerFirst);
        JSONSerialization json = new JSONSerialization(storage);
        StringBuilder except = new StringBuilder()
                .append("{\"employees\":[{\"name\":\"")
                .append(workerFirst.getName())
                .append("\",\"")
                .append("hired\":{\"year\":")
                .append(now.get(Calendar.YEAR))
                .append(",\"month\":")
                .append(now.get(Calendar.MONTH))
                .append(",\"dayOfMonth\":")
                .append(now.get(Calendar.DAY_OF_MONTH))
                .append(",\"hourOfDay\":")
                .append(now.get(Calendar.HOUR_OF_DAY))
                .append(",\"minute\":")
                .append(now.get(Calendar.MINUTE))
                .append(",\"second\":")
                .append(now.get(Calendar.SECOND))
                .append("},\"fired\":")
                .append("{\"year\":")
                .append(now.get(Calendar.YEAR))
                .append(",\"month\":")
                .append(now.get(Calendar.MONTH))
                .append(",\"dayOfMonth\":")
                .append(now.get(Calendar.DAY_OF_MONTH))
                .append(",\"hourOfDay\":")
                .append(now.get(Calendar.HOUR_OF_DAY))
                .append(",\"minute\":")
                .append(now.get(Calendar.MINUTE))
                .append(",\"second\":")
                .append(now.get(Calendar.SECOND))
                .append("},\"salary\":")
                .append(workerFirst.getSalary()).append("}]}");
        assertThat(json.generate(em -> true), is(except.toString()));
    }
}