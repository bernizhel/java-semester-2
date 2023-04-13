package ru.vsuet.my_linked_list;

import java.util.Iterator;

interface LinkedListImpl<E> {
    Node<E> getLast();

    Node<E> get(int index);

    void add(E value);

    void add(int index, E value);

    void update(int index, E value);

    void remove(E value);

    void remove(int index);

    int size();

    boolean isEmpty();

    Iterator<E> iterator();
}
