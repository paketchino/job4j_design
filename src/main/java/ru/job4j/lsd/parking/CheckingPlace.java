package ru.job4j.lsd.parking;

public interface CheckingPlace {

    boolean checking(PassengerCar car, Trucks trucks);
}
