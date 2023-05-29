package ru.vsuet.homework_linked_list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import ru.vsuet.homework_linked_list.doubly_linked.DoublyLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LinkedListTest {
    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenEmpty_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddOne_containsOne(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));

        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddOneAtZero_throwsException(LinkedList<String> linkedList) {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(0, TestConstants.FIRST));

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenRemoveNonExistent_throwsException(LinkedList<String> linkedList) {
        assertFalse(linkedList.remove(TestConstants.FIRST));

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenRemoveByIndexNonExistent_throwsException(LinkedList<String> linkedList) {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove(0));

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddAndRemoveOne_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));
        assertTrue(linkedList.remove(TestConstants.FIRST));

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddAndRemoveByIndexOne_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));
        assertEquals(TestConstants.FIRST, linkedList.remove(0));

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddTwoAndRemoveFirst_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));
        assertTrue(linkedList.add(TestConstants.SECOND));
        assertTrue(linkedList.remove(TestConstants.FIRST));

        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
        assertEquals(TestConstants.SECOND, linkedList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddTwoAndRemoveByIndexFirst_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));
        assertTrue(linkedList.add(TestConstants.SECOND));
        assertEquals(TestConstants.FIRST, linkedList.remove(0));

        assertFalse(linkedList.isEmpty());
        assertEquals(1, linkedList.size());
        assertEquals(TestConstants.SECOND, linkedList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));

    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddTwo_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));
        assertTrue(linkedList.add(TestConstants.SECOND));

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddTwoAtZeroSequentially_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.SECOND));
        linkedList.add(0, TestConstants.FIRST);

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddTwoOutOfBounds_throwsException(LinkedList<String> linkedList) {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(1, TestConstants.FIRST));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(-1, TestConstants.FIRST));

        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThree_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));
        assertTrue(linkedList.add(TestConstants.SECOND));
        assertTrue(linkedList.add(TestConstants.THIRD));

        assertFalse(linkedList.isEmpty());
        assertEquals(3, linkedList.size());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertEquals(TestConstants.THIRD, linkedList.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(3));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThreeRemoveSecond_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));
        assertTrue(linkedList.add(TestConstants.SECOND));
        assertTrue(linkedList.add(TestConstants.THIRD));
        assertTrue(linkedList.remove(TestConstants.SECOND));

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.THIRD, linkedList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThreeRemoveByIndexSecond_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));
        assertTrue(linkedList.add(TestConstants.SECOND));
        assertTrue(linkedList.add(TestConstants.THIRD));
        assertEquals(TestConstants.SECOND, linkedList.remove(1));

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.THIRD, linkedList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThreeRemoveThird_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));
        assertTrue(linkedList.add(TestConstants.SECOND));
        assertTrue(linkedList.add(TestConstants.THIRD));
        assertTrue(linkedList.remove(TestConstants.THIRD));

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThreeRemoveByIndexThird_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));
        assertTrue(linkedList.add(TestConstants.SECOND));
        assertTrue(linkedList.add(TestConstants.THIRD));
        assertEquals(TestConstants.THIRD, linkedList.remove(2));

        assertFalse(linkedList.isEmpty());
        assertEquals(2, linkedList.size());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(2));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThreeAndAddOneAsSecond_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));
        assertTrue(linkedList.add(TestConstants.THIRD));
        assertTrue(linkedList.add(TestConstants.FOURTH));
        linkedList.add(1, TestConstants.SECOND);

        assertFalse(linkedList.isEmpty());
        assertEquals(4, linkedList.size());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertEquals(TestConstants.THIRD, linkedList.get(2));
        assertEquals(TestConstants.FOURTH, linkedList.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(4));
    }

    @ParameterizedTest
    @ArgumentsSource(LinkedListProvider.class)
    public void getState_whenAddThreeAndAddOneAsThird_throwsException(LinkedList<String> linkedList) {
        assertTrue(linkedList.add(TestConstants.FIRST));
        assertTrue(linkedList.add(TestConstants.SECOND));
        assertTrue(linkedList.add(TestConstants.FOURTH));
        linkedList.add(2, TestConstants.THIRD);

        assertFalse(linkedList.isEmpty());
        assertEquals(4, linkedList.size());
        assertEquals(TestConstants.FIRST, linkedList.get(0));
        assertEquals(TestConstants.SECOND, linkedList.get(1));
        assertEquals(TestConstants.THIRD, linkedList.get(2));
        assertEquals(TestConstants.FOURTH, linkedList.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(4));
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

    @Test
    public void createList_whenGiveNothing_isEmpty() {
        DoublyLinkedList<String> doublyLinkedList = LinkedList.of();

        assertTrue(doublyLinkedList.isEmpty());
        assertEquals(0, doublyLinkedList.size());
        assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedList.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedList.get(1));
    }

    @Test
    public void createList_whenGiveThree_containsThree() {
        DoublyLinkedList<String> doublyLinkedList = LinkedList.of(
                TestConstants.FIRST,
                TestConstants.SECOND,
                TestConstants.THIRD
        );

        assertFalse(doublyLinkedList.isEmpty());
        assertEquals(3, doublyLinkedList.size());
        assertEquals(TestConstants.FIRST, doublyLinkedList.get(0));
        assertEquals(TestConstants.SECOND, doublyLinkedList.get(1));
        assertEquals(TestConstants.THIRD, doublyLinkedList.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedList.get(3));
    }
}
