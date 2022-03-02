package ru.job4j.references;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

import java.io.IOException;

public class BenchmarkMode {

    @Benchmark
    @Fork(value = 1, warmups = 2)
    @org.openjdk.jmh.annotations.BenchmarkMode(Mode.Throughput)
    public void init() {
    }

    static class BenchmarkRunner {

        public static void main(String[] args) throws IOException {
            Main.main(args);
        }
    }
}
