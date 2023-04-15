package ru.vsuet.my_first_program;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        if (args.length == 0) {
            System.out.println("There is no args");
        }

        for (int i = 0; i < args.length; i++) {
            System.out.printf("%d. arg %d - %s%n", i + 1, i + 1, args[i]);
        }
    }
}
