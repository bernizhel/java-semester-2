package ru.vsuet.problem_set_one;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Thirteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("First: ");
        int first = Integer.parseInt(scanner.nextLine());
        System.out.print("Step: ");
        int step = Integer.parseInt(scanner.nextLine());
        System.out.print("Count: ");
        int count = Integer.parseInt(scanner.nextLine());

        System.out.println("The row is: " + getRow(first, step, count));
    }

    public static String getRow(int first, int step, int count) {
        List<Integer> squares = new ArrayList<>();
        for (int i = first; i < first + step * count; i += step) {
            squares.add(i);
        }

        List<String> squaresStrings = squares.stream().map(Object::toString).toList();

        return String.join(" ", squaresStrings);
    }
}
