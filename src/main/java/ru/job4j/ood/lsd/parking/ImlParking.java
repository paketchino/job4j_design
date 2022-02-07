package ru.job4j.ood.lsd.parking;

import java.util.ArrayList;
import java.util.List;

public class ImlParking implements Parking {

    private int passengerCarPlace;
    private int truckPlace;
    private List<Transport> parkingPlaceForTruck;
    private List<Transport> parkingPlaceForPC;
    public static final int SIZE = 1;
    public static final int NOTPLACE = 0;

    public ImlParking(int passengerCarPlace, int truckPlace) {
        this.passengerCarPlace = passengerCarPlace;
        this.truckPlace = truckPlace;
        this.parkingPlaceForPC = new ArrayList<>(passengerCarPlace);
        this.parkingPlaceForTruck = new ArrayList<>(truckPlace);
    }
    /*
        Метод add добавляет машины в свободные места
        на парковке
        return true если операция произошла успешно
     */
    @Override
    public boolean add(Transport transport) {
        boolean rsl = false;
        if (validate(transport)) {
            if (transport.getSizeCar() == SIZE) {
                passengerCarPlace -= transport.getSizeCar();
                parkingPlaceForPC.add(transport);
                rsl = true;
            } else if (transport.getSizeCar() > SIZE) {
                if (truckPlace == NOTPLACE) {
                    passengerCarPlace -= transport.getSizeCar();
                    parkingPlaceForPC.add(transport);
                } else {
                    truckPlace -= (transport.getSizeCar() + 1);
                    parkingPlaceForTruck.add(transport);
                }
                rsl = true;
            }
        }
        return rsl;
    }
    /*
        Метод проверяет все невалидные варианты
     */
    @Override
    public boolean validate(Transport transport) {
        return (passengerCarPlace != NOTPLACE || truckPlace != NOTPLACE)
                && (transport.getSizeCar() != SIZE || passengerCarPlace != NOTPLACE || truckPlace == NOTPLACE)
                && (passengerCarPlace >= transport.getSizeCar() || truckPlace != NOTPLACE);
    }
}
