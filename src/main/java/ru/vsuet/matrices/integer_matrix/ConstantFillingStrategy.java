package ru.vsuet.matrices.integer_matrix;

import ru.vsuet.matrices.interfaces.FillingStrategy;

import java.util.Arrays;

public class ConstantFillingStrategy implements FillingStrategy {
    private final int constantValue;

    public ConstantFillingStrategy(int constantValue) {
        this.constantValue = constantValue;
    }

    public void generate(int[][] matrix) {
        for (int[] row : matrix) {
            Arrays.fill(row, constantValue);
        }
    }
}
