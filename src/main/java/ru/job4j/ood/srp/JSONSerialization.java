package ru.job4j.ood.srp;

import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBException;
import java.util.function.Predicate;

public class JSONSerialization implements Report {

    private Store store;

    public JSONSerialization(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        return new GsonBuilder().create().toJson(store);
    }
}
