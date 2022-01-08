package ru.job4j.lsd.parking;

import java.util.ArrayList;
import java.util.List;

public class ImlParking implements Parking {

    private List<Transport> parkingPlace;
    private int passengerCar;
    private int truck;

    public ImlParking(int passengerCar, int truck, List<Transport> parkingPlace) {
        this.passengerCar = passengerCar;
        this.truck = truck;
        this.parkingPlace = parkingPlace;
    }

    @Override
    public boolean add(Transport transport) {
        return false;
    }
}
