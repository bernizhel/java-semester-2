package ru.vsuet.homework_linked_list.doubly_linked;

import ru.vsuet.homework_linked_list.LinkedList;

import java.util.Iterator;
import java.util.Optional;

/**
 * Danil Kosenko's (bernizhel's) implementation of the doubly linked list.
 *
 * @param <E> which type the elements are in the list
 */
public class DoublyLinkedList<E> implements LinkedList<E> {
    private final DoublyLinkedListImpl<E> doublyLinkedListImpl;

    public DoublyLinkedList() {
        this.doublyLinkedListImpl = new DoublyLinkedListImpl<>();
    }

    /**
     * Returns value of the last element in the list.
     *
     * @return element's value if found, otherwise null
     * @throws IndexOutOfBoundsException if the list's size is zero
     */
    public E getLast() throws IndexOutOfBoundsException {
        Optional<DoublyLinkedNode<E>> result = doublyLinkedListImpl.getLast();
        if (result.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return result.get().getValue();
    }

    /**
     * Returns an element's value positioned at the specific {@code index}.
     *
     * @param index which index to search the element at
     * @return element's value if found, otherwise null
     * @throws IndexOutOfBoundsException if the {@code index} is out of range
     */
    public E get(int index) {
        Optional<DoublyLinkedNode<E>> result = doublyLinkedListImpl.get(index);
        if (result.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        return result.get().getValue();
    }

    /**
     * Adds a new element with the specified {@code value} as the last one.
     *
     * @param value the new element's value
     * @return {@code true} as element will be added definitely
     */
    public boolean add(E value) {
        return doublyLinkedListImpl.add(value);
    }

    /**
     * Adds an element with the specified {@code value} at the specified {@code index}.
     * Moves all the other elements after {@code index} inclusive to the right after
     * the new element. If the {@code index} is out of bounds, throws an Exception.
     *
     * @param index which index the new element will be put at
     * @param value new element's value
     * @throws IndexOutOfBoundsException if the {@code index} is out of range
     */
    public void add(int index, E value) {
        boolean result = doublyLinkedListImpl.add(index, value);
        if (!result) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Updates value of an element positioned at the {@code index} with the {@code newValue}.
     *
     * @param index which index to search element at
     * @param newValue new value of the element
     * @throws IndexOutOfBoundsException if the {@code index} is out of range
     */
    public void update(int index, E newValue) {
        boolean result = doublyLinkedListImpl.update(index, newValue);
        if (!result) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Removes the first element with the given {@code value}.
     *
     * @param value which element's value to search for
     * @return {@code true} if the element has been removed
     */
    public boolean remove(E value) {
        return doublyLinkedListImpl.remove(value);
    }

    /**
     * Removes an element from the list by the given {@code index}.
     *
     * @param index which index to search for the element at
     * @return element that has been removed
     * @throws IndexOutOfBoundsException if the {@code index} is out of range
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        return doublyLinkedListImpl.remove(index);
    }

    /**
     * Returns size of the list.
     *
     * @return integer value of the list's size
     */
    public int size() {
        return doublyLinkedListImpl.size();
    }

    /**
     * Returns {@code true} or {@code false} depending on whether the list is empty
     * or not empty respectively.
     *
     * @return {@code true} if not empty
     */
    public boolean isEmpty() {
        return doublyLinkedListImpl.isEmpty();
    }

    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return {@inheritDoc}
     */
    public Iterator<E> iterator() {
        return doublyLinkedListImpl.iterator();
    }

}
