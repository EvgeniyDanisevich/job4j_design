package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMapTest {

    @Test
    public void whenAddThenGet() {
        SimpleHashMap<String, String> array = new SimpleHashMap<>();
        array.insert("1", "Василий");
        String rsl = array.get("1");
        assertThat(rsl, is("Василий"));
    }

    @Test
    public void whenAddThenDelete() {
        SimpleHashMap<String, String> array = new SimpleHashMap<>();
        array.insert("1", "Василий");
        assertThat(array.delete("1"), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleHashMap<String, String> array = new SimpleHashMap<>();
        array.iterator().next();
    }

    @Test
    public void whenAddThenDeleteAndAddThenNext() {
        SimpleHashMap<String, String> array = new SimpleHashMap<>();
        array.insert("1", "Андрей");
        array.delete("1");
        array.insert("2", "Николай");
        Iterator it = array.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().toString(), is("Node{key=2, value=Николай}"));
    }
}