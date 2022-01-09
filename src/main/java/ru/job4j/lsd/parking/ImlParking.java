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
        boolean rsl = false;
        if (getSize(transport)) {
            parkingPlace.add(transport);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean getSize(Transport transport) {
        boolean rsl = false;
        if (passengerCar == 0 && truck == 0) {
            System.out.println("Парковка заполнена");
            rsl = false;
        } else if (transport.getSizeCar() == 1 || transport.getSizeCar() == 2) {
            passengerCar = passengerCar - transport.getSizeCar();
            rsl = true;
        } else if (transport.getSizeCar() == 2) {
            truck = truck - transport.getSizeCar();
            rsl = true;
        }
        return rsl;
    }
}
