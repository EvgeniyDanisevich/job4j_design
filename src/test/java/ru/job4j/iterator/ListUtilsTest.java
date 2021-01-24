package ru.job4j.iterator;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addAfter(input, 1, 2);
        assertThat(Arrays.asList(1, 3, 2), Is.is(input));
    }

    @Test
    public void whenAddAndRemove() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 2, 1));
        Predicate<Integer> predicate = integer -> integer > 3;
        ListUtils.removeIf(input, predicate);
        assertThat(Arrays.asList(1, 2, 3, 2, 1), Is.is(input));
    }

    @Test
    public void whenAddAndReplace() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Predicate<Integer> predicate = integer -> integer > 3;
        ListUtils.replaceIf(input, predicate, 0);
        assertThat(Arrays.asList(1, 2, 3, 0, 0), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        List<Integer> elements = new ArrayList<>(Arrays.asList(2, 4));
        ListUtils.removeAll(input, elements);
        assertThat(Arrays.asList(1, 3, 5), Is.is(input));
    }
}