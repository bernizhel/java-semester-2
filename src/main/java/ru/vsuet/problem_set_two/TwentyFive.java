package ru.vsuet.problem_set_two;

import java.util.Scanner;

public class TwentyFive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] divisors = new int[args.length - 2];
        for (int i = 2; i < args.length; i++) {
            divisors[i - 2] = Integer.parseInt(args[i]);
        }

        int sum = 0;
        boolean divisible;
        for (int i = m; i <= n; i++) {
            divisible = true;
            for (int divisor : divisors) {
                if (i % divisor != 0) {
                    divisible = false;
                    break;
                }
            }
            if (divisible) {
                sum += i;
            }
        }

        System.out.println(sum);
    }
}
