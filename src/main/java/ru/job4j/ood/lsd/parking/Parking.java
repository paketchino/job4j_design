package ru.job4j.ood.lsd.parking;

public interface Parking {

    boolean add(Transport transport);

    boolean validate(Transport transport);
}
