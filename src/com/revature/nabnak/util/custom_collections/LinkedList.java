package com.revature.nabnak.util.custom_collections;

public class LinkedList<E> implements List<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;

    @Override
    public boolean add(E element) {

        if (element == null) return false;

        Node<E> newNode = new Node<>(element);
        if (head == null) {
            tail = head = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }

        size++;

        return true;
    }

    @Override
    public boolean contains(E element) {
        Node<E> runner = head;

        while (runner != null) {
            if (runner.data.equals(element)) return true;
            runner = runner.nextNode;
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    // TODO: IMPLEMENT THIS!!!!!!!!!!!!!!
    @Override
    public boolean remove(E element) {
        // instantiate tester nodes 'current' and 'previous'
        Node<E> currentNode = head; // begin with head node
        Node<E> previousNode = null; // nothing before the head, so previous node is null

        // while there are remaining nodes in the LinkedList...
        while (currentNode != null) {
            if (currentNode.data.equals(element)) { // if the current node's data matches the element...
                if (tail.equals(head)) {
                    tail = head = null; // if there is only one
                } else if (currentNode.equals(head)) {
                    head = currentNode.nextNode;
                } else if (currentNode.equals(tail)) {
                    tail = previousNode;
                    tail.nextNode = null;
                } else {
                    previousNode.nextNode = currentNode.nextNode;
                }
                size--;
                return true;

            } else {
                previousNode = currentNode;
                currentNode = currentNode.nextNode;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> currentNode = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                return currentNode.data;
            } else {
                currentNode = currentNode.nextNode;
            }
        }

        return null;
    }

    private static class Node<T> {
        T data;
        Node<T> nextNode;

        public Node(T data) {
            this.data = data;
        }
    }
}
