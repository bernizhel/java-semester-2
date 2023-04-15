package ru.vsuet.problem_set_one;

import java.util.Scanner;

public class Eight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first side: ");
        double s1 = scanner.nextInt();
        System.out.print("Enter the second side: ");
        double s2 = scanner.nextInt();
        System.out.print("Enter the third side: ");
        double s3 = scanner.nextInt();

        if (!canBuildTriangle(s1, s2, s3)) {
            System.out.println("Cannot build a triangle");
            return;
        }

        double a1 = calculateAngle(s1, s2, s3);
        double a2 = calculateAngle(s2, s1, s3);
        double a3 = calculateAngle(s3, s1, s2);

        double minAngle = Math.min(Math.min(a1, a2), a3);
        System.out.println("The largest outer angle is " + (180 - minAngle));
    }

    public static boolean canBuildTriangle(double s1, double s2, double s3) {
        return (s1 < s2 + s3) && (s2 < s1 + s3) && (s3 < s1 + s2);
    }

    public static double calculateAngle(double oppositeSize, double s2, double s3) {
        return Math.toDegrees(Math.acos(
                        (s2 * s2 + s3 * s3 - oppositeSize * oppositeSize)
                                / (2 * s2 * s3)
        ));
    }
}
