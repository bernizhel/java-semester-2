package ru.vsuet.integer_matrix;

import ru.vsuet.integer_matrix.impl.IntegerMatrix;
import ru.vsuet.integer_matrix.impl.ConstantFillingStrategy;
import ru.vsuet.integer_matrix.impl.RandomFillingStrategy;
import ru.vsuet.integer_matrix.impl.RangeFillingStrategy;
import ru.vsuet.integer_matrix.interfaces.FillingStrategy;

public class Main {
    public static void main(String[] args) {
        IntegerMatrix first = new IntegerMatrix(3);
        FillingStrategy firstFillingStrategy = new RandomFillingStrategy(-15, 15);
        testMatrix(first, firstFillingStrategy);

        IntegerMatrix second = new IntegerMatrix(4, 2);
        FillingStrategy secondFillingStrategy = new ConstantFillingStrategy(3);
        testMatrix(second, secondFillingStrategy);

        IntegerMatrix third = new IntegerMatrix(4, 5);
        FillingStrategy thirdFillingStrategy = new RangeFillingStrategy(1, 20, 1);
        testMatrix(third, thirdFillingStrategy);
    }

    private static void testMatrix(IntegerMatrix integerMatrix, FillingStrategy fillingStrategy) {
        integerMatrix.fill(fillingStrategy);
        System.out.println(integerMatrix);

        System.out.println("Sum above the main diagonal: " + integerMatrix.sumAboveMainDiagonal());
        System.out.println("Product of the main diagonal: " + integerMatrix.productOfMainDiagonal());
        System.out.println("Negative sum below the main diagonal: " + integerMatrix.negativeSumBelowMainDiagonal());

        System.out.println();
    }
}
