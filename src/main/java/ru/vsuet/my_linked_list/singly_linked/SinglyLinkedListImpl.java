package ru.vsuet.my_linked_list.singly_linked;

import java.util.Iterator;
import java.util.Optional;

/**
 * Danil Kosenko's (bernizhel's) implementation of the linked list.
 *
 * @param <E> which type the elements are in the list
 */
class SinglyLinkedListImpl<E> {
    private SinglyLinkedNode<E> headSinglyLinkedNode;
    private SinglyLinkedNode<E> tailSinglyLinkedNode;
    private int tailIndex;

    public SinglyLinkedListImpl() {
        this.headSinglyLinkedNode = null;
        this.tailSinglyLinkedNode = null;
        this.tailIndex = 0;
    }

    /**
     * Returns the very last of the list element's value.
     * If there is no elements, returns null.
     *
     * @return {@code Optional<SinglyLinkedNode<E>>} of nullable
     */
    public Optional<SinglyLinkedNode<E>> getLast() {
        return Optional.ofNullable(tailSinglyLinkedNode);
    }

    /**
     * Returns an element's value positioned at the specific {@code index}.
     * If the {@code index} is out of bounds or negative, returns null.
     *
     * @param index which index to search for
     * @return {@code Optional<SinglyLinkedNode<E>>} of nullable
     */
    public Optional<SinglyLinkedNode<E>> get(int index) {
        if (tailIndex == index) {
            return Optional.ofNullable(tailSinglyLinkedNode);
        }

        SinglyLinkedNode<E> currentSinglyLinkedNode = headSinglyLinkedNode;
        int currentIndex = 0;
        while (true) {
            if (currentSinglyLinkedNode == null) {
                return Optional.empty();
            }

            if (currentIndex == index) {
                return Optional.of(currentSinglyLinkedNode);
            }

            currentSinglyLinkedNode = currentSinglyLinkedNode.getNextNode();
            currentIndex++;
        }
    }

    /**
     * Adds an element with the specified {@code value} as the last one.
     *
     * @param value the new element's value
     */
    public void add(E value) {
        SinglyLinkedNode<E> newSinglyLinkedNode = new SinglyLinkedNode<>();
        newSinglyLinkedNode.setValue(value);

        if (headSinglyLinkedNode == null) {
            headSinglyLinkedNode = newSinglyLinkedNode;
            tailSinglyLinkedNode = headSinglyLinkedNode;
            return;
        }

        tailSinglyLinkedNode.setNextNode(newSinglyLinkedNode);
        tailSinglyLinkedNode = tailSinglyLinkedNode.getNextNode();
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
        SinglyLinkedNode<E> newSinglyLinkedNode = new SinglyLinkedNode<>();
        newSinglyLinkedNode.setValue(value);

        if (index == 0) {
            newSinglyLinkedNode.setNextNode(headSinglyLinkedNode);
            headSinglyLinkedNode = newSinglyLinkedNode;
            if (tailSinglyLinkedNode == null) {
                tailSinglyLinkedNode = headSinglyLinkedNode;
            } else {
                tailIndex++;
            }
            return;
        }

        if (size() == index) {
            newSinglyLinkedNode.setNextNode(tailSinglyLinkedNode.getNextNode());
            tailSinglyLinkedNode.setNextNode(newSinglyLinkedNode);
            tailSinglyLinkedNode = newSinglyLinkedNode;
            tailIndex++;
            return;
        }

        SinglyLinkedNode<E> currentSinglyLinkedNode = headSinglyLinkedNode;
        int currentIndex = 1;
        while (true) {
            if (currentSinglyLinkedNode == null) {
                return;
            }

            if (currentIndex == index) {
                newSinglyLinkedNode.setNextNode(currentSinglyLinkedNode.getNextNode());
                currentSinglyLinkedNode.setNextNode(newSinglyLinkedNode);
                tailIndex++;
                return;
            }

            currentSinglyLinkedNode = currentSinglyLinkedNode.getNextNode();
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
        if (tailIndex == index && tailSinglyLinkedNode != null) {
            tailSinglyLinkedNode.setValue(value);
            return;
        }

        SinglyLinkedNode<E> currentSinglyLinkedNode = headSinglyLinkedNode;
        int currentIndex = 0;
        while (true) {
            if (currentSinglyLinkedNode == null) {
                return;
            }

            if (currentIndex == index) {
                currentSinglyLinkedNode.setValue(value);
                return;
            }

            currentSinglyLinkedNode = currentSinglyLinkedNode.getNextNode();
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
        if (headSinglyLinkedNode == null) {
            return;
        }

        if (headSinglyLinkedNode.getValue().equals(value)) {
            if (tailSinglyLinkedNode == headSinglyLinkedNode) {
                tailSinglyLinkedNode = tailSinglyLinkedNode.getNextNode();
            } else {
                tailIndex--;
            }
            headSinglyLinkedNode = headSinglyLinkedNode.getNextNode();
            return;
        }

        SinglyLinkedNode<E> previousSinglyLinkedNode = headSinglyLinkedNode;
        SinglyLinkedNode<E> currentSinglyLinkedNode = previousSinglyLinkedNode.getNextNode();
        while (true) {
            if (currentSinglyLinkedNode == null) {
                return;
            }

            if (currentSinglyLinkedNode.getValue().equals(value)) {
                if (tailSinglyLinkedNode == currentSinglyLinkedNode) {
                    tailSinglyLinkedNode = previousSinglyLinkedNode;
                }
                previousSinglyLinkedNode.setNextNode(currentSinglyLinkedNode.getNextNode());
                tailIndex--;
                return;
            }

            previousSinglyLinkedNode = currentSinglyLinkedNode;
            currentSinglyLinkedNode = currentSinglyLinkedNode.getNextNode();
        }
    }

    /**
     * Removes an element from the list by the {@code index}.
     * If the {@code index} is out of bounds or negative, does nothing.
     *
     * @param index which index to search for
     */
    public void remove(int index) {
        if (headSinglyLinkedNode == null) {
            return;
        }

        if (index == 0) {
            if (tailSinglyLinkedNode == headSinglyLinkedNode) {
                tailSinglyLinkedNode = tailSinglyLinkedNode.getNextNode();
            } else {
                tailIndex--;
            }
            headSinglyLinkedNode = headSinglyLinkedNode.getNextNode();
            return;
        }

        SinglyLinkedNode<E> previousSinglyLinkedNode = headSinglyLinkedNode;
        SinglyLinkedNode<E> currentSinglyLinkedNode = previousSinglyLinkedNode.getNextNode();
        int currentIndex = 1;
        while (true) {
            if (currentSinglyLinkedNode == null) {
                return;
            }

            if (currentIndex == index) {
                if (tailSinglyLinkedNode == currentSinglyLinkedNode) {
                    tailSinglyLinkedNode = previousSinglyLinkedNode;
                }
                previousSinglyLinkedNode.setNextNode(currentSinglyLinkedNode.getNextNode());
                tailIndex--;
                return;
            }

            previousSinglyLinkedNode = currentSinglyLinkedNode;
            currentSinglyLinkedNode = currentSinglyLinkedNode.getNextNode();
            currentIndex++;
        }
    }

    /**
     * Returns tailIndex of the list.
     *
     * @return integer value of the list's tailIndex
     */
    public int size() {
        if (headSinglyLinkedNode == null) {
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
        return headSinglyLinkedNode == null;
    }

    /**
     * Returns new iterator for the instance.
     *
     * @return {@code Iterator<E>} of the instance
     */
    public Iterator<E> iterator() {
        return new SinglyLinkedListImplIterator<>(this);
    }
}
