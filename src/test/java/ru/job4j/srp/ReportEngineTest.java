package ru.job4j.srp;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ReportEngineTest {

    @Ignore
    @Test
    public void whenOldGenerated() {
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
    public void whenNeedToConvertSalaryInDollar() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerOne = new Employee("Ivan", now, now, 100);
        store.add(workerOne);
        ConvertToRubbleImp convert = new ConvertToRubbleImp();
        assertThat(convert.convertSalaryInRubble(workerOne.getSalary()), is(7500.0D));
    }

    @Ignore
    @Test
    public void whenNeedToChangeSalary() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        ConvertToRubbleImp convert = new ConvertToRubbleImp();
        Employee workerOne = new Employee("Ivan", now, now, 100);
        workerOne.setSalary(convert.convertSalaryInRubble(workerOne.getSalary()));
        store.add(workerOne);
        Report engine = new ReportEngine(store);
        StringBuilder except = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(workerOne.getName()).append(";")
                .append(workerOne.getHired()).append(";")
                .append(workerOne.getFired()).append(";")
                .append(workerOne.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(except.toString()));
    }

    @Ignore
    @Test
    public void whenNeedToSortedDecreaseSalaryAndDeleteDateAndFired() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee workerOne = new Employee("Ivan", now, now, 100);
        store.add(workerOne);
        Report engine = new ReportEngine(store);
        StringBuilder except = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(workerOne.getName()).append(";")
                .append(workerOne.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(except.toString()));
    }
}