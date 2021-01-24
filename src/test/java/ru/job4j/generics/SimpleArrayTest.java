package ru.job4j.generics;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;
import ru.job4j.collection.SimpleArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayTest {

    @Test
    public void whenAdd() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(1);
        assertThat(simpleArray.add(1), is(true));
    }

    @Test
    public void whenSet() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        assertThat(simpleArray.set(1, 10), is(true));
    }

    @Test
    public void whenRemove() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        simpleArray.add(2);
        assertThat(simpleArray.remove(0), is(true));
    }

    @Test
    public void whenGet() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        simpleArray.add(2);
        assertThat(simpleArray.get(0), is(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenEmptyThanGet() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(0);
        simpleArray.get(0);
    }

    @Test
    public void whenHasNextAndNext() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        simpleArray.add(2);
        Iterator<Integer> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(2));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenAddAndAdd() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        Iterator<Integer> iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
        simpleArray.add(1);
        iterator = simpleArray.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(1));
        assertThat(iterator.hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextNullException() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.iterator().next();
    }
}