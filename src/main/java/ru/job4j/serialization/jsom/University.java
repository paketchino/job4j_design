package ru.job4j.serialization.jsom;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class University {
    private final boolean deducted;
    private final int score;
    private final String teacher;
    private final Student student;
    private final String[] subjects;

    public University(boolean deducted, int score, String teacher, Student student, String[] subjects) {
        this.deducted = deducted;
        this.score = score;
        this.teacher = teacher;
        this.student = student;
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "University{" + "deducted="
                + deducted + ", Score="
                + score + ", teacher='" + teacher
                + '\'' + ", student=" + student
                + ", subjects="
                + Arrays.toString(subjects) + '}';
    }

    public static void main(String[] args) {
        final University university = new University(false, 5, "Pert",
                new Student(20, "Roman"), new String[] {"JSOM", "JAVA"});

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(university));
        final String univesityJson =
                "{"
                        + "\"deducted\" : false,"
                        + "\"score\" :5,"
                        + "\"teacher\":\"Petr\","
                        + "\"student\":"
                            + "{"
                                + "\"age\":20"
                            + "},"
                        + "\"subjects\":"
                            + "[\"JSOM\",\"JAVA\"]"
                + "}";
        final University universityMod = gson.fromJson(univesityJson, University.class);
        System.out.println(universityMod);
    }
}
