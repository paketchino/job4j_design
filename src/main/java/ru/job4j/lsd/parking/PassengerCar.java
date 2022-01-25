package ru.job4j.lsd.parking;

public class PassengerCar implements Transport {

    private String name;
    private int size;
    private static final int SIZE = 1;

    public PassengerCar(String name) {
        this.name = name;
        this.size = SIZE;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PassengerCar{" + "name='" + name + '\''
                + ", size=" + size + '}';
    }

    @Override
    public int getSizeCar() {
        return SIZE;
    }
}
