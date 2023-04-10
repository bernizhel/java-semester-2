package ru.vsuet.matrices.integer_matrix;

import ru.vsuet.matrices.interfaces.FillingStrategy;

import java.util.stream.IntStream;

public class RangeFillingStrategy implements FillingStrategy {
    private final int[] range;

    public RangeFillingStrategy(int from, int to, int step) {
        this.range = IntStream.iterate(from, next -> next + step).limit(((to - from) / step) + 1).toArray();
    }

    public void generate(int[][] matrix) {
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            System.arraycopy(
                    range,
                    rowIndex * matrix[rowIndex].length,
                    matrix[rowIndex],
                    0,
                    matrix[rowIndex].length
            );
        }
    }
}
