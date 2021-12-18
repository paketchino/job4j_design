package ru.job4j.exzamen;

import java.io.*;
import java.util.Arrays;

public class Example {

    public static StringWriter getAllDataFromInputStream(InputStream is) throws FileNotFoundException {
        StringWriter sw = new StringWriter();
        try (BufferedReader bf = new BufferedReader(new FileReader(String.valueOf(new FileInputStream(String.valueOf(is)))))) {
            int read;
            while ((read = bf.read()) != -1) {
                sw.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sw;
    }

}
