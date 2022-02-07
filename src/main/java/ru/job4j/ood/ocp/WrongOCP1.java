package ru.job4j.ood.ocp;

public class WrongOCP1 {

    /*
    Данная программа закрата к расширению, если нужно
    делить значение или выполнять другие операции.
    Придется писать новый метод или полностью менять
    текущий метод
     */

    private int first;
    private int second;

    public WrongOCP1(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int somethingDoing(int first, int second) {
        return (int) (Math.sqrt(first) * Math.sqrt(second));
    };
}
