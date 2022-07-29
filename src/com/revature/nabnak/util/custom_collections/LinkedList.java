package com.revature.nabnak.util.custom_collections;

public class LinkedList<E> implements List<E> {

    // instantiate
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
            if (currentNode.data.equals(element)) { // the element matches the data in the current node that will be removed
                if (tail.equals(head)) {
                    tail = head = null; // there is only one element, so set head/tail to null (the LinkedList is now empty)
                } else if (currentNode.equals(head)) {
                    head = currentNode.nextNode; // the head is being removed, so the next node becomes the head
                } else if (currentNode.equals(tail)) {
                    tail = previousNode; // the tail is being removed, so the previous node becomes the tail
                    tail.nextNode = null; // no node after the tail, so the next node is null
                } else {
                    previousNode.nextNode = currentNode.nextNode; // this nullifies the current node by linking the previous node to the next node (AFTER the current node)
                }

                size--; // the current node is nullified, list size is reduced by one
                return true; // the element was removed successfully

            } else {
                // increment the tester nodes along the LinkedList
                previousNode = currentNode;
                currentNode = currentNode.nextNode;
            }
        }

        return false; // the element could not be found in the LinkedList, so it couldn't be removed
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
