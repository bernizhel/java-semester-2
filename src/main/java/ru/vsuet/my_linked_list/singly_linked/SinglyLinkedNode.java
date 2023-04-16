package ru.vsuet.my_linked_list.singly_linked;

class SinglyLinkedNode<T> {
    private T value;
    private SinglyLinkedNode<T> nextSinglyLinkedNode;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SinglyLinkedNode<T> getNextNode() {
        return nextSinglyLinkedNode;
    }

    public void setNextNode(SinglyLinkedNode<T> nextSinglyLinkedNode) {
        this.nextSinglyLinkedNode = nextSinglyLinkedNode;
    }
}
