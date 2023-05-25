package ru.vsuet.homework_hashtable;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.vsuet.homework_hashtable.separate_chaining.SeparateChainingHashtable;

import java.util.stream.Stream;

class HashtableProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new SeparateChainingHashtable<String, String>())
        );
    }
}
