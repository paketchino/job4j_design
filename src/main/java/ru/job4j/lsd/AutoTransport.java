package ru.job4j.lsd;


/*
    У нас есть класс автотранспорта.
 */
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


/*
    Пусть теперь есть наследник - автобус. Предположим ему нужно больше топлива, чтобы сдвинуться с места
 */
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
/*
    От AutoTransport мы ожидаем, что машина сдвинется, но нет.
    Автобус не сдвигается, т.к. в нем усилено предусловие.
    Ожидаем мы одно поведение, а получаем другое.
 */
    class FirstRule {
    public static void main(String[] args) {
        AutoTransport bus = new Bus(3);
        AutoTransport autoTransport = new AutoTransport(3);
        bus.move(2);
    }
}
