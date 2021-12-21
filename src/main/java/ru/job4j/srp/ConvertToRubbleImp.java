package ru.job4j.srp;

public class ConvertToRubbleImp implements ConvertCash {

    @Override
    public double convertSalaryInRubble(double salary) {
        return 75 * salary;
    }
}
