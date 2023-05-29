package ru.vsuet.homework_linked_list;

import ru.vsuet.homework_linked_list.doubly_linked.DoublyLinkedList;

public interface LinkedList<E> extends Iterable<E> {
    /**
     * Returns an element's value positioned at the specific {@code index}.
     *
     * @param index which index to search the element at
     * @return element's value if found, otherwise null
     * @throws IndexOutOfBoundsException if the {@code index} is out of range
     */
    E get(int index);

    /**
     * Adds a new element with the specified {@code value} as the last one.
     *
     * @param value the new element's value
     * @return {@code true} as element will be added definitely
     */
    boolean add(E value);

    /**
     * Adds an element with the specified {@code value} at the specified {@code index}.
     * Moves all the other elements after {@code index} inclusive to the right after
     * the new element. If the {@code index} is out of bounds, throws an Exception.
     *
     * @param index which index the new element will be put at
     * @param value new element's value
     * @throws IndexOutOfBoundsException if the {@code index} is out of range
     */
    void add(int index, E value);

    /**
     * Removes the first element with the given {@code value}.
     *
     * @param value which element's value to search for
     * @return {@code true} if the element has been removed
     */
    boolean remove(E value);

    /**
     * Removes an element from the list by the given {@code index}.
     *
     * @param index which index to search for the element at
     * @return element that has been removed
     * @throws IndexOutOfBoundsException if the {@code index} is out of range
     */
    E remove(int index);

    /**
     * Returns size of the list.
     *
     * @return integer value of the list's size
     */
    int size();

    /**
     * Returns {@code true} or {@code false} depending on whether the list is empty
     * or not empty respectively.
     *
     * @return {@code true} if not empty
     */
    boolean isEmpty();

    /**
     * Creates {@code DoublyLinkedListImpl} instance based on the passed {@code values}.
     *
     * @param values elements of the new list
     * @param <E>    new list's type of elements
     * @return new instance of the {@code DoublyLinkedList} class
     */
    @SuppressWarnings("unchecked")
    static <E> DoublyLinkedList<E> of(E... values) {
        DoublyLinkedList<E> doublyLinkedList = new DoublyLinkedList<>();
        for (E value : values) {
            doublyLinkedList.add(value);
        }

        return doublyLinkedList;
    }
}
