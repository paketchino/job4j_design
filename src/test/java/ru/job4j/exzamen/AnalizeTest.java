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
        Analize.User user1 = new Analize.User(1, "Serega");
        Analize.User user2 = new Analize.User(2, "Maksim");
        Analize.User user3 = new Analize.User(3, "Eugene");
        Analize.User userCurrent = new Analize.User(3, "Sasha");
        Analize.Info rsl = analize.diff(
                List.of(user1, user2, user3),
                List.of(user1, user2, userCurrent)
        );
        assertThat(rsl.added, is(3));
        assertThat(rsl.changed, is(1));
        assertThat(rsl.deleted, is(1));
    }
}
