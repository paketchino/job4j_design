package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.IllegalFormatException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class GeneratorTest {

    @Ignore
    @Test
    public void whenNeedToCheckPhase() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> storageMap = new HashMap<>();
        storageMap.put("name", "Evgen");
        storageMap.put("subject", "you");
        String excepted = "I am a Evgen, Who are you?";
        PhaseGeneration pg = new PhaseGeneration();
        assertThat(pg.produce(template, storageMap), is(excepted));
    }

    @Ignore
    @Test(expected = NoSuchElementException.class)
    public void whenNeedToCallNoSuchElementException() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> storageMap = new HashMap<>();
        storageMap.put("project", "Amazon");
        storageMap.put("input", "Computer");
        PhaseGeneration pg = new PhaseGeneration();
        pg.produce(template, storageMap);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenNeedToCallIllegalArgumentException() {
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> storageMap = new HashMap<>();
        storageMap.put("project", "Amazon");
        storageMap.put("input", "Computer");
        storageMap.put("name", "Evgen");
        storageMap.put("subject", "you");
    }
}