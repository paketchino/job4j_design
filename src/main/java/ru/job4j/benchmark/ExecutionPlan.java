package ru.job4j.benchmark;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

public class ExecutionPlan {

    public int iteration;

    public String password = "4v3rys3kur3p455w0rd";

    ExampleBenchmark exampleBenchmark;


}
