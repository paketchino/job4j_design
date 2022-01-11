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

    /*
        Метод add добавляет машины в свободные места
        на парковке
        return true если операция произошла успешно
     */
    @Override
    public boolean add(Transport transport) {
        boolean rsl = false;
        if (validate(transport)) {
            if (transport.getSizeCar() == 1) {
                passengerCarPlace = passengerCarPlace - transport.getSizeCar();
                parkingPlace.add(transport);
                rsl = true;
            } else if (transport.getSizeCar() > 1) {
                if (truckPlace == 0) {
                    passengerCarPlace = passengerCarPlace - transport.getSizeCar();
                } else {
                    truckPlace = truckPlace - transport.getSizeCar() + 1;
                }
                parkingPlace.add(transport);
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
        return (passengerCarPlace != 0 || truckPlace != 0)
                && (transport.getSizeCar() != 1 || passengerCarPlace != 0 || truckPlace == 0)
                && (passengerCarPlace >= transport.getSizeCar() || truckPlace != 0);
    }
}
