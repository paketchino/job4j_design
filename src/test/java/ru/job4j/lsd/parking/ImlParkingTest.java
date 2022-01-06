package ru.job4j.lsd.parking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ImlParkingTest {

    @Test
    public void whenNeedToCheckParkPlaceForPassengerCar() {
        Transport transport = new PassengerCar("Lada", 1);
        Transport truck = new Truck("Truck", 2);
        ImlParking imlParking = new ImlParking();
        assertTrue(imlParking.add(transport));
        assertTrue(imlParking.add(truck));
    }
}