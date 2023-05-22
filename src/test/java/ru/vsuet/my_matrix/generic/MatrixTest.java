package ru.vsuet.my_matrix.generic;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MatrixTest {
    @ParameterizedTest
    @ArgumentsSource(MatrixProvider.class)
    public <N extends Number> void fillWithOnes_IntegerMatrix_beOk(Matrix<N> matrix, N fillingConstant, N sumResult, N productResult, N negativeSumResult) {
        matrix.fill(fillingConstant);
        assertEquals(sumResult, matrix.getSumAboveMainDiagonal());
        assertEquals(productResult, matrix.getProductOfMainDiagonal());
        assertEquals(negativeSumResult, matrix.getNegativeSumBelowMainDiagonal());
    }
}
