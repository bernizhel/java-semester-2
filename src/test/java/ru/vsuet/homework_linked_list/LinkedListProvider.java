package ru.vsuet.homework_linked_list;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.vsuet.homework_linked_list.doubly_linked.DoublyLinkedList;

import java.util.stream.Stream;

class LinkedListProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new DoublyLinkedList<String>())
        );
    }
}
