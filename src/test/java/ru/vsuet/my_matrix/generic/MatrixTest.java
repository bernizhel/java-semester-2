package ru.vsuet.my_matrix.generic;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MatrixTest {
    @ParameterizedTest
    @ArgumentsSource(MatrixProvider.class)
    public <N extends Number> void create_withEmptyConstructor_CreateEmpty(Matrix<N> matrix) {
        matrix.fill();
    }
}
