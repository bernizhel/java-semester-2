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
        assertEquals(StringConverter.convert(sumResult), StringConverter.convert(matrix.getSumAboveMainDiagonal()));
        assertEquals(StringConverter.convert(productResult), StringConverter.convert(matrix.getProductOfMainDiagonal()));
        assertEquals(StringConverter.convert(negativeSumResult), StringConverter.convert(matrix.getNegativeSumBelowMainDiagonal()));
    }

    private static class StringConverter {
        public static String convert(Number number) {
            String stringified = number.toString();

            int startIndex = -1;
            do {
                startIndex++;
            } while (stringified.charAt(startIndex) == '0');

            int endIndex = stringified.length();
            do {
                endIndex--;
            } while (stringified.charAt(endIndex) == '0');

            return stringified.substring(startIndex, endIndex);
        }
    }
}