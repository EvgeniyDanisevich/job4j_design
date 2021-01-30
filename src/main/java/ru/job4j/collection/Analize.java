package ru.job4j.collection;

import java.util.List;
import java.util.Objects;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        for (User user : previous) {
            if (!current.contains(user)) {
                info.deleted++;
            } else if (current.contains(user)
                    && !user.name.equals(current.get(current.indexOf(user)).name)) {
                info.changed++;
            }
        }
        for (User user : current) {
            if (!previous.contains(user)) {
                info.added++;
            }
        }
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        @Override
        public String toString() {
            return "added=" + added
                    + ", changed=" + changed
                    + ", deleted=" + deleted;
        }
    }

}