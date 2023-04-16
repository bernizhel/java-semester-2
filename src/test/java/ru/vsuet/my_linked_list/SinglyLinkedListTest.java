package ru.vsuet.my_linked_list;

import org.junit.jupiter.api.*;
import ru.vsuet.my_linked_list.singly_linked.SinglyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SinglyLinkedListTest {
    private SinglyLinkedList<String> singlyLinkedList;

    @BeforeEach
    public void setUp() {
        singlyLinkedList = new SinglyLinkedList<>();
    }

    @Test
    public void getState_whenEmpty_ShouldBeOk() {
        assertTrue(singlyLinkedList.isEmpty());
        assertEquals(0, singlyLinkedList.size());
        assertNull(singlyLinkedList.getLast());
        assertNull(singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddOne_ShouldBeOk() {
        singlyLinkedList.add(TestConstants.FIRST);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(1, singlyLinkedList.size());
        assertEquals(TestConstants.FIRST, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddOneAtZero_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(1, singlyLinkedList.size());
        assertEquals(TestConstants.FIRST, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddOneAtOutOfBounds_ShouldBeOk() {
        singlyLinkedList.add(1, TestConstants.FIRST);

        assertTrue(singlyLinkedList.isEmpty());
        assertEquals(0, singlyLinkedList.size());
        assertNull(singlyLinkedList.getLast());
        assertNull(singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void getState_whenUpdatedNonExistent_ShouldBeOk() {
        singlyLinkedList.update(0, TestConstants.FIRST_UPDATED);

        assertTrue(singlyLinkedList.isEmpty());
        assertEquals(0, singlyLinkedList.size());
        assertNull(singlyLinkedList.getLast());
        assertNull(singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddAndUpdateOne_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);
        singlyLinkedList.update(0, TestConstants.FIRST_UPDATED);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(1, singlyLinkedList.size());
        assertEquals(TestConstants.FIRST_UPDATED, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST_UPDATED, singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void getState_whenRemoveNonExistent_ShouldBeOk() {
        singlyLinkedList.remove(TestConstants.FIRST);

        assertTrue(singlyLinkedList.isEmpty());
        assertEquals(0, singlyLinkedList.size());
        assertNull(singlyLinkedList.getLast());
        assertNull(singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void getState_whenRemoveByIndexNonExistent_ShouldBeOk() {
        singlyLinkedList.remove(0);

        assertTrue(singlyLinkedList.isEmpty());
        assertEquals(0, singlyLinkedList.size());
        assertNull(singlyLinkedList.getLast());
        assertNull(singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddAndRemoveOne_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);
        singlyLinkedList.remove(TestConstants.FIRST);

        assertTrue(singlyLinkedList.isEmpty());
        assertEquals(0, singlyLinkedList.size());
        assertNull(singlyLinkedList.getLast());
        assertNull(singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddAndRemoveByIndexOne_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);
        singlyLinkedList.remove(0);

        assertTrue(singlyLinkedList.isEmpty());
        assertEquals(0, singlyLinkedList.size());
        assertNull(singlyLinkedList.getLast());
        assertNull(singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }


    @Test
    public void getState_whenAddTwoAndRemoveFirst_ShouldBeOk() {
        singlyLinkedList.add(TestConstants.FIRST);
        singlyLinkedList.add(TestConstants.SECOND);
        singlyLinkedList.remove(TestConstants.FIRST);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(1, singlyLinkedList.size());
        assertEquals(TestConstants.SECOND, singlyLinkedList.getLast());
        assertEquals(TestConstants.SECOND, singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddTwoAndRemoveByIndexFirst_ShouldBeOk() {
        singlyLinkedList.add(TestConstants.FIRST);
        singlyLinkedList.add(TestConstants.SECOND);
        singlyLinkedList.remove(0);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(1, singlyLinkedList.size());
        assertEquals(TestConstants.SECOND, singlyLinkedList.getLast());
        assertEquals(TestConstants.SECOND, singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));

    }

    @Test
    public void getState_whenAddTwo_ShouldBeOk() {
        singlyLinkedList.add(TestConstants.FIRST);
        singlyLinkedList.add(TestConstants.SECOND);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(2, singlyLinkedList.size());
        assertEquals(TestConstants.SECOND, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, singlyLinkedList.get(1));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(2));
    }

    @Test
    public void getState_whenAddByIndexTwo_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);
        singlyLinkedList.add(1, TestConstants.SECOND);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(2, singlyLinkedList.size());
        assertEquals(TestConstants.SECOND, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, singlyLinkedList.get(1));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(2));
    }

    @Test
    public void getState_whenAddTwoAtZeroSequentially_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.SECOND);
        singlyLinkedList.add(0, TestConstants.FIRST);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(2, singlyLinkedList.size());
        assertEquals(TestConstants.SECOND, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, singlyLinkedList.get(1));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(2));
    }

    @Test
    public void getState_whenAddTwoOutOfBounds_ShouldBeOk() {
        singlyLinkedList.add(1, TestConstants.FIRST);
        singlyLinkedList.add(-1, TestConstants.SECOND);

        assertTrue(singlyLinkedList.isEmpty());
        assertEquals(0, singlyLinkedList.size());
        assertNull(singlyLinkedList.getLast());
        assertNull(singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void getState_whenAddThree_ShouldBeOk() {
        singlyLinkedList.add(TestConstants.FIRST);
        singlyLinkedList.add(TestConstants.SECOND);
        singlyLinkedList.add(TestConstants.THIRD);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(3, singlyLinkedList.size());
        assertEquals(TestConstants.THIRD, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, singlyLinkedList.get(1));
        assertEquals(TestConstants.THIRD, singlyLinkedList.get(2));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(3));
    }

    @Test
    public void getState_whenAddByIndexThree_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);
        singlyLinkedList.add(1, TestConstants.SECOND);
        singlyLinkedList.add(2, TestConstants.THIRD);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(3, singlyLinkedList.size());
        assertEquals(TestConstants.THIRD, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, singlyLinkedList.get(1));
        assertEquals(TestConstants.THIRD, singlyLinkedList.get(2));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(3));
    }

    @Test
    public void getState_whenAddAndUpdateThree_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);
        singlyLinkedList.add(1, TestConstants.SECOND);
        singlyLinkedList.add(2, TestConstants.THIRD);
        singlyLinkedList.update(0, TestConstants.FIRST_UPDATED);
        singlyLinkedList.update(1, TestConstants.SECOND_UPDATED);
        singlyLinkedList.update(2, TestConstants.THIRD_UPDATED);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(3, singlyLinkedList.size());
        assertEquals(TestConstants.THIRD_UPDATED, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST_UPDATED, singlyLinkedList.get(0));
        assertEquals(TestConstants.SECOND_UPDATED, singlyLinkedList.get(1));
        assertEquals(TestConstants.THIRD_UPDATED, singlyLinkedList.get(2));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(3));
    }

    @Test
    public void getState_whenAddThreeRemoveSecond_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);
        singlyLinkedList.add(1, TestConstants.SECOND);
        singlyLinkedList.add(2, TestConstants.THIRD);
        singlyLinkedList.remove(TestConstants.SECOND);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(2, singlyLinkedList.size());
        assertEquals(TestConstants.THIRD, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertEquals(TestConstants.THIRD, singlyLinkedList.get(1));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(2));
    }

    @Test
    public void getState_whenAddThreeRemoveByIndexSecond_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);
        singlyLinkedList.add(1, TestConstants.SECOND);
        singlyLinkedList.add(2, TestConstants.THIRD);
        singlyLinkedList.remove(1);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(2, singlyLinkedList.size());
        assertEquals(TestConstants.THIRD, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertEquals(TestConstants.THIRD, singlyLinkedList.get(1));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(2));
    }

    @Test
    public void getState_whenAddThreeRemoveThird_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);
        singlyLinkedList.add(1, TestConstants.SECOND);
        singlyLinkedList.add(2, TestConstants.THIRD);
        singlyLinkedList.remove(TestConstants.THIRD);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(2, singlyLinkedList.size());
        assertEquals(TestConstants.SECOND, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, singlyLinkedList.get(1));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(2));
    }

    @Test
    public void getState_whenAddThreeRemoveByIndexThird_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);
        singlyLinkedList.add(1, TestConstants.SECOND);
        singlyLinkedList.add(2, TestConstants.THIRD);
        singlyLinkedList.remove(2);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(2, singlyLinkedList.size());
        assertEquals(TestConstants.SECOND, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, singlyLinkedList.get(1));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(2));
    }

    @Test
    public void createList_whenGiveThree_ShouldBeOk() {
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

    @Test
    public void getState_whenAddThreeAndAddOneAsSecond_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);
        singlyLinkedList.add(1, TestConstants.THIRD);
        singlyLinkedList.add(2, TestConstants.FOURTH);
        singlyLinkedList.add(1, TestConstants.SECOND);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(4, singlyLinkedList.size());
        assertEquals(TestConstants.FOURTH, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, singlyLinkedList.get(1));
        assertEquals(TestConstants.THIRD, singlyLinkedList.get(2));
        assertEquals(TestConstants.FOURTH, singlyLinkedList.get(3));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(4));
    }

    @Test
    public void getState_whenAddThreeAndAddOneAsThird_ShouldBeOk() {
        singlyLinkedList.add(0, TestConstants.FIRST);
        singlyLinkedList.add(1, TestConstants.SECOND);
        singlyLinkedList.add(2, TestConstants.FOURTH);
        singlyLinkedList.add(2, TestConstants.THIRD);

        assertFalse(singlyLinkedList.isEmpty());
        assertEquals(4, singlyLinkedList.size());
        assertEquals(TestConstants.FOURTH, singlyLinkedList.getLast());
        assertEquals(TestConstants.FIRST, singlyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, singlyLinkedList.get(1));
        assertEquals(TestConstants.THIRD, singlyLinkedList.get(2));
        assertEquals(TestConstants.FOURTH, singlyLinkedList.get(3));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(4));
    }

    @Test
    public void createList_whenGiveNothing_ShouldBeOk() {
        singlyLinkedList = SinglyLinkedList.of();

        assertTrue(singlyLinkedList.isEmpty());
        assertEquals(0, singlyLinkedList.size());
        assertNull(singlyLinkedList.getLast());
        assertNull(singlyLinkedList.get(0));
        assertNull(singlyLinkedList.get(-1));
        assertNull(singlyLinkedList.get(1));
    }

    @Test
    public void loopThrough_whenEmpty_ShouldBeOk() {
        Iterator<String> iterator = singlyLinkedList.iterator();

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void loopThrough_whenWithThree_ShouldBeOk() {
        singlyLinkedList = SinglyLinkedList.of(
                TestConstants.FIRST,
                TestConstants.SECOND,
                TestConstants.THIRD
        );
        Iterator<String> iterator = singlyLinkedList.iterator();

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
