package ru.vsuet.my_linked_list.doubly_linked;

import ru.vsuet.my_linked_list.LinkedList;

import java.util.Iterator;

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
     */
    public E getLast() {
        return doublyLinkedListImpl.getLast().orElse(new DoublyLinkedNode<>()).getValue();
    }

    /**
     * Returns an element's value positioned at the specific {@code index}.
     * If the {@code index} is out of bounds, returns null.
     *
     * @param index which index to search the element at
     * @return element's value if found, otherwise null
     */
    public E get(int index) {
        return doublyLinkedListImpl.get(index).orElse(new DoublyLinkedNode<>()).getValue();
    }

    /**
     * Adds a new element with the specified {@code value} as the last one.
     *
     * @param value the new element's value
     */
    public void add(E value) {
        doublyLinkedListImpl.add(value);
    }

    /**
     * Adds an element with the specified {@code value} at the specified {@code index}.
     * Moves all the other elements after {@code index} inclusive to the right after
     * the new element. If the {@code index} is out of bounds, does nothing.
     * If the specified {@code index} is exactly of the list's size, adds new element
     * to the very end of the list, just like {@link #add(E value)} does.
     *
     * @param index which index the new element will be put at
     * @param value new element's value
     */
    public void add(int index, E value) {
        doublyLinkedListImpl.add(index, value);
    }

    /**
     * Updates value of an element positioned at the {@code index} with the {@code newValue}.
     * If the {@code index} is out of bounds, does nothing.
     *
     * @param index which index to search element at
     * @param newValue new value of the element
     */
    public void update(int index, E newValue) {
        doublyLinkedListImpl.update(index, newValue);
    }

    /**
     * Removes the first element with the given {@code value}.
     * If there is no element with the {@code value}, does nothing.
     *
     * @param value which element's value to search for
     */
    public void remove(E value) {
        doublyLinkedListImpl.remove(value);
    }

    /**
     * Removes an element from the list by the given {@code index}.
     * If the {@code index} is out of bounds, does nothing.
     *
     * @param index which index to search for the element at
     */
    public void remove(int index) {
        doublyLinkedListImpl.remove(index);
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
     * Returns true or false depending on whether the list is empty or not empty
     * respectively.
     *
     * @return boolean value
     */
    public boolean isEmpty() {
        return doublyLinkedListImpl.isEmpty();
    }

    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return an Iterator.
     */
    public Iterator<E> iterator() {
        return doublyLinkedListImpl.iterator();
    }

    /**
     * Creates {@code DoublyLinkedListImpl} instance based on the passed {@code values}.
     *
     * @param values elements of the new list
     * @return new instance of the {@code DoublyLinkedListImpl} class
     * @param <E> new list's type of elements
     */
    public static <E> DoublyLinkedList<E> of(E... values) {
        DoublyLinkedList<E> doublyLinkedList = new DoublyLinkedList<>();
        for (E value : values) {
            doublyLinkedList.add(value);
        }

        return doublyLinkedList;
    }
}
