package ru.job4j.io.output;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;

public class AnalizeTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void unavailable() throws IOException {
        File source = folder.newFile("status_data.txt");
        File target = folder.newFile("result.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("200 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        } catch (Exception e) {
            e.printStackTrace();
        }
            Analize analize = new Analize();
            analize.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
            StringBuilder sb = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new FileReader(target))) {
                in.lines().forEach(sb::append);
            } catch (Exception e) {
                e.printStackTrace();
            }
            assertThat(sb.toString(), is("10:58:01;10:59:01;11:01:02;11:02:02;"));
    }
}