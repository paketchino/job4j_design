package ru.job4j.lsd.parking;

import java.util.ArrayList;
import java.util.List;

public class ImlParking implements Parking {

    private int passengerCarPlace;
    private int truckPlace;
    private List<Transport> parkingPlace =
            new ArrayList<>(passengerCarPlace + truckPlace);

    public ImlParking(int passengerCarPlace, int truckPlace) {
        this.passengerCarPlace = passengerCarPlace;
        this.truckPlace = truckPlace;
    }

    @Override
    public boolean add(Transport transport) {
        boolean rsl = false;
        if (getSize(transport)) {
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean getSize(Transport transport) {
        boolean rsl = false;
        if (passengerCarPlace == 0 && truckPlace == 0
                || transport.getSizeCar() == 1 && passengerCarPlace == 0 && truckPlace != 0) {
            return false;
        } else if (transport.getSizeCar() == 1) {
            passengerCarPlace = passengerCarPlace - transport.getSizeCar();
            parkingPlace.add(transport);
            rsl = true;
        } else if (transport.getSizeCar() > 1) {
            if (truckPlace == 0) {
                passengerCarPlace = passengerCarPlace - transport.getSizeCar();
                parkingPlace.add(transport);
            } else {
                truckPlace = truckPlace - transport.getSizeCar() + 1;
            }
            rsl = true;
        }
        return rsl;
    }
}
