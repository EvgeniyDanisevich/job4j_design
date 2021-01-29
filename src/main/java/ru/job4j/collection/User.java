package ru.job4j.collection;

import java.util.*;

public class User {
    private String name;
    private int children;
//    private Calendar birthday;

    public User(String name, int children) {
        this.name = name;
        this.children = children;
//        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children);
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
        return children == user.children
                && Objects.equals(name, user.name);
    }

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        User first = new User("Иван", 2);
        User second = new User("Иван", 2);
        User third = new User("Иван", 2);

        Map<User, Object> map = new HashMap<>();
        map.put(third, 3);
        map.put(first, 1);
        map.put(second, 2);

        System.out.println(map.toString());

        System.out.println((2 + 4 + 2 + 3 + 5 + 2 + 5 + 2 + 9) % 32);

        System.out.println(binary(242352529));
        System.out.println(binary(242352529 >>> 16));
        System.out.println(242352529 ^ (242352529 >>> 16));
        System.out.println(binary(242356195));
        System.out.println(binary(31));
        System.out.println(31 & 242356195);
    }
}
