package ru.vsuet.my_linked_list;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LinkedListTest {
    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenEmpty_ShouldBeOk(LinkedList<String> linkedList) {
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertNull(linkedList.getLast());
        assertNull(linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddOne_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(TestConstants.FIRST);

        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
        assertEquals(TestConstants.FIRST, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddOneAtZero_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);

        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
        assertEquals(TestConstants.FIRST, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddOneAtOutOfBounds_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(1, TestConstants.FIRST);

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertNull(linkedList.getLast());
        assertNull(linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenUpdatedNonExistent_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.update(0, TestConstants.FIRST_UPDATED);

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertNull(linkedList.getLast());
        assertNull(linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddAndUpdateOne_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);
        linkedList.update(0, TestConstants.FIRST_UPDATED);

        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
        assertEquals(TestConstants.FIRST_UPDATED, linkedList.getLast());
        assertEquals(TestConstants.FIRST_UPDATED, linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenRemoveNonExistent_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.remove(TestConstants.FIRST);

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertNull(linkedList.getLast());
        assertNull(linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenRemoveByIndexNonExistent_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.remove(0);

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertNull(linkedList.getLast());
        assertNull(linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddAndRemoveOne_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);
        linkedList.remove(TestConstants.FIRST);

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertNull(linkedList.getLast());
        assertNull(linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddAndRemoveByIndexOne_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);
        linkedList.remove(0);

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertNull(linkedList.getLast());
        assertNull(linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));
    }


    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddTwoAndRemoveFirst_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(TestConstants.FIRST);
        linkedList.add(TestConstants.SECOND);
        linkedList.remove(TestConstants.FIRST);

        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
        assertEquals(TestConstants.SECOND, linkedList.getLast());
        assertEquals(TestConstants.SECOND, linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddTwoAndRemoveByIndexFirst_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(TestConstants.FIRST);
        linkedList.add(TestConstants.SECOND);
        linkedList.remove(0);

        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
        assertEquals(TestConstants.SECOND, linkedList.getLast());
        assertEquals(TestConstants.SECOND, linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));

    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddTwo_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(TestConstants.FIRST);
        linkedList.add(TestConstants.SECOND);

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.SECOND, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddByIndexTwo_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);
        linkedList.add(1, TestConstants.SECOND);

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.SECOND, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddTwoAtZeroSequentially_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.SECOND);
        linkedList.add(0, TestConstants.FIRST);

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.SECOND, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddTwoOutOfBounds_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(1, TestConstants.FIRST);
        linkedList.add(-1, TestConstants.SECOND);

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertNull(linkedList.getLast());
        assertNull(linkedList.get(0));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThree_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(TestConstants.FIRST);
        linkedList.add(TestConstants.SECOND);
        linkedList.add(TestConstants.THIRD);

        assertFalse(linkedList.isEmpty());
        assertEquals(3, linkedList.size());
        assertEquals(TestConstants.THIRD, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertEquals(TestConstants.THIRD, linkedList.get(2));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(3));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddByIndexThree_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);
        linkedList.add(1, TestConstants.SECOND);
        linkedList.add(2, TestConstants.THIRD);

        assertFalse(linkedList.isEmpty());
        assertEquals(3, linkedList.size());
        assertEquals(TestConstants.THIRD, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertEquals(TestConstants.THIRD, linkedList.get(2));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(3));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddAndUpdateThree_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);
        linkedList.add(1, TestConstants.SECOND);
        linkedList.add(2, TestConstants.THIRD);
        linkedList.update(0, TestConstants.FIRST_UPDATED);
        linkedList.update(1, TestConstants.SECOND_UPDATED);
        linkedList.update(2, TestConstants.THIRD_UPDATED);

        assertFalse(linkedList.isEmpty());
        assertEquals(3, linkedList.size());
        assertEquals(TestConstants.THIRD_UPDATED, linkedList.getLast());
        assertEquals(TestConstants.FIRST_UPDATED, linkedList.get(0));
        assertEquals(TestConstants.SECOND_UPDATED, linkedList.get(1));
        assertEquals(TestConstants.THIRD_UPDATED, linkedList.get(2));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(3));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThreeRemoveSecond_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);
        linkedList.add(1, TestConstants.SECOND);
        linkedList.add(2, TestConstants.THIRD);
        linkedList.remove(TestConstants.SECOND);

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.THIRD, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.THIRD, linkedList.get(1));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThreeRemoveByIndexSecond_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);
        linkedList.add(1, TestConstants.SECOND);
        linkedList.add(2, TestConstants.THIRD);
        linkedList.remove(1);

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.THIRD, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.THIRD, linkedList.get(1));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThreeRemoveThird_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);
        linkedList.add(1, TestConstants.SECOND);
        linkedList.add(2, TestConstants.THIRD);
        linkedList.remove(TestConstants.THIRD);

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.SECOND, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThreeRemoveByIndexThird_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);
        linkedList.add(1, TestConstants.SECOND);
        linkedList.add(2, TestConstants.THIRD);
        linkedList.remove(2);

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.SECOND, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThreeAndAddOneAsSecond_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);
        linkedList.add(1, TestConstants.THIRD);
        linkedList.add(2, TestConstants.FOURTH);
        linkedList.add(1, TestConstants.SECOND);

        assertFalse(linkedList.isEmpty());
        assertEquals(4, linkedList.size());
        assertEquals(TestConstants.FOURTH, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertEquals(TestConstants.THIRD, linkedList.get(2));
        assertEquals(TestConstants.FOURTH, linkedList.get(3));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(4));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThreeAndAddOneAsThird_ShouldBeOk(LinkedList<String> linkedList) {
        linkedList.add(0, TestConstants.FIRST);
        linkedList.add(1, TestConstants.SECOND);
        linkedList.add(2, TestConstants.FOURTH);
        linkedList.add(2, TestConstants.THIRD);

        assertFalse(linkedList.isEmpty());
        assertEquals(4, linkedList.size());
        assertEquals(TestConstants.FOURTH, linkedList.getLast());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertEquals(TestConstants.THIRD, linkedList.get(2));
        assertEquals(TestConstants.FOURTH, linkedList.get(3));
        assertNull(linkedList.get(-1));
        assertNull(linkedList.get(4));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void loopThrough_whenEmpty_ShouldBeOk(LinkedList<String> linkedList) {
        Iterator<String> iterator = linkedList.iterator();

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void loopThrough_whenWithThree_ShouldBeOk(LinkedList<String> linkedList) {
        Stream.of(
                TestConstants.FIRST,
                TestConstants.SECOND,
                TestConstants.THIRD
        ).forEach(linkedList::add);
        Iterator<String> iterator = linkedList.iterator();

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
