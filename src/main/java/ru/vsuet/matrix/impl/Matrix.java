package ru.vsuet.matrix.impl;

import ru.vsuet.matrix.interfaces.FillingStrategy;

public class Matrix {
    private final int[][] matrix;

    public Matrix(int rows, int columns) {
        this.matrix = new int[rows][columns];
    }

    public Matrix(int size) {
        this(size, size);
    }

    public void fill(FillingStrategy fillingStrategy) {
        fillingStrategy.generate(matrix);
    }

    public int sumAboveMainDiagonal() {
        int result = 0;
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = rowIndex + 1; columnIndex < matrix[rowIndex].length; columnIndex++) {
                result += matrix[rowIndex][columnIndex];
            }
        }

        return result;
    }

    public int productOfMainDiagonal() {
        int result = 1;
        for (int rowIndex = 0; rowIndex < matrix.length && rowIndex < matrix[rowIndex].length; rowIndex++) {
            result *= matrix[rowIndex][rowIndex];
        }

        return result;
    }

    public int negativeSumBelowMainDiagonal() {
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
        int longestLength = findLongest().length();
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

        return matrixRepresentation.toString();
    }

    private String findLongest() {
        String longest = "";
        for (int[] row : matrix) {
            for (int number : row) {
                longest = longest.length() > Integer.toString(number).length() ? longest : Integer.toString(number);
            }
        }

        return longest;
    }
}
