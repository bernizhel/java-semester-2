package ru.vsuet.my_linked_list;

import java.util.Iterator;

/**
 * Danil Kosenko's (bernizhel's) implementation of the linked list.
 *
 * @param <E> which type the elements are in the list
 */
public class MyLinkedList<E> implements LinkedList<E> {
    // TODO: use tail node
    private final MyLinkedListImpl<E> myLinkedListImpl;

    public MyLinkedList() {
        this.myLinkedListImpl = new MyLinkedListImpl<>();
    }

    /**
     * Returns the very last of the list element's value.
     * If there is no elements, returns null.
     *
     * @return the last element's value or null
     */
    public E getLast() {
        return myLinkedListImpl.getLast().orElse(new Node<>()).getValue();
    }

    /**
     * Returns an element's value positioned at the specific {@code index}.
     * If the {@code index} is out of bounds or negative, returns null.
     *
     * @param index which index to search for
     * @return the element's value or null
     */
    public E get(int index) {
        return myLinkedListImpl.get(index).orElse(new Node<>()).getValue();
    }

    /**
     * Adds an element with the specified {@code value} as the last one.
     *
     * @param value the new element's value
     */
    public void add(E value) {
        myLinkedListImpl.add(value);
    }

    /**
     * Adds an element with the specified {@code value} at the specified {@code index}.
     * Moves all the other elements after {@code index} inclusive right after the new element.
     * If the {@code index} is out of bounds or negative, does nothing.
     *
     * @param index which index the new element will be put at
     * @param value new element's value
     */
    public void add(int index, E value) {
        myLinkedListImpl.add(index, value);
    }

    /**
     * Updates an element's value positioned at the {@code index} with the new {@code value}.
     * If the {@code index} is out of bounds or negative, does nothing.
     *
     * @param index which index to search for
     * @param value new value of the element
     */
    public void update(int index, E value) {
        myLinkedListImpl.update(index, value);
    }

    /**
     * Removes an element from the list searched by the {@code value}.
     * If there is no element with the {@code value}, does nothing.
     *
     * @param value which value to search for
     */
    public void remove(E value) {
        myLinkedListImpl.remove(value);
    }

    /**
     * Removes an element from the list by the {@code index}.
     * If the {@code index} is out of bounds or negative, does nothing.
     *
     * @param index which index to search for
     */
    public void remove(int index) {
        myLinkedListImpl.remove(index);
    }

    /**
     * Returns size of the list.
     *
     * @return integer value of the list's size
     */
    public int size() {
        return myLinkedListImpl.size();
    }

    /**
     * Returns true or false depending on whether the list is empty or not respectively.
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return myLinkedListImpl.isEmpty();
    }

    /**
     * Returns new iterator for the instance.
     *
     * @return {@code Iterator<E>} of the instance
     */
    public Iterator<E> iterator() {
        return myLinkedListImpl.iterator();
    }

    /**
     * Creates {@code MyLinkedListImpl} instance based on the passed {@code values}.
     *
     * @param values new list's elements
     * @return new {@code MyLinkedListImpl} instance
     * @param <E> new {@code MyLinkedListImpl} instance's type of elements
     */
    @SafeVarargs
    public static <E> MyLinkedList<E> of(E... values) {
        MyLinkedList<E> myLinkedList = new MyLinkedList<>();
        for (E value : values) {
            myLinkedList.add(value);
        }

        return myLinkedList;
    }
}
