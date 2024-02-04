package Workshops.ExerciseWorkshop;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList {

    private class Node {
        private int element;
        private Node next;
        private Node prev;

        public Node(int element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node newHead = new Node(element);
        if (isEmpty()) {
            this.head = this.tail = newHead;
        } else {
            newHead.next = this.head;
            this.head.prev = newHead;
            this.head = newHead;
        }
        this.size++;
    }

    public void addLast(int element) {
        Node newTail = new Node(element);
        if (isEmpty()) {
            this.head = this.tail = newTail;
        } else {
            newTail.prev = this.tail;
            this.tail.next = newTail;
            this.tail = newTail;
        }
        this.size++;
    }

    public int get(int index) {
        validateIndex(index);

        Node searchedNode;
        if (index <= this.size / 2) {
            searchedNode = this.head;
            for (int i = 0; i < index; i++) {
                searchedNode = searchedNode.next;
            }
        } else {
            searchedNode = this.tail;
            for (int i = this.size - 1; i > index; i++) {
                searchedNode = searchedNode.prev;
            }
        }

        return searchedNode.element;
    }

    public int removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int element = this.head.element;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.prev = null;
        }
        this.size--;

        return element;
    }

    public int removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("The list is empty!");
        }

        int element = this.tail.element;
        this.tail = this.head.prev;
        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }
        this.size--;

        return element;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;

        while (currentNode != null) {
            consumer.accept(currentNode.element);

            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] arr = new int[this.size];
        Node currentNode = this.head;

        int idx = 0;
        while (currentNode != null) {
            arr[idx++] = currentNode.element;

            currentNode = currentNode.next;
        }

        return arr;
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Sorry, this index isn't valid!");
        }
    }
}
