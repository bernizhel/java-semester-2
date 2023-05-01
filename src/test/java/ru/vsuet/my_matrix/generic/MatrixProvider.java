package ru.vsuet.my_matrix.generic;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

//import java.math.BigDecimal;
import java.util.stream.Stream;

public class MatrixProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new Matrix<>(0, 3))
//                Arguments.of(new Matrix<BigDecimal>(1, 2))
        );
    }
}
