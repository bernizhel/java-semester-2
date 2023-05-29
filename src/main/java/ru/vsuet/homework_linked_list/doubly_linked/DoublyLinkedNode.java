package ru.vsuet.homework_linked_list.doubly_linked;

class DoublyLinkedNode<T> {
    private T value;
    private DoublyLinkedNode<T> nextNode;
    private DoublyLinkedNode<T> previousNode;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoublyLinkedNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoublyLinkedNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public DoublyLinkedNode<T> getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoublyLinkedNode<T> previousNode) {
        this.previousNode = previousNode;
    }
}
