package ru.job4j.io.output;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "out";
    private static final String STOP = "stop";
    private static final String CONTINUE = "continue";
    private final List<String> log = new ArrayList<>();
    private final List<String> fileBot = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    private List<String> readPhrases(String path) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path, Charset.forName("Windows-1251")))) {
                reader.lines().forEach(sb::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileBot;
    }

    private void writeDateInFile(String path, List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("Windows-1251")))) {
            for (String datum : log) {
                pw.println(datum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String randomWords() {
        int randomIndex = (int) (Math.random() * fileBot.size() - 1);
        return fileBot.get(randomIndex);
    }


    public void run() {
        System.out.println("Enter a phrases");
        boolean botCanAnswer = true;
        Scanner sc = new Scanner(System.in);
        String question = sc.nextLine();
        readPhrases(fileBot.toString());
        while (!question.equals(OUT)) {
            randomWords();
            if (question.equals(STOP)) {
                botCanAnswer = false;
            }
            if (!botCanAnswer) {
                log.add(question);
            }
            writeDateInFile(question, log);
            question = sc.nextLine();
        }
    }


    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("dialogWithBot.txt","./data/botFile.txt");
        cc.run();
    }
}
