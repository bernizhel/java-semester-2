package ru.vsuet.my_linked_list;

import java.util.Iterator;
import java.util.Optional;

/**
 * Danil Kosenko's (bernizhel's) implementation of the linked list.
 *
 * @param <E> which type the elements are in the list
 */
class MyLinkedListImpl<E> implements LinkedListImpl<E> {
    private Node<E> headNode;
    private Node<E> tailNode;
    private int tailIndex;

    public MyLinkedListImpl() {
        this.headNode = null;
        this.tailNode = null;
        this.tailIndex = 0;
    }

    /**
     * Returns the very last of the list element's value.
     * If there is no elements, returns null.
     *
     * @return the last {@code Node<E>} or null
     */
    public Optional<Node<E>> getLast() {
        return Optional.ofNullable(tailNode);
    }

    /**
     * Returns an element's value positioned at the specific {@code index}.
     * If the {@code index} is out of bounds or negative, returns null.
     *
     * @param index which index to search for
     * @return the {@code Node<E>} or null
     */
    public Optional<Node<E>> get(int index) {
        if (tailIndex == index) {
            return Optional.ofNullable(tailNode);
        }

        Node<E> currentNode = headNode;
        int currentIndex = 0;
        while (true) {
            if (currentNode == null) {
                return Optional.empty();
            }

            if (currentIndex == index) {
                return Optional.of(currentNode);
            }

            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
    }

    /**
     * Adds an element with the specified {@code value} as the last one.
     *
     * @param value the new element's value
     */
    public void add(E value) {
        Node<E> newNode = new Node<>();
        newNode.setValue(value);

        if (headNode == null) {
            headNode = newNode;
            tailNode = headNode;
            return;
        }

        tailNode.setNextNode(newNode);
        tailNode = tailNode.getNextNode();
        tailIndex++;
    }

    /**
     * Adds an element with the specified {@code value} at the specified {@code index}.
     * Moves all the other elements after {@code index} inclusive right after the new element.
     * If the {@code index} is out of bounds or negative, does nothing.
     *
     * @param index which index the new element will be put at
     * @param value new element's value
     */
    public void add(int index, E value) {
        Node<E> newNode = new Node<>();
        newNode.setValue(value);

        if (index == 0) {
            newNode.setNextNode(headNode);
            headNode = newNode;
            if (tailNode == null) {
                tailNode = headNode;
            } else {
                tailIndex++;
            }
            return;
        }

        if (tailIndex == index) {
            newNode.setNextNode(tailNode.getNextNode());
            tailNode.setNextNode(newNode);
            tailNode = newNode;
            tailIndex++;
            return;
        }

        Node<E> currentNode = headNode;
        int currentIndex = 1;
        while (true) {
            if (currentNode == null) {
                return;
            }

            // TODO: does this work correctly?
            if (currentIndex == index) {
                newNode.setNextNode(currentNode.getNextNode());
                currentNode.setNextNode(newNode);
                if (tailNode == currentNode) {
                    tailNode = newNode;
                }
                tailIndex++;
                return;
            }

            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
    }

    /**
     * Updates an element's value positioned at the {@code index} with the new {@code value}.
     * If the {@code index} is out of bounds or negative, does nothing.
     *
     * @param index which index to search for
     * @param value new value of the element
     */
    public void update(int index, E value) {
        if (tailIndex == index && tailNode != null) {
            tailNode.setValue(value);
            return;
        }

        Node<E> currentNode = headNode;
        int currentIndex = 0;
        while (true) {
            if (currentNode == null) {
                return;
            }

            if (currentIndex == index) {
                currentNode.setValue(value);
                return;
            }

            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
    }

    /**
     * Removes an element from the list searched by the {@code value}.
     * If there is no element with the {@code value}, does nothing.
     *
     * @param value which value to search for
     */
    public void remove(E value) {
        if (headNode == null) {
            return;
        }

        // TODO: equals
        if (headNode.getValue() == value) {
            if (tailNode == headNode) {
                tailNode = tailNode.getNextNode();
            } else {
                tailIndex--;
            }
            headNode = headNode.getNextNode();
            return;
        }

        Node<E> previousNode = headNode;
        Node<E> currentNode = previousNode.getNextNode();
        while (true) {
            if (currentNode == null) {
                return;
            }

            if (currentNode.getValue().equals(value)) {
                if (tailNode == currentNode) {
                    tailNode = previousNode;
                }
                previousNode.setNextNode(currentNode.getNextNode());
                tailIndex--;
                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }
    }

    /**
     * Removes an element from the list by the {@code index}.
     * If the {@code index} is out of bounds or negative, does nothing.
     *
     * @param index which index to search for
     */
    public void remove(int index) {
        if (headNode == null) {
            return;
        }

        if (index == 0) {
            if (tailNode == headNode) {
                tailNode = tailNode.getNextNode();
            } else {
                tailIndex--;
            }
            headNode = headNode.getNextNode();
            return;
        }

        Node<E> previousNode = headNode;
        Node<E> currentNode = previousNode.getNextNode();
        int currentIndex = 1;
        while (true) {
            if (currentNode == null) {
                return;
            }

            if (currentIndex == index) {
                if (tailNode == currentNode) {
                    tailNode = previousNode;
                }
                previousNode.setNextNode(currentNode.getNextNode());
                tailIndex--;
                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
    }

    /**
     * Returns tailIndex of the list.
     *
     * @return integer value of the list's tailIndex
     */
    public int size() {
        if (headNode == null) {
            return 0;
        }

        return tailIndex + 1;
    }

    /**
     * Returns true or false depending on whether the list is empty or not respectively.
     *
     * @return true or false
     */
    public boolean isEmpty() {
        return headNode == null;
    }

    /**
     * Returns new iterator for the instance.
     *
     * @return {@code Iterator<E>} of the instance
     */
    public Iterator<E> iterator() {
        return new MyLinkedListImplIterator<>(this);
    }
}
