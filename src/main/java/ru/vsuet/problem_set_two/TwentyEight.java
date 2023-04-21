package ru.vsuet.problem_set_two;

import java.util.Scanner;

public class TwentyEight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int x = (int) Math.sqrt(n); // находим ближайший квадрат числа, меньший чем n
        int y = x + 1; // следующий квадрат числа

        int diff = y * y - x * x; // разница между двумя последовательными квадратами числа

        if (diff == n) {
            System.out.println(x * x + " " + y * y);
        } else {
            System.out.println("Invalid input");
        }
    }
}
