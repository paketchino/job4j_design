package ru.job4j.it.generic.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Generics gen = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();
        first.add(new Animal("Cat", 2));
        second.add(new Predator("Tiger", 2));
        third.add(new Tiger("Elephent", 32));
        gen.printObject(first);
        gen.printObject(second);
        gen.printObject(third);
        System.out.println();

        gen.printBoundedWildCard(second);
        gen.printBoundedWildCard(third);
        System.out.println();

        gen.printLowerBoundedCard(first);
        gen.printLowerBoundedCard(second);
    }

    public void printObject(List<?> list) {
        for (Iterator<?> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент " + next);
        }
    }

    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Iterator<? extends Predator> it = list.iterator(); it.hasNext();) {
            Animal next = it.next();
            System.out.println("Текущий элемент " + next);
        }
    }

    public void printLowerBoundedCard(List<? super Predator> list) {
        for (Iterator<? super Predator> it = list.iterator(); it.hasNext();) {
            Integer next = (Integer) it.next();
            System.out.println("Текущий элемент " + next);
        }
    }
}
