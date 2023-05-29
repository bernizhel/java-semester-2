package ru.vsuet.my_linked_list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.vsuet.my_linked_list.doubly_linked.DoublyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DoublyLinkedListTest {
    private DoublyLinkedList<String> doublyLinkedList;

    @Test
    public void createList_whenGiveNothing_isEmpty() {
        doublyLinkedList = DoublyLinkedList.of();

        assertTrue(doublyLinkedList.isEmpty());
        assertEquals(0, doublyLinkedList.size());
        assertNull(doublyLinkedList.getLast());
        assertNull(doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void createList_whenGiveThree_containsThree() {
        doublyLinkedList = DoublyLinkedList.of(
                TestConstants.FIRST,
                TestConstants.SECOND,
                TestConstants.THIRD
        );

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(3, doublyLinkedList.size());
        assertEquals(TestConstants.THIRD, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(1));
        assertEquals(TestConstants.THIRD, doublyLinkedList.get(2));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(3));
    }
}
