package ru.job4j.lsd;

public class AutoTransport {

    protected float fuel;

    public AutoTransport(float fuel) {
        this.fuel = fuel;
    }

    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance!");
        }
        if (fuel < 0) {
            throw new IllegalArgumentException("Need more fuel!");
        }
    }
}

class Bus extends AutoTransport {

    public Bus(float fuel) {
        super(fuel);
    }

    public void move(float km) {
        if (km < 0) {
            throw new IllegalArgumentException("Invalid distance!");
        }
        if (fuel < 5) {
            throw new IllegalArgumentException("Need more fuel!");
        }
    }

}

    class FirstRule {
    public static void main(String[] args) {
        AutoTransport bus = new Bus(3);
        AutoTransport autoTransport = new AutoTransport(3);
        bus.move(2);
    }
}
