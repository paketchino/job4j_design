package ru.job4j.lsd.parking;

import org.junit.Ignore;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ImlParkingTest {

    @Test
    public void when2PassengerCar1TruckThenParkingHave3FreePlaceForTAndPC() {
        List<Transport> listTr = new ArrayList<>();
        ImlParking imlParking = new ImlParking(2, 1);
        Transport passengerCarFirst = new PassengerCar("Lada");
        Transport passengerCarSecond = new PassengerCar("BMW");
        Transport truck = new Truck("Truck", 4);
        assertTrue(imlParking.add(passengerCarFirst));
        assertTrue(imlParking.add(passengerCarSecond));
        assertTrue(imlParking.add(truck));
    }

    @Test
    public void when1TruckThenHave2ParkingPlaceForPassengerCars() {
        List<Transport> listTr = new ArrayList<>();
        ImlParking imlParking = new ImlParking(2, 0);
        Transport truck = new Truck("Truck", 2);
        assertTrue(imlParking.add(truck));
    }

    @Test
    public void when4PassengerCarThenHave2PlaceForTrucks() {
        List<Transport> listTr = new ArrayList<>();
        ImlParking imlParking = new ImlParking(4, 4);
        Transport transportFirst = new PassengerCar("Name1");
        Transport transportSecond = new PassengerCar("Name2");
        Transport transportThird = new PassengerCar("Name3");
        Transport transportForth = new PassengerCar("Name4");
        Transport truck = new Truck("Truck1", 2);
        Transport truck1 = new Truck("Truck2", 4);
        Transport truck2 = new Truck("Truck3", 3);
        Transport truck3 = new Truck("Truck4", 5);
        assertTrue(imlParking.add(truck));
        assertTrue(imlParking.add(truck1));
        assertTrue(imlParking.add(truck2));
        assertTrue(imlParking.add(truck3));
        assertTrue(imlParking.add(transportFirst));
        assertTrue(imlParking.add(transportSecond));
        assertTrue(imlParking.add(transportThird));
        assertTrue(imlParking.add(transportForth));
    }

    @Test
    public void when3TruckThenHave4PlaceForPassengerCar() {
        List<Transport> listTr = new ArrayList<>();
        ImlParking imlParking = new ImlParking(4, 0);
        Transport transportFirst = new Truck("Truck1", 2);
        Transport transportSecond = new Truck("Truck2", 2);
        Transport transportThird = new Truck("Truck3", 2);
        assertTrue(imlParking.add(transportFirst));
        assertTrue(imlParking.add(transportSecond));
        assertFalse(imlParking.add(transportThird));
    }

    @Test
    public void when1Truck1PassengerCarThenHave1PlaceForPC() {
        List<Transport> listTr = new ArrayList<>();
        ImlParking imlParking = new ImlParking(1, 0);
        Transport transportFirst = new PassengerCar("Name1");
        Transport transportSecond = new Truck("Truck1", 2);
        assertTrue(imlParking.add(transportFirst));
        assertFalse(imlParking.add(transportSecond));
    }

    @Test
    public void when2PassengerTruckThenHave1PlaceForTruck() {
        Transport passengerCarFirst = new PassengerCar("Lada");
        Transport passengerCarSecond = new PassengerCar("BMW");
        ImlParking imlParking = new ImlParking(0, 2);
        assertFalse(imlParking.add(passengerCarFirst));
        assertFalse(imlParking.add(passengerCarSecond));
    }

    @Test
    public void when1TruckThenHave1PlaceForPC() {
        ImlParking imlParking = new ImlParking(1, 0);
        Transport transportFirst = new Truck("Truck1", 2);
        Transport passengerCarSecond = new PassengerCar("BMW");
        assertFalse(imlParking.add(transportFirst));
        assertTrue(imlParking.add(passengerCarSecond));
    }

    @Test
    public void when2CarTakesThenHave1PlaceForTruck() {
        ImlParking imlParking = new ImlParking(0, 1);
        Transport passengerCarSecond = new PassengerCar("BMW");
        Transport passengerCarThird = new PassengerCar("Priora");
        assertFalse(imlParking.add(passengerCarSecond));
        assertFalse(imlParking.add(passengerCarThird));
    }

    @Test
    public void when2PCThenHaveSizeGreater1() {
        ImlParking imlParking = new ImlParking(2, 0);
        Transport passengerCarSecond = new PassengerCar("BMW");
        Transport passengerCarThird = new PassengerCar("Priora");
        imlParking.add(passengerCarSecond);
        imlParking.add(passengerCarThird);
        assertFalse(imlParking.add(passengerCarSecond));
        assertFalse(imlParking.add(passengerCarThird));
    }

    @Test(expected = IllegalArgumentException.class)
    public void when2TruckCreateSize1ThenException() {
        ImlParking imlParking = new ImlParking(0, 2);
        Transport transportFirst = new Truck("Truck2", 1);
        Transport transportSecond = new Truck("Truck3", 1);
        imlParking.add(transportFirst);
        imlParking.add(transportSecond);
    }
}