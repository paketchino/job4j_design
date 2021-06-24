package ru.job4j.io.output;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String str = "apple";
        char s = 'f';
        double b = 3.0;
        float d = 3.0f;
        int i = 1231;
        long l = 217567563;
        boolean rsl = false;
        short c = 1;
        LOG.trace("trace message");
        LOG.debug("info str : {}, s : {}, b : {}, d : {}, i : {}, l : {}, rsl : {}, c : {}", str, s, b, d, i, l, rsl, c);
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
