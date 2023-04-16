package ru.vsuet.problem_set_one;

import java.util.Arrays;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        System.out.println("Initializing points:");
        double[][] points = getPointsFromUserInput();

        double[] barycenter = calculateBarycenterCoordinates(points);
        System.out.printf("Barycenter: [%.4f, %.4f]%n", barycenter[0], barycenter[1]);
    }

    private static double[][] getPointsFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        String pointsString = scanner.nextLine();
        pointsString = pointsString.substring(2, pointsString.length() - 2);

        String[] pointsStrings = pointsString.split("], ");
        for (int i = 1; i < pointsStrings.length; i++) {
            pointsStrings[i] = pointsStrings[i].substring(1);
        }
        String[][] pointsWrapperStrings = Arrays.stream(pointsStrings).map((s) -> s.split(", ")).toArray(String[][]::new);
        Double[][] pointsWrapper = Arrays.stream(pointsWrapperStrings).map((arr) -> new Double[] {Double.parseDouble(arr[0]), Double.parseDouble(arr[1]) } ).toArray(Double[][]::new);

        double[][] points = new double[pointsWrapper.length][2];

        for (int i = 0; i < pointsWrapper.length; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = pointsWrapper[i][j];
            }
        }

        return points;
    }

    private static double[] calculateBarycenterCoordinates(double[][] points) {
        double sumX = 0;
        double sumY = 0;
        for (double[] point : points) {
            sumX += point[0];
            sumY += point[1];
        }

        return new double[] { sumX / 3, sumY / 3};
    }
}
