package ru.job4j.serialization.jsom;

public class Conacat {
    private final String phone;

    public Conacat(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Conacat{" +
                "phone='" + phone + '\''
                + '}';
    }
}
