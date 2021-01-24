package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedListTest {

    @Test
    public void whenAddThenGet() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.add("first");
        array.add("second");
        array.add("third");
        String rsl = array.get(0);
        String rsl2 = array.get(1);
        String rsl3 = array.get(2);
        assertThat(rsl, is("first"));
        assertThat(rsl2, is("second"));
        assertThat(rsl3, is("third"));
    }

    @Test
    public void whenAddThenIt() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.add("first");
        array.add("second");
        array.add("third");
        Iterator<String> it = array.iterator();
        String rsl = it.next();
        String rsl2 = it.next();
        String rsl3 = it.next();
        assertThat(rsl, is("first"));
        assertThat(rsl2, is("second"));
        assertThat(rsl3, is("third"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.add("first");
        array.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinkedList<String> array = new SimpleLinkedList<>();
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }
}