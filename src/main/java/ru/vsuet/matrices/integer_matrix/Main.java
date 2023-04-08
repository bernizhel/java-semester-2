package ru.vsuet.matrices.integer_matrix;

import ru.vsuet.matrices.integer_matrix.impl.IntegerMatrix;
import ru.vsuet.matrices.integer_matrix.impl.ConstantFillingStrategy;
import ru.vsuet.matrices.integer_matrix.impl.RandomFillingStrategy;
import ru.vsuet.matrices.integer_matrix.impl.RangeFillingStrategy;
import ru.vsuet.matrices.integer_matrix.interfaces.FillingStrategy;

public class Main {
    public static void main(String[] args) {
        FillingStrategy firstFillingStrategy = new RandomFillingStrategy(-15, 15);
        IntegerMatrix first = new IntegerMatrix(3, firstFillingStrategy);
        testMatrix(first);

        FillingStrategy secondFillingStrategy = new ConstantFillingStrategy(3);
        IntegerMatrix second = new IntegerMatrix(4, 2, secondFillingStrategy);
        testMatrix(second);

        FillingStrategy thirdFillingStrategy = new RangeFillingStrategy(1, 20, 1);
        IntegerMatrix third = new IntegerMatrix(4, 5, thirdFillingStrategy);
        testMatrix(third);
    }

    private static void testMatrix(IntegerMatrix integerMatrix) {
        integerMatrix.fill();
        System.out.println(integerMatrix);

        System.out.println("Sum above the main diagonal: " + integerMatrix.getSumAboveMainDiagonal());
        System.out.println("Product of the main diagonal: " + integerMatrix.getProductOfMainDiagonal());
        System.out.println("Negative sum below the main diagonal: " + integerMatrix.getNegativeSumBelowMainDiagonal());

        System.out.println();
    }
}
