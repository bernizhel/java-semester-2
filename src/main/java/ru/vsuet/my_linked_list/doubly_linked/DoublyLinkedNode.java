package ru.vsuet.my_linked_list.doubly_linked;

class DoublyLinkedNode<T> {
    private T value;
    private DoublyLinkedNode<T> nextDoublyLinkedNode;
    private DoublyLinkedNode<T> previousDoublyLinkedNode;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoublyLinkedNode<T> getNextNode() {
        return nextDoublyLinkedNode;
    }

    public void setNextNode(DoublyLinkedNode<T> nextDoublyLinkedNode) {
        this.nextDoublyLinkedNode = nextDoublyLinkedNode;
    }

    public DoublyLinkedNode<T> getPreviousNode() {
        return previousDoublyLinkedNode;
    }

    public void setPreviousNode(DoublyLinkedNode<T> previousDoublyLinkedNode) {
        this.previousDoublyLinkedNode = previousDoublyLinkedNode;
    }
}
