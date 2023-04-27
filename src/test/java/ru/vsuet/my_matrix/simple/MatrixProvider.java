package ru.vsuet.my_matrix.simple;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.vsuet.my_matrix.simple.filling_strategy.ConstantFillingStrategy;
import ru.vsuet.my_matrix.simple.filling_strategy.RangeFillingStrategy;

import java.util.stream.Stream;

public class MatrixProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(3, 3, new ConstantFillingStrategy(1)),
                Arguments.of(4, 5, new RangeFillingStrategy(1, 20, 1))
        );
    }
}
