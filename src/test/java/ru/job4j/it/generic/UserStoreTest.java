package ru.job4j.it.generic;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class UserStoreTest {

    @Test
    public void add() {
        UserStore userStore = new UserStore();
        userStore.add(new User("123"));
        assertThat(userStore.findById("123").getId(), is("123"));
    }

    @Test
    public void replace() {
        UserStore userStore = new UserStore();
        userStore.add(new User("123"));
        userStore.add(new User("124"));
        userStore.replace("124", new User("124"));
        assertThat(userStore.findById("124").getId(), is("124"));
    }

    @Test
    public void deleted() {
        UserStore userStore = new UserStore();
        userStore.add(new User("123"));
        userStore.add(new User("124"));
        userStore.add(new User("125"));
        userStore.add(new User("126"));
        userStore.delete("124");
        assertThat(userStore.findById("123").getId(), is("123"));
        assertThat(userStore.findById("125").getId(), is("125"));
        assertThat(userStore.findById("126").getId(), is("126"));

    }
}