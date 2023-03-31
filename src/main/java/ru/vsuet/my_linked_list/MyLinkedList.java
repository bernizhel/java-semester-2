package ru.vsuet.my_linked_list;

// TODO: Use tail node for better performance

// TODO: add tests for other types of objects
// TODO: add javadocs

/*
    My own implementation of a linked list
 */
public class MyLinkedList<T> {
    private Node<T> headNode;

    public MyLinkedList() {
        this.headNode = null;
    }

    public T getLast() {
        Node<T> currentNode = headNode;
        if (currentNode == null) {
            return null;
        }

        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }

        return currentNode.getValue();
    }

    public T get(int index) {
        Node<T> currentNode = headNode;
        if (currentNode == null) {
            return null;
        }

        int counter = 0;
        while (true) {
            if (counter == index) {
                return currentNode.getValue();
            }

            currentNode = currentNode.getNextNode();
            if (currentNode == null) {
                return null;
            }

            counter++;
        }
    }

    public void add(T value) {
        Node<T> newNode = new Node<>();
        newNode.setValue(value);

        Node<T> currentNode = headNode;
        if (currentNode == null) {
            headNode = newNode;
            return;
        }

        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }

        currentNode.setNextNode(newNode);
    }

    public void add(int index, T value) {
        Node<T> newNode = new Node<>();
        newNode.setValue(value);
        if (index == 0) {
            newNode.setNextNode(headNode);
            headNode = newNode;
            return;
        }

        Node<T> currentNode = headNode;
        int counter = 1;
        while (currentNode != null) {
            if (counter == index) {
                newNode.setNextNode(currentNode.getNextNode());
                currentNode.setNextNode(newNode);
                return;
            }

            currentNode = currentNode.getNextNode();
            counter++;
        }
    }

    public void update(int index, T value) {
        Node<T> currentNode = headNode;
        int counter = 0;
        while (true) {
            if (currentNode == null) {
                return;
            }

            if (counter == index) {
                currentNode.setValue(value);
                return;
            }

            currentNode = currentNode.getNextNode();
            counter++;
        }
    }

    public void remove(T value) {
        if (headNode == null) {
            return;
        }

        if (headNode.getValue() == value) {
            headNode = null;
            return;
        }

        Node<T> previousNode = headNode;
        Node<T> currentNode = previousNode.getNextNode();
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

    public void remove(int index) {
        if (headNode == null) {
            return;
        }

        if (index == 0) {
            headNode = null;
            return;
        }

        Node<T> previousNode = headNode;
        Node<T> currentNode = previousNode.getNextNode();
        int counter = 1;
        while (true) {
            if (currentNode == null) {
                return;
            }

            if (counter == index) {
                previousNode.setNextNode(currentNode.getNextNode());
                return;
            }

            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
            counter++;
        }
    }

    public int size() {
        Node<T> currentNode = headNode;
        if (currentNode == null) {
            return 0;
        }

        int listSize = 1;
        while (currentNode.getNextNode() != null) {
            listSize++;
            currentNode = currentNode.getNextNode();
        }

        return listSize;
    }

    public boolean isEmpty() {
        return headNode == null;
    }

    @SafeVarargs
    public static <T> MyLinkedList<T> of(T... values) {
        MyLinkedList<T> myLinkedList = new MyLinkedList<>();
        for (T value : values) {
            myLinkedList.add(value);
        }

        return myLinkedList;
    }
}
