package ru.vsuet.my_linked_list;

import java.util.Iterator;

class MyLinkedListImplIterator<E> implements Iterator<E> {
    private Node<E> currentNode;

    public MyLinkedListImplIterator(MyLinkedListImpl<E> myLinkedListImpl) {
        this.currentNode = myLinkedListImpl.get(0);
    }

    public boolean hasNext() {
        return currentNode != null;
    }

    public E next() {
        E value = currentNode.getValue();
        currentNode = currentNode.getNextNode();
        return value;
    }
}
