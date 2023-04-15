package ru.vsuet.problem_set_one;

import java.util.Scanner;

public class Seven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = scanner.nextInt();

        System.out.println("Closest one is: " + getClosestSquaredNumber(n));
    }

    public static long getClosestSquaredNumber(int n) {
        return Math.round(Math.sqrt(n));
    }
}
