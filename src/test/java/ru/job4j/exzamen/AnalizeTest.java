package ru.job4j.exzamen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class AnalizeTest {

    @Test
    public void diff() {
        Analize analize = new Analize();
        Analize.User user1 = new Analize.User(1, "Vasiliy");
        Analize.User user2 = new Analize.User(2, "Serega");
        Analize.User user3 = new Analize.User(3, "Maksim");
        Analize.User user4 = new Analize.User(3, "Eugene");
        Analize.Info rsl = analize.diff(
                List.of(user1, user2, user3, user4),
                List.of(user2, user3)
        );
        assertThat(rsl.added, is(2));
        assertThat(rsl.changed, is(1));
        assertThat(rsl.deleted, is(2));
    }
}
