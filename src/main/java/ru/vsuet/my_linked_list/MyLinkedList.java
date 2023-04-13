package ru.vsuet.my_linked_list;

/**
 * Danil Kosenko's (bernizhel's) implementation of the linked list.
 *
 * @param <E> which type the elements are in the list
 */
public class MyLinkedList<E> implements LinkedList<E> {
    private Node<E> headNode;

    public MyLinkedList() {
        this.headNode = null;
    }

    /**
     * Returns the very last of the list element's value.
     * If there is no elements, returns null.
     *
     * @return the last element's value or null
     */
    public E getLast() {
        if (headNode == null) {
            return null;
        }

        Node<E> currentNode = headNode;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }

        return currentNode.getValue();
    }

    /**
     * Returns an element's value positioned at the specific {@code index}.
     * If the {@code index} is out of bounds or negative, returns null.
     *
     * @param index which index to search for
     * @return the element's value or null
     */
    public E get(int index) {
        Node<E> currentNode = headNode;
        int currentIndex = 0;
        while (true) {
            if (currentNode == null) {
                return null;
            }

            if (currentIndex == index) {
                return currentNode.getValue();
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
            return;
        }

        Node<E> currentNode = headNode;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }

        currentNode.setNextNode(newNode);
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
            return;
        }

        Node<E> currentNode = headNode;
        int currentIndex = 1;
        while (true) {
            if (currentNode == null) {
                return;
            }

            if (currentIndex == index) {
                newNode.setNextNode(currentNode.getNextNode());
                currentNode.setNextNode(newNode);
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

        if (headNode.getValue() == value) {
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
                previousNode.setNextNode(currentNode.getNextNode());
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
                previousNode.setNextNode(currentNode.getNextNode());
                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            currentIndex++;
        }
    }

    /**
     * Returns size of the list.
     *
     * @return integer value of the list's size
     */
    public int size() {
        if (headNode == null) {
            return 0;
        }

        Node<E> currentNode = headNode;
        int listSize = 1;
        while (currentNode.getNextNode() != null) {
            listSize++;
            currentNode = currentNode.getNextNode();
        }

        return listSize;
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
     * Creates {@code MyLinkedList} instance based on the passed {@code values}.
     *
     * @param values new list's elements
     * @return new {@code MyLinkedList} instance
     * @param <E> new {@code MyLinkedList} instance's type of elements
     */
    @SafeVarargs
    public static <E> MyLinkedList<E> of(E... values) {
        MyLinkedList<E> myLinkedList = new MyLinkedList<>();
        for (E value : values) {
            myLinkedList.add(value);
        }

        return myLinkedList;
    }
}
