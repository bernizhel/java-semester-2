package ru.vsuet.my_linked_list.singly_linked;

import java.util.Iterator;
import java.util.NoSuchElementException;

class SinglyLinkedListImplIterator<E> implements Iterator<E> {
    private SinglyLinkedNode<E> currentSinglyLinkedNode;

    public SinglyLinkedListImplIterator(SinglyLinkedListImpl<E> singlyLinkedListImpl) {
        this.currentSinglyLinkedNode = singlyLinkedListImpl.get(0).orElse(null);
    }

    public boolean hasNext() {
        return currentSinglyLinkedNode != null;
    }

    public E next() {
        E value;
        try {
            value = currentSinglyLinkedNode.getValue();
            currentSinglyLinkedNode = currentSinglyLinkedNode.getNextNode();
        } catch (Exception exception) {
            throw new NoSuchElementException();
        }

        return value;
    }
}
