package ru.job4j.collection;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AnalizeTest {

    @Test
    public void whenOneAddOneChangeOneDelete() {
        List<Analize.User> previous = Arrays.asList(
                new Analize.User(1, "Bob"),
                new Analize.User(2, "Bill")
        );
        List<Analize.User> current = Arrays.asList(
                new Analize.User(2, "Jack"),
                new Analize.User(3, "Tom")
        );
        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.toString(), is("added=1, changed=1, deleted=1"));
    }

    @Test
    public void whenTwoAddOneChangeTwoDelete() {
        List<Analize.User> previous = Arrays.asList(
                new Analize.User(1, "Bob"),
                new Analize.User(2, "Bill"),
                new Analize.User(3, "George"),
                new Analize.User(4, "William")
        );
        List<Analize.User> current = Arrays.asList(
                new Analize.User(3, "George"),
                new Analize.User(4, "Mark"),
                new Analize.User(5, "Jack"),
                new Analize.User(6, "Tom")
        );
        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.toString(), is("added=2, changed=1, deleted=2"));
    }

    @Test
    public void whenNoChanges() {
        List<Analize.User> previous = Arrays.asList(
                new Analize.User(1, "Bob"),
                new Analize.User(2, "Bill")
        );
        List<Analize.User> current = Arrays.asList(
                new Analize.User(1, "Bob"),
                new Analize.User(2, "Bill")
        );
        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.toString(), is("added=0, changed=0, deleted=0"));
    }
}