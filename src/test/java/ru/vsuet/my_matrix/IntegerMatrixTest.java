package ru.vsuet.my_matrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.vsuet.my_matrix.integer_matrix.IntegerMatrix;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntegerMatrixTest {
    private Matrix<Integer> matrix;

    @BeforeEach
    public void setUp() {
        matrix = null;
    }

    @ParameterizedTest
    @ArgumentsSource(MatrixProvider.class)
    public void create_withEmptyConstructor_CreateEmpty(int rows, int columns, FillingStrategy fillingStrategy) {
        matrix = new IntegerMatrix(rows, columns, fillingStrategy);
        matrix.fill();
    }
}
