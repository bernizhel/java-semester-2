package ru.vsuet.matrices.integer_matrix.impl;

import ru.vsuet.matrices.integer_matrix.interfaces.FillingStrategy;
import ru.vsuet.matrices.integer_matrix.interfaces.Matrix;

public class IntegerMatrix {
    private final int[][] matrix;
    private final FillingStrategy fillingStrategy;

    public IntegerMatrix(int rows, int columns, FillingStrategy fillingStrategy) {
        this.matrix = new int[rows][columns];
        this.fillingStrategy = fillingStrategy;
    }

    public IntegerMatrix(int size, FillingStrategy fillingStrategy) {
        this(size, size, fillingStrategy);
    }

    public void fill() {
        fillingStrategy.generate(matrix);
    }

    public int getSumAboveMainDiagonal() {
        int result = 0;
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = rowIndex + 1; columnIndex < matrix[rowIndex].length; columnIndex++) {
                result += matrix[rowIndex][columnIndex];
            }
        }

        return result;
    }

    public int getProductOfMainDiagonal() {
        int result = 1;
        for (int rowIndex = 0; rowIndex < matrix.length && rowIndex < matrix[rowIndex].length; rowIndex++) {
            result *= matrix[rowIndex][rowIndex];
        }

        return result;
    }

    public int getNegativeSumBelowMainDiagonal() {
        int result = 0;
        for (int rowIndex = 1; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < rowIndex && columnIndex < matrix[rowIndex].length; columnIndex++) {
                result += matrix[rowIndex][columnIndex];
            }
        }

        result = -result;
        return result;
    }

    @Override
    public String toString() {
        int longestLength = getLongestNumber().length();
        StringBuilder matrixRepresentation = new StringBuilder();

        for (int[] row : matrix) {
            matrixRepresentation.append("[ ");
            for (int number : row) {
                String formattedNumber = String.format("%" + longestLength + "s", number);
                matrixRepresentation.append(formattedNumber);
                matrixRepresentation.append(" ");
            }
            matrixRepresentation.append("]\n");
        }

        int lastNewLineIndex = matrixRepresentation.length() - 1;
        matrixRepresentation.deleteCharAt(lastNewLineIndex);
        return matrixRepresentation.toString();
    }

    private String getLongestNumber() {
        String longestNumber = "";
        for (int[] row : matrix) {
            for (int number : row) {
                String numberAsString = Integer.toString(number);
                longestNumber = longestNumber.length() > numberAsString.length() ? longestNumber : numberAsString;
            }
        }

        return longestNumber;
    }
}
