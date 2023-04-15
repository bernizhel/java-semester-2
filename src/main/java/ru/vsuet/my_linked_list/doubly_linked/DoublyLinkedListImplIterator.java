package ru.vsuet.my_linked_list.doubly_linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

class DoublyLinkedListImplIterator<E> implements Iterator<E> {
    private DoublyLinkedNode<E> currentDoublyLinkedNode;

    public DoublyLinkedListImplIterator(DoublyLinkedListImpl<E> doublyLinkedListImpl) {
        this.currentDoublyLinkedNode = doublyLinkedListImpl.get(0).orElse(null);
    }

    public boolean hasNext() {
        return currentDoublyLinkedNode != null;
    }

    public E next() {
        E value;
        try {
            value = currentDoublyLinkedNode.getValue();
            currentDoublyLinkedNode = currentDoublyLinkedNode.getNextNode();
        } catch (Exception exception) {
            throw new NoSuchElementException();
        }

        return value;
    }
}
