package ru.vsuet.my_matrix.generic;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public class Matrix<N extends Number> {
    private final Class<? extends N> instanceClass;
    private final N[][] matrix;
    private BiFunction<N, N, N> summarizer;
    private BiFunction<N, N, N> multiplier;

    @SuppressWarnings("unchecked")
    public Matrix(Class<? extends N> instanceClass, int size) {
        this.instanceClass = instanceClass;
        this.matrix = (N[][]) Array.newInstance(this.instanceClass, size, size);
    }

    public Matrix<N> addSummarizer(BiFunction<N, N, N> summarizer) {
        this.summarizer = summarizer;
        return this;
    }

    public Matrix<N> addMultiplier(BiFunction<N, N, N> multiplier) {
        this.multiplier = multiplier;
        return this;
    }

    public Matrix<N> build() {
        Objects.requireNonNull(summarizer);
        Objects.requireNonNull(multiplier);
        return this;
    }

    public void fill(N value) {
        Arrays.stream(matrix).forEach(row -> Arrays.fill(row, value));
    }

    public N getSumAboveMainDiagonal() {
        N result = getCastedNumber(0);

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = rowIndex + 1; columnIndex < matrix[rowIndex].length; columnIndex++) {
                result = summarizer.apply(result, matrix[rowIndex][columnIndex]);
            }
        }

        return result;
    }

    public N getProductOfMainDiagonal() {
        N result = getCastedNumber(1);

        for (int index = 0; index < matrix.length && index < matrix[index].length; index++) {
            result = multiplier.apply(result, matrix[index][index]);
        }

        return result;
    }

    public N getNegativeSumBelowMainDiagonal() {
        N result = getCastedNumber(0);

        for (int rowIndex = 1; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < rowIndex && columnIndex < matrix[rowIndex].length; columnIndex++) {
                result = summarizer.apply(result, matrix[rowIndex][columnIndex]);
            }
        }

        result = multiplier.apply(result, getCastedNumber(-1));
        return result;
    }

    @SuppressWarnings("unchecked")
    private N getCastedNumber(double baseValue) {
        N number;
        try {
            number = (N) this.instanceClass.getDeclaredMethod("valueOf", Integer.TYPE).invoke(0, (int) Math.round(baseValue));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                 IllegalArgumentException e) {
            try {
                number = (N) this.instanceClass.getDeclaredMethod("valueOf", Double.TYPE).invoke(0, baseValue);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                     IllegalArgumentException exception) {
                throw new IllegalArgumentException("The provided argument's type does not correspond to the required one.");
            }
        }

        return number;
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
