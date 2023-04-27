package ru.vsuet.my_matrix.generic;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Matrix<N extends Number> {
    private final N[][] matrix;
    private final N constantValue;

    public Matrix(N constantValue, int size) throws ClassCastException {
        this.matrix = (N[][])Array.newInstance(constantValue.getClass(), size, size);
        this.constantValue = constantValue;
    }

    public void fill() {
//        try {
//            Constructor<? extends Number> valueConstructor = constantValue.getClass().getDeclaredConstructor(constantValue.getClass());
//            valueConstructor.newInstance();
//        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
//            return;
//        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; i < matrix[i].length; j++) {
                matrix[i][j] = constantValue;
            }
        }
    }

    public N[][] getMatrix() {
        return this.matrix;
    }

    public static Integer getSumAboveMainDiagonal(Integer[][] matrix) {
        int result = 0;
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = rowIndex + 1; columnIndex < matrix[rowIndex].length; columnIndex++) {
                result += matrix[rowIndex][columnIndex];
            }
        }

        return result;
    }

    public static Integer getProductOfMainDiagonal(Integer[][] matrix) {
        int result = 1;
        for (int rowIndex = 0; rowIndex < matrix.length && rowIndex < matrix[rowIndex].length; rowIndex++) {
            result = result * matrix[rowIndex][rowIndex];
        }

        return result;
    }

    public static Integer getNegativeSumBelowMainDiagonal(Integer[][] matrix) {
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

        for (N[] row : matrix) {
            matrixRepresentation.append("[ ");
            for (N number : row) {
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
        for (N[] row : matrix) {
            for (N number : row) {
                String displayedNumber = number.toString();
                longestNumber = longestNumber.length() > displayedNumber.length() ? longestNumber : displayedNumber;
            }
        }

        return longestNumber;
    }
}
