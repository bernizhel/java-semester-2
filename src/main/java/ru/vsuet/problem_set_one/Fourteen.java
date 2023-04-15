package ru.vsuet.problem_set_one;

import java.util.Scanner;

public class Fourteen {
    public static void main(String[] args) {
        Address test = new Address();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter numbers separated by new lines. If you're done, print something else");
        while (true) {
            try {
                int next = Integer.parseInt(scanner.nextLine());
                test.add(next);
            } catch (NumberFormatException e) {
                break;
            }
        }

        String stringBuilder = "Result: " +
                test.get(0) +
                ", " +
                test.get(1) +
                ", " +
                test.get(2) +
                ".";
        System.out.println(stringBuilder);
    }

    private static class Address {
        private final Integer[] numbers = new Integer[3];

        public void add(int number) {
            Integer minNumber = Integer.MAX_VALUE;
            int minNumberIndex = 0;

            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] == null) {
                    numbers[i] = number;
                    return;
                }

                if (numbers[i] < minNumber) {
                    minNumber = numbers[i];
                    minNumberIndex = i;
                }
            }

            numbers[minNumberIndex] = number;
        }

        public int get(int index) {
            return numbers[index];
        }
    }
}