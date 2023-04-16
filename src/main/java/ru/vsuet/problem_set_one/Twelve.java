package ru.vsuet.problem_set_one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Twelve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First: ");
        int first = Integer.parseInt(scanner.nextLine());
        System.out.print("Second: ");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("The row is: " + getRow(first, second));
    }

    public static String getRow(int a, int b) {
        int minimum = Math.min(a, b);
        int maximum = Math.max(a, b);
        List<Integer> squares = new ArrayList<>();

        for (int i = minimum; i <= maximum; i += minimum) {
            squares.add(i * i);
        }

        List<String> squaresStrings = squares.stream().map(Object::toString).toList();

        return String.join(" ", squaresStrings);
    }
}
