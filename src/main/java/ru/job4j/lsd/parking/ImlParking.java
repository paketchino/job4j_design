package ru.job4j.lsd.parking;

import java.util.ArrayList;
import java.util.List;

public class ImlParking implements Parking {

    private List<Transport> parkList = new ArrayList<>();

    @Override
    public boolean add(Transport transport) {
        boolean rsl = false;
        if (transport.getSizeCar() == 1) {
            parkList.add(transport);
            rsl = true;
        } else if (transport.getSizeCar() > 1) {
            parkList.add(transport);
            rsl = true;
        }
        return rsl;
    }
}
