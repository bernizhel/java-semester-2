package ru.vsuet.my_linked_list.doubly_linked;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * Danil Kosenko's (bernizhel's) implementation of the doubly linked list.
 *
 * @param <E> which type the elements are in the list
 */
class DoublyLinkedListImpl<E> implements Iterable<E> {
    private DoublyLinkedNode<E> headNode;
    private DoublyLinkedNode<E> tailNode;
    private int size;

    public DoublyLinkedListImpl() {
        this.headNode = null;
        this.tailNode = null;
        this.size = 0;
    }

    /**
     * Returns value of the last element in the list.
     *
     * @return {@code Optional<DoublyLinkedNode<E>>} of nullable
     */
    public Optional<DoublyLinkedNode<E>> getLast() {
        return Optional.ofNullable(tailNode);
    }

    /**
     * Returns an element's value positioned at the specific {@code index}.
     * If the {@code index} is out of bounds, returns null.
     *
     * @param index which index to search the element at
     * @return {@code Optional<DoublyLinkedNode<E>>} of nullable
     */
    public Optional<DoublyLinkedNode<E>> get(int index) {
        return findNode(index);
    }

    /**
     * Adds a new element with the specified {@code value} as the last one.
     *
     * @param value the new element's value
     */
    public void add(E value) {
        DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>();
        newNode.setValue(value);

        if (headNode == null) {
            headNode = newNode;
            tailNode = newNode;
            size++;
            return;
        }

        tailNode.setNextNode(newNode);
        newNode.setPreviousNode(tailNode);
        tailNode = newNode;
        size++;
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
        if (index == size) {
            add(value);
            return;
        }

        DoublyLinkedNode<E> newNode = new DoublyLinkedNode<>();
        newNode.setValue(value);

        DoublyLinkedNode<E> nodeToReplace;
        try {
            nodeToReplace = findNode(index).get();
        } catch (NoSuchElementException exception) {
            return;
        }

        if (nodeToReplace.getPreviousNode() == null) {
            newNode.setNextNode(headNode);
            headNode.setPreviousNode(newNode);
            headNode = newNode;
            size++;
            return;
        }

        newNode.setNextNode(nodeToReplace);
        newNode.setPreviousNode(nodeToReplace.getPreviousNode());
        nodeToReplace.getPreviousNode().setNextNode(newNode);
        nodeToReplace.setPreviousNode(newNode);
        size++;
    }

    /**
     * Updates value of an element positioned at the {@code index} with the {@code newValue}.
     * If the {@code index} is out of bounds, does nothing.
     *
     * @param index which index to search element at
     * @param newValue new value of the element
     */
    public void update(int index, E newValue) {
        Optional<DoublyLinkedNode<E>> nodeToUpdate = findNode(index);
        nodeToUpdate.ifPresent(doublyLinkedNode -> doublyLinkedNode.setValue(newValue));
    }

    /**
     * Removes the first element with the given {@code value}.
     * If there is no element with the {@code value}, does nothing.
     *
     * @param value which element's value to search for
     */
    public void remove(E value) {
        removeNodeTemplate(() -> findNode(value).orElse(null));
    }

    /**
     * Removes an element from the list by the given {@code index}.
     * If the {@code index} is out of bounds, does nothing.
     *
     * @param index which index to search for the element at
     */
    public void remove(int index) {
        removeNodeTemplate(() -> findNode(index).orElse(null));
    }

    private void removeNodeTemplate(Supplier<DoublyLinkedNode<E>> nodeToRemoveSupplier) {
        DoublyLinkedNode<E> nodeToRemove = nodeToRemoveSupplier.get();
        try {
            Objects.requireNonNull(nodeToRemove);
        } catch (NullPointerException exception) {
            return;
        }

        if (nodeToRemove.getPreviousNode() == null && size == 1) {
            tailNode = null;
            headNode = null;
            size--;
            return;
        }

        if (nodeToRemove.getPreviousNode() == null && size != 1) {
            headNode.getNextNode().setPreviousNode(null);
            headNode = headNode.getNextNode();
            size--;
            return;
        }

        if (nodeToRemove.getNextNode() == null) {
            tailNode.getPreviousNode().setNextNode(null);
            tailNode = tailNode.getPreviousNode();
            size--;
            return;
        }

        nodeToRemove.getPreviousNode().setNextNode(nodeToRemove.getNextNode());
        nodeToRemove.getNextNode().setPreviousNode(nodeToRemove.getPreviousNode());
        size--;
    }

    private Optional<DoublyLinkedNode<E>> findNode(E value) {
        DoublyLinkedNode<E> currentNode = headNode;
        while (true) {
            if (currentNode == null) {
                return Optional.empty();
            }

            if (currentNode.getValue().equals(value)) {
                return Optional.of(currentNode);
            }

            currentNode = currentNode.getNextNode();
        }
    }

    private Optional<DoublyLinkedNode<E>> findNode(int index) {
        if (index < 0 || index >= size) {
            return Optional.empty();
        }

        if (index < size / 2) {
            return findNodeFromHead(index);
        } else {
            return findNodeFromTail(index);
        }
    }

    private Optional<DoublyLinkedNode<E>> findNodeFromHead(int index) {
        DoublyLinkedNode<E> currentNode = headNode;
        for (int currentIndex = 0; currentIndex < index; currentIndex++) {
            currentNode = currentNode.getNextNode();
        }

        return Optional.ofNullable(currentNode);
    }

    private Optional<DoublyLinkedNode<E>> findNodeFromTail(int index) {
        DoublyLinkedNode<E> currentNode = tailNode;
        for (int currentIndex = size - 1; currentIndex > index; currentIndex--) {
            currentNode = currentNode.getPreviousNode();
        }

        return Optional.ofNullable(currentNode);
    }

    /**
     * Returns size of the list.
     *
     * @return integer value of the list's size
     */
    public int size() {
        return size;
    }

    /**
     * Returns true or false depending on whether the list is empty or not empty
     * respectively.
     *
     * @return boolean value
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over elements of type {@code E}.
     *
     * @return an Iterator.
     */
    public DoublyLinkedListImplIterator<E> iterator() {
        return new DoublyLinkedListImplIterator<>(this);
    }
}
