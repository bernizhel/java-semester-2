package ru.vsuet.matrix;

import ru.vsuet.matrix.impl.Matrix;
import ru.vsuet.matrix.impl.ConstantFillingStrategy;
import ru.vsuet.matrix.impl.RandomFillingStrategy;
import ru.vsuet.matrix.impl.RangeFillingStrategy;
import ru.vsuet.matrix.interfaces.FillingStrategy;

public class Main {
    public static void main(String[] args) {
        Matrix first = new Matrix(3);
        FillingStrategy firstFillingStrategy = new RandomFillingStrategy(-15, 15);
        testMatrix(first, firstFillingStrategy);

        Matrix second = new Matrix(4, 2);
        FillingStrategy secondFillingStrategy = new ConstantFillingStrategy(3);
        testMatrix(second, secondFillingStrategy);

        Matrix third = new Matrix(4, 5);
        FillingStrategy thirdFillingStrategy = new RangeFillingStrategy(1, 20, 1);
        testMatrix(third, thirdFillingStrategy);
    }

    private static void testMatrix(Matrix matrix, FillingStrategy fillingStrategy) {
        matrix.fill(fillingStrategy);
        System.out.println(matrix);

        System.out.println("Sum above the main diagonal: " + matrix.sumAboveMainDiagonal());
        System.out.println("Product of the main diagonal: " + matrix.productOfMainDiagonal());
        System.out.println("Negative sum below the main diagonal: " + matrix.negativeSumBelowMainDiagonal());

        System.out.println();
    }
}
