package ru.job4j.generics;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.NoSuchElementException;

public class SimpleArrayTest {

    @Test
    public void whenGetArray() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(1);
        simpleArray.add(1);
        simpleArray.add(1);
        Integer[] expected = new Integer[]{1, 1, 1, 1, null};
        assertThat(simpleArray.getArray(), is(expected));
    }

    @Test
    public void whenAdd() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(1);
        assertThat(simpleArray.add(1), is(true));
    }

    @Test
    public void whenAddGetArray() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        Integer[] expected = new Integer[]{1, 2, 3, null, null};
        assertThat(simpleArray.getArray(), is(expected));
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
    public void whenSetGetArray() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.set(1, 10);
        Integer[] expected = new Integer[]{1, 10, 3, null, null};
        assertThat(simpleArray.getArray(), is(expected));
    }

    @Test
    public void whenRemove() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        simpleArray.add(2);
        assertThat(simpleArray.remove(0), is(true));
    }

    @Test
    public void whenRemoveGetArray() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.remove(1);
        Integer[] expected = new Integer[]{1, 3, 4, null, null};
        assertThat(simpleArray.getArray(), is(expected));
    }

    @Test
    public void whenGet() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(2);
        simpleArray.add(1);
        simpleArray.add(2);
        assertThat(simpleArray.get(0), is(1));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmptyThanGet() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(0);
        simpleArray.get(0);
    }
}