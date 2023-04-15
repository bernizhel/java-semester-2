package ru.vsuet.problem_set_one;

import java.util.*;

public class Fifteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the line: ");
        String line = scanner.nextLine();

        String[] words = line.split(" ");
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        String result = String.join(" ", uniqueWords);
        System.out.println(result);
    }
}
