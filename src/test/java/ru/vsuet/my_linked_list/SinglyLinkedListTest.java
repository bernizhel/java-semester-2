package ru.vsuet.my_linked_list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.vsuet.my_linked_list.singly_linked.SinglyLinkedList;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SinglyLinkedListTest {
    private SinglyLinkedList<String> singlyLinkedList;

    @Test
    public void createList_whenGiveNothing_isEmpty() {
        singlyLinkedList = SinglyLinkedList.of();

        assertTrue(singlyLinkedList.isEmpty());
        assertEquals(0, singlyLinkedList.size());
        assertNull(singlyLinkedList.getLast());
        assertNull(singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void createList_whenGiveThree_containsThree() {
        singlyLinkedList = SinglyLinkedList.of(
                TestConstants.FIRST,
                TestConstants.SECOND,
                TestConstants.THIRD
        );

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(3, singlyLinkedList.size());
        assertEquals(TestConstants.THIRD, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, singlyLinkedList.get(1));
        assertEquals(TestConstants.THIRD, singlyLinkedList.get(2));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(3));
    }
}
