package ru.vsuet.problem_set_one;

import java.util.Scanner;

public class Six {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scanner.nextInt();

        if (isPrime(n)) {
            System.out.println("PRIME");
        } else {
            System.out.println("ORDINARY");
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1 || n == 2) {
            return true;
        }

        for (int i = 2; i < Math.ceil(Math.sqrt(n)) + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
