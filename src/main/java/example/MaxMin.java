package example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {

    private <T> List<Integer> findByNumber(List<T> value, Comparator<T> comparator) {
        List<Integer> rsl = new ArrayList<>();
        for (int i = 0; i < value.size(); i++) {
            if (value.get(i).equals(i)) {
                rsl.add(i);
            }
        }
        return rsl;
    }

    private boolean comparator(Predicate<Comparator<Integer>> predicate, Comparator<Integer> comparator) {
        return predicate.test(comparator);
    }

    public <T> List<Integer> max(List<T> value, Comparator<T> comparator) {
        return findByNumber(value, );

    }

    public <T> Integer min(List<T> value, Comparator<T> comparator) {
        return null;

    }
}

