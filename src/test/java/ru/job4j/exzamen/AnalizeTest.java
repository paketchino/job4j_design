package ru.job4j.exzamen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class AnalizeTest {

    @Test
    public void when2Added0Deleted0Changed() {
        Analize analize = new Analize();
        Analize.User user1 = new Analize.User(1,"a");
        Analize.User user2 = new Analize.User(2,"b");
        Set<Analize.User> previous = Set.of(user1, user2);
        Set<Analize.User> current = Set.of(new Analize.User(3, "c"),
                new Analize.User(4, "d"));
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.added, is(2));
        assertThat(info.deleted, is(0));
        assertThat(info.changed, is(0));
    }

    @Test
    public void when0Added1Changed0Deleted() {
        Analize analize = new Analize();
        Analize.User user1 = new Analize.User(1,"a");
        Set<Analize.User> prev = Set.of(user1);
        Analize.User user2 = new Analize.User(1, "G");
        Set<Analize.User> curr = Set.of(user2);
        Analize.Info info = analize.diff(prev, curr);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(1));
        assertThat(info.deleted, is(1));
    }

    @Test
    public void when0Added0Changed1Deleted() {
        Analize analize = new Analize();
        Set<Analize.User> prev = Set.of(
                new Analize.User(1, "A"),
                new Analize.User(2, "V"),
                new Analize.User(3, "D"));
        Set<Analize.User> curr = Set.of(
                new Analize.User(1, "A"),
                new Analize.User(2, "V")
                );
        Analize.Info info = analize.diff(prev, curr);
        assertThat(info.added, is(0));
        assertThat(info.changed, is(0));
        assertThat(info.deleted, is(1));
    }

    @Test
    public void whenAllChanged() {
        Analize analize = new Analize();
        Analize.User u1 = new Analize.User(1, "A");
        Analize.User u2 = new Analize.User(2, "V");
        Analize.User u3 = new Analize.User(3, "D");
        Set<Analize.User> previous = Set.of(u1, u2, u3);
        Set<Analize.User> current = Set.of(new Analize.User(1, "AA"), u2,
                new Analize.User(4, "D"));
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.changed, is(1));
        assertThat(info.added, is(1));
        assertThat(info.deleted, is(1));
    }
}