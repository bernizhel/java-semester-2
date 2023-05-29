package ru.vsuet.homework_linked_list.doubly_linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

class DoublyLinkedListImplIterator<E> implements Iterator<E> {
    private DoublyLinkedNode<E> currentNode;

    public DoublyLinkedListImplIterator(DoublyLinkedListImpl<E> doublyLinkedListImpl) {
        this.currentNode = doublyLinkedListImpl.get(0).orElse(null);
    }

    public boolean hasNext() {
        return currentNode != null;
    }

    public E next() {
        E value;
        try {
            value = currentNode.getValue();
            currentNode = currentNode.getNextNode();
        } catch (NullPointerException exception) {
            throw new NoSuchElementException();
        }

        return value;
    }
}
