package ru.vsuet.problem_set_one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Five {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        String lineOfNumbers = scanner.nextLine();
        Arrays.stream(lineOfNumbers.split(" ")).forEach((string) -> numbers.add(Integer.parseInt(string)));

        System.out.printf("Sum of squares: %d%n", getSquaresSum(numbers));
    }

    public static int getSquaresSum(List<Integer> numbers) {
        int total = 0;
        for (Integer number : numbers) {
            total += number * number;
        }

        return total;
    }
}
