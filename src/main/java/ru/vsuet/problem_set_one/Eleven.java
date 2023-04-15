package ru.vsuet.problem_set_one;

import java.util.Scanner;

public class Eleven {
    private static final String VOWELS = "aeiouаоиыуэяюёеAEIOUАОИЫУЭЯЮЁЕ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String unprocessedString = scanner.nextLine();

        String string = deleteVowels(unprocessedString);

        System.out.println("The result: " + string);
    }

    public static String deleteVowels(String string) {
        final String[] result = {""};
        string.chars().forEach((c) -> {
            if (!VOWELS.contains(Character.toString(c))) {
                result[0] += Character.toString(c);
            }
        });

        return result[0];
    }
}
