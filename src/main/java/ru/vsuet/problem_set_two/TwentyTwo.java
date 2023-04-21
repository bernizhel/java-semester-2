package ru.vsuet.problem_set_two;

public class TwentyTwo {
    public static void main(String[] args) {
        double area = calculateArea(3, 4, 5); // Returns 6
        System.out.println(area);
    }

    public static double calculateArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        return area;
    }
}
