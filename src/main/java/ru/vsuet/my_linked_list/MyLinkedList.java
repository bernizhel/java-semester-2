package ru.vsuet.my_linked_list;

// TODO: Use tail node for better performance

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
        if (headNode == null) {
            return null;
        }

        Node<T> currentNode = headNode;
        while (currentNode.getNextNode() != null) {
            currentNode = currentNode.getNextNode();
        }

        return currentNode.getValue();
    }

    public T get(int index) {
        Node<T> currentNode = headNode;
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

    public void add(T value) {
        Node<T> newNode = new Node<>();
        newNode.setValue(value);

        if (headNode == null) {
            headNode = newNode;
            return;
        }

        Node<T> currentNode = headNode;
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

    public void update(int index, T value) {
        Node<T> currentNode = headNode;
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

    public void remove(T value) {
        if (headNode == null) {
            return;
        }

        if (headNode.getValue() == value) {
            headNode = headNode.getNextNode();
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
            headNode = headNode.getNextNode();
            return;
        }

        Node<T> previousNode = headNode;
        Node<T> currentNode = previousNode.getNextNode();
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

    public int size() {
        if (headNode == null) {
            return 0;
        }

        Node<T> currentNode = headNode;
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
