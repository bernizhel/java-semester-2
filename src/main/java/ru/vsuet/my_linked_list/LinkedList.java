package ru.vsuet.my_linked_list;

public interface LinkedList<E> extends Iterable<E> {
    E getLast();

    E get(int index);

    void add(E value);

    void add(int index, E value);

    void update(int index, E value);

    void remove(E value);

    void remove(int index);

    int size();

    boolean isEmpty();
}
