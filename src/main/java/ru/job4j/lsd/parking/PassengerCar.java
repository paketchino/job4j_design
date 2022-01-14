package ru.job4j.lsd.parking;

public class PassengerCar implements Transport {

    private String name;

    private int size;

    public PassengerCar(String name) {
        this.name = name;
        this.size = 1;
    }

    public int getSize() {
        return size;
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
        return getSize();
    }
}
