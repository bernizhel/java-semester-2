package ru.vsuet.problem_set_one;

import java.util.Scanner;

public class Ten {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String unprocessedName = scanner.nextLine();

        String name = unprocessedName.toLowerCase();
        name = name.substring(0, 1).toUpperCase() + name.substring(1);

        System.out.println("Hello, " + name + "!");
    }
}
