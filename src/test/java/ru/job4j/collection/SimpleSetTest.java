package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSetTest {

    @Test
    public void whenAdd() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(1);
        array.add(1);
        array.add(2);
        Iterator<Integer> it = array.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenAddAndRemove() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.remove(2);
        Iterator<Integer> it = array.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(1);
        Iterator<Integer> it = array.iterator();
        array.add(2);
        it.next();
    }
}