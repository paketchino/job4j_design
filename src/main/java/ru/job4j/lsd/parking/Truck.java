package ru.job4j.lsd.parking;

public class Truck implements Transport {

    private String name;

    private int size;

    public Truck(String name, int size) {
        this.name = name;
        this.size = 2;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Truck{" + "name=" + name
                + ", age=" + size + '}';
    }

    @Override
    public int getSizeCar() {
        return getSize();
    }
}
