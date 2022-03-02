package ru.job4j.clone;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class AddressTest {

    @Test
    public void whenShallowCopyingThenObjectShouldNotBeSame() {
        Address address = new Address("Downing St 10", "London", "England");
        User pm = new User("Prime", "Minister", address);
        pm.setAddress(new Address("Penza", "Zarachnyi", "Russia"));
        System.out.println(pm.getAddress());
        User shallowCopy = new User(pm.getFirstName(), pm.getLastName(), pm.getAddress());
        System.out.println(shallowCopy.getAddress());
        assertThat(shallowCopy.equals(pm), is(false));
    }

    @Test
    public void whenModifyingOriginalObjectThenCopyShouldNotChange() {
        Address address = new Address("Downing St 10", "London", "England");
        User pm = new User("Prime", "Minister", address);
        System.out.println(address.getCountry() + "\r\n");
        System.out.println(pm.getAddress());
        User deepCopy = new User(pm);
        address.setCountry("Great Britain");
        pm.setAddress(new Address("Penza", "Zarachnyi", "Russia"));
        System.out.println(address.getCountry());
        System.out.println(deepCopy.getAddress());
        System.out.println(pm.getAddress());
        assertNotEquals(pm.getAddress().getCountry(),
                deepCopy.getAddress().getCountry());
    }

}