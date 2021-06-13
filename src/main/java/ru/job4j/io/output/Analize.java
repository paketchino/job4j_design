package ru.job4j.io.output;

import java.io.*;

public class Analize {
    public void unavailable(String source, String target) {
        String add = null;
        boolean isActive = true;
        try (BufferedReader br = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(
                     new BufferedOutputStream(
                             new FileOutputStream(target)   ))) {
            String read = br.readLine();
            while (read != null) {
                if (!read.isEmpty()) {
                    String []val = read.split(" ");
                    if (val.length == 1) {
                        throw new IllegalArgumentException();
                    }
                    if (val[0].equals("400") || val[0].equals("500")) {
                        if (isActive) {
                            add = val[1];
                            isActive = false;
                        }
                    }
                    if (val[0].equals("200") || val[0].equals("300")) {
                        if (!isActive) {
                            out.printf(add + ";" + val[1] + ";");
                            isActive = true;
                        }
                    }
                }
                read = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analize analize = new Analize();
        analize.unavailable("./data/status_data.txt", "result.txt");
    }
}
