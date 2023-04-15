package ru.vsuet.problem_set_one;

import java.util.Scanner;

public class One {
    private static int[][] MATRIX;

    public static void main(String[] args) {
        System.out.println("Initializing matrix:");
        MATRIX = getMatrixFromUserInput();
        System.out.println("Initial matrix:");
        System.out.println();
        System.out.println(getStringRepresentation(MATRIX));

        int[][] TRANSPOSED_MATRIX = getTransposedMatrix(MATRIX);
        System.out.println("Transposed matrix:");
        System.out.println(getStringRepresentation(TRANSPOSED_MATRIX));
    }

    private static int[][] getMatrixFromUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Rows count: ");
        int rows = scanner.nextInt();
        System.out.print("Columns count: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                System.out.printf("matrix[%d][%d]: ", row, column);
                matrix[row][column] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] getTransposedMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];

        for (int row = 0; row < MATRIX.length; row++) {
            for (int column = 0; column < MATRIX[row].length; column++) {
                transposedMatrix[column][row] = MATRIX[row][column];
            }
        }

        return transposedMatrix;
    }

    private static String getStringRepresentation(int[][] matrix) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int[] rows : matrix) {
            stringBuilder.append("[ ");
            for (int number : rows) {
                stringBuilder.append(number);
                stringBuilder.append(" ");
            }
            stringBuilder.append("]\n");
        }

        return stringBuilder.toString();
    }
}
