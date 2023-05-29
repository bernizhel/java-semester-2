package ru.vsuet.problem_set_39_49.problem_48;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FortyEight {
    public static void main(String[] args) {
        Set<Integer> uSeries = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение x: ");
        int x = scanner.nextInt();

        int u0 = 1;
        uSeries.add(u0);

        for (int i = 1; i <= x; i++) {
            int y = 2 * i + 1;
            int z = 3 * i + 1;
            uSeries.add(y);
            uSeries.add(z);
        }

        System.out.println("Ряд чисел u без дубликатов:");
        for (int num : uSeries) {
            System.out.print(num + " ");
        }
    }
}
