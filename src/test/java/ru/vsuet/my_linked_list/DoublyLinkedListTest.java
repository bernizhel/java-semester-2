package ru.vsuet.my_linked_list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import ru.vsuet.my_linked_list.doubly_linked.DoublyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DoublyLinkedListTest {
    private DoublyLinkedList<String> doublyLinkedList;

    @BeforeEach
    public void setUp() {
        doublyLinkedList = new DoublyLinkedList<>();
    }

    @Test
    public void getState_whenEmpty_ShouldBeOk() {
        assertTrue(doublyLinkedList.isEmpty());
        assertEquals(0, doublyLinkedList.size());
        assertNull(doublyLinkedList.getLast());
        assertNull(doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddOne_ShouldBeOk() {
        doublyLinkedList.add(TestConstants.FIRST);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(1, doublyLinkedList.size());
        assertEquals(TestConstants.FIRST, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddOneAtZero_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(1, doublyLinkedList.size());
        assertEquals(TestConstants.FIRST, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddOneAtOutOfBounds_ShouldBeOk() {
        doublyLinkedList.add(1, TestConstants.FIRST);

        assertTrue(doublyLinkedList.isEmpty());
        assertEquals(0, doublyLinkedList.size());
        assertNull(doublyLinkedList.getLast());
        assertNull(doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void getState_whenUpdatedNonExistent_ShouldBeOk() {
        doublyLinkedList.update(0, TestConstants.FIRST_UPDATED);

        assertTrue(doublyLinkedList.isEmpty());
        assertEquals(0, doublyLinkedList.size());
        assertNull(doublyLinkedList.getLast());
        assertNull(doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddAndUpdateOne_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);
        doublyLinkedList.update(0, TestConstants.FIRST_UPDATED);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(1, doublyLinkedList.size());
        assertEquals(TestConstants.FIRST_UPDATED, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST_UPDATED, doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void getState_whenRemoveNonExistent_ShouldBeOk() {
        doublyLinkedList.remove(TestConstants.FIRST);

        assertTrue(doublyLinkedList.isEmpty());
        assertEquals(0, doublyLinkedList.size());
        assertNull(doublyLinkedList.getLast());
        assertNull(doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void getState_whenRemoveByIndexNonExistent_ShouldBeOk() {
        doublyLinkedList.remove(0);

        assertTrue(doublyLinkedList.isEmpty());
        assertEquals(0, doublyLinkedList.size());
        assertNull(doublyLinkedList.getLast());
        assertNull(doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddAndRemoveOne_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);
        doublyLinkedList.remove(TestConstants.FIRST);

        assertTrue(doublyLinkedList.isEmpty());
        assertEquals(0, doublyLinkedList.size());
        assertNull(doublyLinkedList.getLast());
        assertNull(doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddAndRemoveByIndexOne_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);
        doublyLinkedList.remove(0);

        assertTrue(doublyLinkedList.isEmpty());
        assertEquals(0, doublyLinkedList.size());
        assertNull(doublyLinkedList.getLast());
        assertNull(doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }


    @Test
    public void getState_whenAddTwoAndRemoveFirst_ShouldBeOk() {
        doublyLinkedList.add(TestConstants.FIRST);
        doublyLinkedList.add(TestConstants.SECOND);
        doublyLinkedList.remove(TestConstants.FIRST);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(1, doublyLinkedList.size());
        assertEquals(TestConstants.SECOND, doublyLinkedList.getLast());
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddTwoAndRemoveByIndexFirst_ShouldBeOk() {
        doublyLinkedList.add(TestConstants.FIRST);
        doublyLinkedList.add(TestConstants.SECOND);
        doublyLinkedList.remove(0);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(1, doublyLinkedList.size());
        assertEquals(TestConstants.SECOND, doublyLinkedList.getLast());
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));

    }

    @Test
    public void getState_whenAddTwo_ShouldBeOk() {
        doublyLinkedList.add(TestConstants.FIRST);
        doublyLinkedList.add(TestConstants.SECOND);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(2, doublyLinkedList.size());
        assertEquals(TestConstants.SECOND, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(1));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(2));
    }

    @Test
    public void getState_whenAddByIndexTwo_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);
        doublyLinkedList.add(1, TestConstants.SECOND);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(2, doublyLinkedList.size());
        assertEquals(TestConstants.SECOND, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(1));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(2));
    }

    @Test
    public void getState_whenAddTwoAtZeroSequentially_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.SECOND);
        doublyLinkedList.add(0, TestConstants.FIRST);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(2, doublyLinkedList.size());
        assertEquals(TestConstants.SECOND, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(1));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(2));
    }

    @Test
    public void getState_whenAddTwoOutOfBounds_ShouldBeOk() {
        doublyLinkedList.add(1, TestConstants.FIRST);
        doublyLinkedList.add(-1, TestConstants.SECOND);

        assertTrue(doublyLinkedList.isEmpty());
        assertEquals(0, doublyLinkedList.size());
        assertNull(doublyLinkedList.getLast());
        assertNull(doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddThree_ShouldBeOk() {
        doublyLinkedList.add(TestConstants.FIRST);
        doublyLinkedList.add(TestConstants.SECOND);
        doublyLinkedList.add(TestConstants.THIRD);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(3, doublyLinkedList.size());
        assertEquals(TestConstants.THIRD, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(1));
        assertEquals(TestConstants.THIRD, doublyLinkedList.get(2));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(3));
    }

    @Test
    public void getState_whenAddByIndexThree_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);
        doublyLinkedList.add(1, TestConstants.SECOND);
        doublyLinkedList.add(2, TestConstants.THIRD);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(3, doublyLinkedList.size());
        assertEquals(TestConstants.THIRD, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(1));
        assertEquals(TestConstants.THIRD, doublyLinkedList.get(2));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(3));
    }

    @Test
    public void getState_whenAddAndUpdateThree_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);
        doublyLinkedList.add(1, TestConstants.SECOND);
        doublyLinkedList.add(2, TestConstants.THIRD);
        doublyLinkedList.update(0, TestConstants.FIRST_UPDATED);
        doublyLinkedList.update(1, TestConstants.SECOND_UPDATED);
        doublyLinkedList.update(2, TestConstants.THIRD_UPDATED);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(3, doublyLinkedList.size());
        assertEquals(TestConstants.THIRD_UPDATED, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST_UPDATED, doublyLinkedList.get(0));
        assertEquals(TestConstants.SECOND_UPDATED, doublyLinkedList.get(1));
        assertEquals(TestConstants.THIRD_UPDATED, doublyLinkedList.get(2));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(3));
    }

    @Test
    public void getState_whenAddThreeRemoveSecond_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);
        doublyLinkedList.add(1, TestConstants.SECOND);
        doublyLinkedList.add(2, TestConstants.THIRD);
        doublyLinkedList.remove(TestConstants.SECOND);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(2, doublyLinkedList.size());
        assertEquals(TestConstants.THIRD, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.THIRD, doublyLinkedList.get(1));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(2));
    }

    @Test
    public void getState_whenAddThreeRemoveByIndexSecond_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);
        doublyLinkedList.add(1, TestConstants.SECOND);
        doublyLinkedList.add(2, TestConstants.THIRD);
        doublyLinkedList.remove(1);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(2, doublyLinkedList.size());
        assertEquals(TestConstants.THIRD, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.THIRD, doublyLinkedList.get(1));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(2));
    }

    @Test
    public void getState_whenAddThreeRemoveThird_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);
        doublyLinkedList.add(1, TestConstants.SECOND);
        doublyLinkedList.add(2, TestConstants.THIRD);
        doublyLinkedList.remove(TestConstants.THIRD);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(2, doublyLinkedList.size());
        assertEquals(TestConstants.SECOND, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(1));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(2));
    }

    @Test
    public void getState_whenAddThreeRemoveByIndexThird_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);
        doublyLinkedList.add(1, TestConstants.SECOND);
        doublyLinkedList.add(2, TestConstants.THIRD);
        doublyLinkedList.remove(2);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(2, doublyLinkedList.size());
        assertEquals(TestConstants.SECOND, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(1));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(2));
    }

    @Test
    public void createList_whenGiveThree_ShouldBeOk() {
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

    @Test
    public void getState_whenAddThreeAndAddOneAsSecond_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);
        doublyLinkedList.add(1, TestConstants.THIRD);
        doublyLinkedList.add(2, TestConstants.FOURTH);
        doublyLinkedList.add(1, TestConstants.SECOND);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(4, doublyLinkedList.size());
        assertEquals(TestConstants.FOURTH, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(1));
        assertEquals(TestConstants.THIRD, doublyLinkedList.get(2));
        assertEquals(TestConstants.FOURTH, doublyLinkedList.get(3));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(4));
    }

    @Test
    public void getState_whenAddThreeAndAddOneAsThird_ShouldBeOk() {
        doublyLinkedList.add(0, TestConstants.FIRST);
        doublyLinkedList.add(1, TestConstants.SECOND);
        doublyLinkedList.add(2, TestConstants.FOURTH);
        doublyLinkedList.add(2, TestConstants.THIRD);

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(4, doublyLinkedList.size());
        assertEquals(TestConstants.FOURTH, doublyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(1));
        assertEquals(TestConstants.THIRD, doublyLinkedList.get(2));
        assertEquals(TestConstants.FOURTH, doublyLinkedList.get(3));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(4));
    }

    @Test
    public void createList_whenGiveNothing_ShouldBeOk() {
        doublyLinkedList = DoublyLinkedList.of();

        assertTrue(doublyLinkedList.isEmpty());
        assertEquals(0, doublyLinkedList.size());
        assertNull(doublyLinkedList.getLast());
        assertNull(doublyLinkedList.get(0));
        assertNull(doublyLinkedList.get(-1));
        assertNull(doublyLinkedList.get(1));
    }

    @Test
    public void loopThrough_whenEmpty_ShouldBeOk() {
        Iterator<String> iterator = doublyLinkedList.iterator();

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void loopThrough_whenWithThree_ShouldBeOk() {
        doublyLinkedList = DoublyLinkedList.of(
                TestConstants.FIRST,
                TestConstants.SECOND,
                TestConstants.THIRD
        );
        Iterator<String> iterator = doublyLinkedList.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(TestConstants.FIRST, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(TestConstants.SECOND, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(TestConstants.THIRD, iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
