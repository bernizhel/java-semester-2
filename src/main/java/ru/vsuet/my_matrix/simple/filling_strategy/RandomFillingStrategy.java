package ru.vsuet.my_matrix.simple.filling_strategy;

import ru.vsuet.my_matrix.simple.FillingStrategy;

import java.util.Random;

public class RandomFillingStrategy implements FillingStrategy {
    private final Random randomizer;
    private final int lowerBound;
    private final int upperBound;

    public RandomFillingStrategy(int lowerBound, int upperBound) {
        this.randomizer = new Random();
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public void generate(int[][] matrix) {
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                matrix[rowIndex][columnIndex] = randomizer.nextInt(lowerBound, upperBound);
            }
        }
    }
}
