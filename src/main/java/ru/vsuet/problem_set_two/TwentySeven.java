package ru.vsuet.problem_set_two;

import java.util.Scanner;

public class TwentySeven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int shift = scanner.nextInt();
        String direction = scanner.next();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (direction.equals("right")) {
                    c = (char) ((c - 'a' + shift) % 26 + 'a');
                } else if (direction.equals("left")) {
                    c = (char) ((c - 'a' - shift + 26) % 26 + 'a');
                }
            }
            result.append(c);
        }

        System.out.println(result);
    }
}
