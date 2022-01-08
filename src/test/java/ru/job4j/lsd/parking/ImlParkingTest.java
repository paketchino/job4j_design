package ru.job4j.lsd.parking;

import org.junit.Ignore;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ImlParkingTest {

    @Ignore
    @Test
    public void when2PassengerCar1TruckThenParkingHave3FreePlaceForTAndPC() {
        List<Transport> listTr = new ArrayList<>();
        ImlParking imlParking = new ImlParking(2, 1, listTr);
        Transport passengerCarFirst = new PassengerCar("Lada", 1);
        Transport passengerCarSecond = new PassengerCar("BMW", 1);
        Transport truck = new Truck("Truck", 2);
        imlParking.add(passengerCarFirst);
        imlParking.add(passengerCarSecond);
        imlParking.add(truck);
    }

    @Ignore
    @Test
    public void when1TruckThenHave2ParkingPlaceForPassengerCars() {
        List<Transport> listTr = new ArrayList<>();
        ImlParking imlParking = new ImlParking(2, 0, listTr);
        Transport truck = new Truck("Truck", 2);
        imlParking.add(truck);
    }

    @Ignore
    @Test
    public void when4PassengerCarThenHave2PlaceForTrucks() {
        List<Transport> listTr = new ArrayList<>();
        ImlParking imlParking = new ImlParking(0, 4, listTr);
        Transport transportFirst = new PassengerCar("Name1", 1);
        Transport transportSecond = new PassengerCar("Name2", 1);
        Transport transportThird = new PassengerCar("Name3", 1);
        Transport transportForth = new PassengerCar("Name4", 1);
        imlParking.add(transportFirst);
        imlParking.add(transportSecond);
        imlParking.add(transportThird);
        imlParking.add(transportForth);
    }

    @Ignore
    @Test
    public void when3TruckThenHave4PlaceForPassengerCar() {
        List<Transport> listTr = new ArrayList<>();
        ImlParking imlParking = new ImlParking(4, 0, listTr);
        Transport transportFirst = new Truck("Truck1", 2);
        Transport transportSecond = new Truck("Truck2", 2);
        Transport transportThird = new Truck("Truck3", 2);
        imlParking.add(transportFirst);
        imlParking.add(transportSecond);
        imlParking.add(transportThird);
    }

    @Ignore
    @Test
    public void when1Truck1PassengerCarThenHave1PlaceForPC() {
        List<Transport> listTr = new ArrayList<>();
        ImlParking imlParking = new ImlParking(1, 0, listTr);
        Transport transportFirst = new PassengerCar("Name1", 1);
        Transport transportSecond = new Truck("Truck1", 2);
        assertTrue(imlParking.add(transportFirst));
        assertFalse(imlParking.add(transportSecond));
    }
}