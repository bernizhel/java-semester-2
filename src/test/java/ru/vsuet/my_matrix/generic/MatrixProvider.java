package ru.vsuet.my_matrix.generic;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class MatrixProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new Matrix<>(Integer.class, 3).addSummarizer(Integer::sum).addMultiplier((a, b) -> a * b).build(), 1, 3, 1, -3),
                Arguments.of(new Matrix<>(Double.class, 2).addSummarizer(Double::sum).addMultiplier((a, b) -> a * b).build(), 1d, 1d, 1d, -1d),
                Arguments.of(new Matrix<>(BigDecimal.class, 2).addSummarizer(BigDecimal::add).addMultiplier(BigDecimal::multiply), BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.5), BigDecimal.valueOf(0.25), BigDecimal.valueOf(-0.5))
        );
    }
}
