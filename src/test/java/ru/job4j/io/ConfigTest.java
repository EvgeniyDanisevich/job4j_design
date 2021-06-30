package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("name"),
                is("Petr Arsentev")
        );
    }

    @Test
    public void whenPairWithComment() {
        String path = "data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.dialect"),
                is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.url"),
                is("jdbc:postgresql://localhost:5432/idea_db"));
        assertThat(config.value("hibernate.connection.driver_class"),
                is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"),
                is("postgres"));
        assertThat(config.value("hibernate.connection.password"),
                is("postgres"));
    }

    @Test
    public void whenOnlyComment() {
        String path = "data/with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("this"),
                is("notAComment")
        );
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNoValue() {
        String path = "data/illegal_format.properties";
        Config config = new Config(path);
        config.load();
        config.value("name");
    }
}