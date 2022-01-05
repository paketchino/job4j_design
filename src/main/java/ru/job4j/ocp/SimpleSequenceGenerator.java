package ru.job4j.ocp;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleSequenceGenerator implements SequenceGenerator {

    private Random random;

    public SimpleSequenceGenerator(Random random) {
        this.random = random;
    }

    @Override
    public List<Integer> generate(int size) {
        return IntStream.range(0, size)
                .map(i -> random.nextInt()).boxed()
                .collect(Collectors.toList());
    }
}