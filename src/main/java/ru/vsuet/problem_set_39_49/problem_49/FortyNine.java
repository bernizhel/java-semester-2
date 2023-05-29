package ru.vsuet.problem_set_39_49.problem_49;

import java.util.Scanner;

public class FortyNine {
    public static int fusc(int number) {
        if (number == 0) return 0;  // уравнение fusc(0) = 0
        if (number == 1) return 1;  // уравнение fusc(1) = 1

//
//        int a = 0, b = 1;
//        int i = n / 2;
//
//        while (i > 0) {
//            int temp = a;
//            a = b;
//            b = temp + b;
//            i = i / 2;
//        }
//

        int n = number / 2;
        if (number % 2 == 0) {
            return fusc(n);  // уравнение fusc(2n) = fusc(n)
        } else {
            return fusc(n) + fusc(n + 1);  // уравнение fusc(2n + 1) = fusc(n) + fusc(n + 1)
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int n = scanner.nextInt();
        int result = fusc(n);
        System.out.println("fusc(" + n + ") = " + result);
    }
}
