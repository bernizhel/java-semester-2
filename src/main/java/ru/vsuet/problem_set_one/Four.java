package ru.vsuet.problem_set_one;

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("String to search in: ");
        String stringToSearchIn = scanner.nextLine();

        System.out.print("Character to count: ");
        String characterToCountString = scanner.nextLine();
        char characterToCount = characterToCountString.charAt(0);

        System.out.printf("There are %d given characters in the string.", strCount(stringToSearchIn, characterToCount));
    }

    public static long strCount(String string, char character) {
        return string.chars().filter((c) -> character == c).count();
    }
}
