package ru.job4j.lsd.parking;

public class PassengerCar implements Transport {

    private String name;
    private int size = 1;
    private static final int SIZEPC = 1;

    public PassengerCar(String name) {
        this.name = name;
        this.size = SIZEPC;
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
