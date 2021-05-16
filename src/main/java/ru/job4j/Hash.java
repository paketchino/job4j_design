package ru.job4j;

public class Hash {
    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(binary(123));
        System.out.println("-------");
        System.out.println(binary(123 >>> 4));
        System.out.println("-------");
        System.out.println(binary(255));
        System.out.println(binary(255 >>> 4));
        System.out.println("-------");
        System.out.println(Integer.MAX_VALUE >>> 16);
    }
}
