package ru.vsuet.my_linked_list;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import ru.vsuet.my_linked_list.doubly_linked.DoublyLinkedList;
import ru.vsuet.my_linked_list.singly_linked.SinglyLinkedList;

import java.util.stream.Stream;

class LinkedListProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
        return Stream.of(
                Arguments.of(new SinglyLinkedList<String>()),
                Arguments.of(new DoublyLinkedList<String>())
        );
    }
}
