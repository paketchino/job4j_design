package ru.job4j.io.output.scanner;

import java.io.ByteArrayInputStream;
import java.io.CharArrayReader;
import java.util.Scanner;

public class ExampleDelimiter3 {
        public static void main(String[] args) {
            String ls  = System.lineSeparator();
            var data = String.join(ls,
                    "1 2 3",
                    "4 5 6",
                    "7 8 9"
            );
            var scanner = new Scanner(new CharArrayReader(data.toCharArray()));
            while (scanner.hasNextInt()) {
                System.out.print(scanner.nextInt());
                System.out.print(" ");
            }
        }
        }
