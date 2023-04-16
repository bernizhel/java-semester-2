package ru.vsuet.problem_set_one;

import java.util.Arrays;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        System.out.println("Initializing visitors:");
        boolean[] VISITORS = getVisitorsFromUserInput();
        System.out.println("Initial visitors array:");
        System.out.println(getStringRepresentation(VISITORS));

        int employeesCount = getEmployeesCount(VISITORS);
        System.out.printf("Employees count: %d%n", employeesCount);
    }

    private static boolean[] getVisitorsFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        String visitorsString = scanner.nextLine();
        visitorsString = visitorsString.substring(1, visitorsString.length() - 1);

        String[] visitorsStrings = visitorsString.split(", ");
        Boolean[] visitorsWrapper = Arrays.stream(visitorsStrings).map(Integer::parseInt).map((integer) -> integer == 1).toArray(Boolean[]::new);

        boolean[] visitors = new boolean[visitorsWrapper.length];
        for (int i = 0; i < visitorsWrapper.length; i++) {
            visitors[i] = visitorsWrapper[i];
        }

        return visitors;
    }

    private static int getEmployeesCount(boolean[] visitors) {
        int employeesCount = 0;

        for (boolean visitor : visitors) {
            if (visitor) {
                employeesCount++;
            }
        }

        return employeesCount;
    }

    private static String getStringRepresentation(boolean[] visitors) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[ ");
        for (boolean visitor : visitors) {
                stringBuilder.append(visitor);
                stringBuilder.append(" ");
        }
        stringBuilder.append("]\n");

        return stringBuilder.toString();
    }
}
