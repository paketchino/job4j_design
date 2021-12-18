package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CinemaTest {

    @Ignore
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new ImplAccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new ImplTicket()));
    }

    @Ignore
    @Test
    public void find() {
        Cinema cinema = new ImplAccountCinema();
        cinema.add(new Session3d());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3d())));
    }

    @Ignore
    @Test
    public void whenNeedToCheckCreateAcc() {
        Account account = new AccountCinema();
        assertNotNull(account);
    }

    @Ignore
    @Test
    public void whenNeedToCheckDateAndPlaceBusyInSession() {
        Account account = new AccountCinema();
        Cinema cinema = new ImplAccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);

    }
}
