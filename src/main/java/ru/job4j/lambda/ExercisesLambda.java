package ru.job4j.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ExercisesLambda {

    public static boolean checkNumber(int num) {
        return check(n -> n > 0, num);
    }

    public static boolean check(int num) {
        return check(n -> n % 2 == 0 && n > 0, num);
    }

    private static boolean check(Predicate<Integer> predicate, int num) {
        return predicate.test(num);
    }

    public static double calculateOneExample(double x) {
        return calculate(num -> num * num, x);
    }

    public static double calculateRootTwoExample(double x) {
        return calculate(Math::sqrt, x);
    }

    public static double calculateThreeExample(double x) {
        return calculate(num -> num * num + 2 * num + 1, x);
    }

    public static double calculate(Function<Double, Double> y, double x) {
        return y.apply(x);
    }

    public static Consumer<String> consumer(String input) {
        Consumer<String> print = System.out::print;
        Consumer<String> ln = (num) -> System.out.println();
        return print.andThen(ln);
    }

    public void applyByInstance() {
        Consumer<String> consumer = this::consumerByInstance;
        consumer.accept("Hello");
    }

    private void consumerByInstance(String input) {
        System.out.print("From instance: " + input);
    }

    public static void applyByClass() {
        Consumer<String> consumer = ExercisesLambda::consumerByClass;
        consumer.accept("Hello");
    }

    private static void consumerByClass(String input) {
        System.out.print("From class: " + input);
    }

    public static Function<Double, Double> apply() {
        return Math::sqrt;
    }

    public static Predicate<String> predicate() {
        return String::isEmpty;
    }
}
