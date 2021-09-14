package example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ReduceMethodThenOneArguments {

    public static Integer reduce(List<Integer> list) {
        return list.stream().reduce((n1, n2) -> n1 * n2).get();
    }

    static class ReduceMethodWithTwoArguments {

        public static Integer reduce(List<Integer> list) {
            return list.stream().reduce(5,(n1, n2) -> n1 * n2);
        }
    }

    static class MinMethod {

        public static String min(List<String> list) {
            return list.stream().min((n1,n2) -> Integer.compare(n1.length(), n2.length())).get();
        }
    }

    static class StreamMethod {
        public static Stream<Integer> createStream(Collection<Integer> data) {
            return data.stream();
        }
    }

    static class StreamOfMethod {

        public static Stream<Character> createStream() {
            return Stream.of('a', 'b', 'c');
        }
    }

    static class StreamIterate {

        public static void showArray(Integer[] data) {
            Stream.iterate(0, i -> i < data.length, i-> i + 2)
                    .forEach(i -> System.out.println(data[i]));
        }
    }

    static class StreamBuilder {

        public static Stream<Object> createStream(Integer[] data) {
            return Stream.builder().add(data[0]).add(data[data.length - 1]).build();
        }
    }

    static class RangeMethod {

        public static IntStream createStream(int start, int end) {
            return IntStream.rangeClosed(start, end);
        }
    }

    static class FlatIt {

//        public static List<Integer> flatten (Iterator<Iterator<Integer>> it) {
//            return iteratorToStream(it).flatMap((iter1 -> iter1).collect(Collectors.toList());
//        }

        public static <T> Stream<T> iteratorToStream(Iterator<T> it) {
            return StreamSupport.stream(Spliterators.spliteratorUnknownSize(it, Spliterator.ORDERED), false);
        }
    }
}
