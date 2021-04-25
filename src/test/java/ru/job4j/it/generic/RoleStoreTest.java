package ru.job4j.it.generic;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class RoleStoreTest {

    @Test
    public void add() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("123"));
        roleStore.add(new Role("124"));
        roleStore.add(new Role("125"));
        assertThat(roleStore.findById("123").getId(), is("123"));
        assertThat(roleStore.findById("124").getId(), is("124"));
        assertThat(roleStore.findById("125").getId(), is("125"));
    }

    @Test
    public void replace() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("123"));
        roleStore.replace("123", new Role("124"));
        assertThat(roleStore.findById("124").getId(), is("124"));
    }

    @Test
    public void delete() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("123"));
        roleStore.add(new Role("124"));
        roleStore.add(new Role("125"));
        roleStore.delete("124");
        assertNull(roleStore.findById("124").getId(), (null));
        assertThat(roleStore.findById("123").getId(), is("123"));
        assertThat(roleStore.findById("125").getId(), is("125"));
    }
}