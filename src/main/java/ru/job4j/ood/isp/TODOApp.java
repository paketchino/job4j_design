package ru.job4j.ood.isp;


import ru.job4j.ood.isp.wrongisp.Message;
import ru.job4j.ood.isp.wrongisp.SentMessage;

import java.io.IOException;

public class TODOApp implements SentMessage {

    public static final ActionDelegate STUB_ACTION = System.out::println;
    private final static String EXIT = "EXIT";
    private final static String ADD = "ADD";
    private final static String OUT = "OUT";
    private final static String SELECT = "SELECT";
    private SimpleMenu simpleMenu = new SimpleMenu();

    public static void main(String[] args) throws IOException {
        System.out.println("ADD");
        System.out.println("SELECT");
        System.out.println("OUT");
        System.out.println("EXIT");
        TODOApp todoApp = new TODOApp();
        String message = new String();
        Message msg = new Message(message);
        ConsoleInput input = new ConsoleInput();
        todoApp.sent(msg, input);
    }

    @Override
    public boolean sent(final Message msg, ConsoleInput input) {
        final boolean rsl;
            switch (input.askStr(msg.toString())) {
                case ADD:
                    System.out.println("Enter name parent: ");
                    String parent = input.askStr(msg.toString());
                    System.out.println("Enter child name: ");
                    String child = input.askStr(msg.toString());
                    simpleMenu.add(parent, child, STUB_ACTION);
                    rsl = true;
                    break;
                case OUT:
                    System.out.println("Output All: ");
                    System.out.println(System.lineSeparator());
                    OutPrint outPrint = new OutPrint();
                    outPrint.print(simpleMenu);
                    rsl = true;
                    break;
                case SELECT:
                    System.out.println("Enter child name: ");
                    String childSelect = input.askStr(msg.toString());
                    System.out.println(simpleMenu.select(childSelect));
                    rsl = true;
                    break;
                default:
                    System.out.println("Exit");
                    rsl = false;
                    break;
            }
            return rsl;
    }
}
