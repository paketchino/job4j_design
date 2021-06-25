package ru.job4j.io.output;
//
import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "out";
    private static final String STOP = "stop";
    private static final String CONTINUE = "continue";
    private final List<String> log = new ArrayList<>();
    private final List<String> fileBot = new ArrayList<>();
    int count;


    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    private List<String> readPhrases() {
        try (BufferedReader reader = new BufferedReader(new FileReader(this.botAnswers, Charset.forName("Windows-1251")))) {
            String read;
            while ((read = reader.readLine()) != null) {
                fileBot.add(read);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileBot;
    }

    private void writeDateInFile(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, Charset.forName("Windows-1251")))) {
            for (String datum : log) {
                pw.println(datum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String randomWords() {
        int randomIndex = (int) (Math.random() * count);
        return fileBot.get(randomIndex);
    }

    public void run() {
        System.out.println("Enter a phrases");
        boolean botCanAnswer = true;
        Scanner sc = new Scanner(System.in);
        String question = sc.nextLine();
        readPhrases();
        while (!question.equals(OUT)) {
            String phrases = randomWords();
            if (question.equals(STOP)) {
                botCanAnswer = false;
            }
            if (question.equals(CONTINUE)) {
                botCanAnswer = true;
                log.add(question);
            }
            if (botCanAnswer) {
                System.out.println(phrases);
                log.add(question);
            }
            question = sc.nextLine();
        }
        writeDateInFile(log);
    }


    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/dialogWithBot.txt","./data/botFile.txt");
        cc.run();
    }
}
