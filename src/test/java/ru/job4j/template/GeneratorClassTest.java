package ru.job4j.template;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class GeneratorClassTest {

    @Test
    public void whenCorrectInput() {
        String template = "I am a ${name}, who are ${subject}?";
        Map<String, String> values = new HashMap<>();
        values.put("name", "Petr Arsentev");
        values.put("subject", "you");
        String actual = new GeneratorClass().produce(template, values);
        String expected = "I am a Petr Arsentev, who are you?";
        assertEquals(expected, actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenIncorrectKeysInMap() {
        String template = "I am a ${name}, who are ${subject}?";
        Map<String, String> values = new HashMap<>();
        values.put("name", "Petr Arsentev");
        values.put("email", "example@example.com");
        String actual = new GeneratorClass().produce(template, values);
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenIncorrectKeysInTemplate() {
        String template = "I am a ${name}, my e-mail is ${email}?";
        Map<String, String> values = new HashMap<>();
        values.put("name", "Petr Arsentev");
        values.put("subject", "you");
        String actual = new GeneratorClass().produce(template, values);
    }
}