package ru.job4j.tdd;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class CinemaTest {

    @Ignore
    @Test
    public void whenBuyTicket() {
        Account account = new AccountCinema();
        Cinema cinema = new ImplAccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new ImplTicket()));
    }

    @Ignore
    @Test
    public void whenFindSession() {
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
    @Test(expected = IllegalArgumentException.class)
    public void whenNeedToBuyTicketInvalidDate() {
        Account account = new AccountCinema();
        Cinema cinema = new ImplAccountCinema();
        Calendar date = Calendar.getInstance();
        date.set(2020, -10, -10, 23, 00);
    }

    @Ignore
    @Test (expected = IllegalArgumentException.class)
    public void whenBuyTicketOnBusyPlace() {
        Account account = new AccountCinema();
        Cinema cinema = new ImplAccountCinema();
        Calendar dateOne = Calendar.getInstance();
        Calendar dateSecond = Calendar.getInstance();
        dateOne.set(2020, 10, 10, 23, 00);
        dateSecond.set(2020, 10, 10, 23, 00);
    }

    @Ignore
    @Test
    public void whenNeedToCreateSession() {
        Cinema cinema = new ImplAccountCinema();
        cinema.add(new Session3d());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3d())));
    }

    @Ignore
    @Test
    public void whenNeedToAddSessionToList() {
        Session session = new Session3d();
        List<Session> sessions = new ArrayList<>();
        sessions.add(session);
        assertThat(sessions, is(Arrays.asList(new Session3d())));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenCreateTwoSession() {
        List<Session> sessions = new ArrayList<>();
        sessions.add(new Session3d());
        sessions.add(new Session3d());
    }
}
