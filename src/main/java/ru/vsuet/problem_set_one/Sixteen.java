package ru.vsuet.problem_set_one;

import java.util.Scanner;

public class Sixteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the line: ");
        String line = scanner.nextLine();

        long countUppercase = line.chars()
                .mapToObj(i -> (char)i)
                .filter((c) -> c == Character.toUpperCase(c))
                .count();

        long countLowercase = line.chars()
                .mapToObj(i -> (char)i)
                .filter((c) -> c == Character.toLowerCase(c))
                .count();

        String result = "";
        if (countUppercase > countLowercase) {
            result = line.toUpperCase();
        } else {
            result = line.toLowerCase();
        }

        System.out.println("Result: " + result);
    }
}
