package ru.vsuet.problem_set_one;

import java.util.Scanner;

public class Nine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First string: ");
        String first = scanner.nextLine();
        System.out.print("Second string: ");
        String second = scanner.nextLine();

        if (isEnding(first, second)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static boolean isEnding(String first, String second) {
        return first.endsWith(second);
    }
}
