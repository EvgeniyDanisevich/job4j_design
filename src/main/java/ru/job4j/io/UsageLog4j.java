package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);

        byte a = 1;
        short b = 2;
        int c = 3;
        long d = 4;
        float e = 5f;
        double f = 6.0;
        char g = '7';
        boolean h = true;
        LOG.debug("byte {}, short {}, int {}, "
                + "long {}, float {}, double {}, "
                + "char {}, boolean {}",
                a, b, c, d, e, f, g, h);
    }
}