package ru.vsuet.my_linked_list;

import java.util.Iterator;
import java.util.NoSuchElementException;

class MyLinkedListImplIterator<E> implements Iterator<E> {
    private Node<E> currentNode;

    public MyLinkedListImplIterator(MyLinkedListImpl<E> myLinkedListImpl) {
        this.currentNode = myLinkedListImpl.get(0).orElse(null);
    }

    public boolean hasNext() {
        return currentNode != null;
    }

    public E next() {
        E value;
        try {
            value = currentNode.getValue();
            currentNode = currentNode.getNextNode();
        } catch (Exception exception) {
            throw new NoSuchElementException();
        }

        return value;
    }
}
