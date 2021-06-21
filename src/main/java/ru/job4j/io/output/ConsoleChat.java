package ru.job4j.io.output;

import java.io.*;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "out";
    private static final String STOP = "stop";
    private static final String CONTINUE = "continue";
    private List<String> fileBot;
    private List<String> log;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }


    private void readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers,Charset.forName("Windows-1251")))) {
            String read;
            while ((read = br.readLine()) != null) {
                fileBot.add(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeDateInFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("Windows-1251")))) {
            log.forEach(pw::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String randomIndex() {
        int randomIndex = (int) (Math.random() * fileBot.size() - 1);
        return fileBot.get(randomIndex);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean botCanAnswer = true;
        readFile();
        while (!sc.nextLine().equals(OUT)) {
            String question = sc.nextLine();
            if (question.equals(STOP)) {
                botCanAnswer = false;
                log.add(question);
            }
            if (question.equals(CONTINUE)) {
                botCanAnswer = true;
                log.add(question);
            }
            if (botCanAnswer) {
                randomIndex();
                System.out.println(botAnswers);
                log.add(botAnswers);
            }
            writeDateInFile();
        }
    }


    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("dialogWithBot.txt","./data/botFile.txt");
        cc.run();
    }
}
