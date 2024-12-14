package com.skillbox;

import java.text.MessageFormat;

public class List {
    public class Node {
        int x;
        Node next;

        public Node(int x) {
            this.x = x;
            this.next = null;
        }

        @Override
        public String toString() {
            return MessageFormat.format("x = {0}, next x = {1}", x, next != null ? next.x : "null");
        }
    }

    // Pointer to the beginning of the list
    Node firstNode;
    Node lastNode;
    int length;

    public void push(int x) {
        var newNode = new Node(x);

        if (firstNode == null) {
            firstNode = newNode;
        } else {
            lastNode.next = newNode;
        }

        lastNode = newNode;
        length++;
    }

    // Adds element to the beginning of the list
    public void push_front(int x) {
        var newNode = new Node(x);
        newNode.next = firstNode;

        firstNode = newNode;

        if (lastNode == null) {
            lastNode = firstNode;
        }

        length++;
    }

    public List() {
        firstNode = null;
    }

    // This function could be useful for debugging and testing.
    public void print() {
        Node node = this.firstNode;
        while (node != null) {
            System.out.print(node.x + " ");
            node = node.next;
        }
        System.out.println();
    }

    // This function should return copy of the list where every second element is removed. Initial list should not be changed.
    // E.g. if we run copyEverySecond on list [1, 2, 3, 4, 5, 6, 7, 100, 120, 162, 0, 1] new list with values [1, 3, 5, 7, 120, 0] should be returned.
    public List copyEverySecond() {
        List result = new List();
        result.push(firstNode.x);

        var step = 1;
        var currentNode = firstNode.next;

        while (currentNode != null) {
            if (step % 2 == 0 ) {
                result.push(currentNode.x);
            }
            currentNode = currentNode.next;
            step++;
        }

        return result;
    }

    // Returns number of elements in list
    public int getSize() {
        return length;
    }

    // This function converts our list to an array. New array is created with values the same as in list.
    public int[] toArray() {
        var array = new int[length];
        var currentNode = firstNode;

        for (int i = 0; i < length; i++) {
            array[i] = currentNode.x;
            currentNode = currentNode.next;
        }

        return array;
    }

    // This function removes elements x.next from the list
    // O(1) time is expected
    public void removeAfter(Node x) {
        /* TODO IMPLEMENT THIS */
    }

    // This function inserts new element with value val right after the element x.
    // O(1) time is expected
    public void insertAfter(Node x, int val) {
        var newNode = new Node(val);

        newNode.next = x.next;
        x.next = newNode;

        length++;
    }

    // This function removes all elements from the list that are divisible by x.
    // E.g. list {1, 2, 3, 4, 4, 10, 7}  after filterDivisible(2) would look like {1, 3, 7}.
    // O(N) time is expected.
    public void filterDivisible(int x) {
        while (firstNode != null && firstNode.x % x == 0) {
            firstNode = firstNode.next;
            length--;
        }

        if (firstNode == null) {
            return;
        }

        var currentNode = firstNode;
        while (currentNode.next != null) {

            if (currentNode.next.x % x == 0) {
                currentNode.next = currentNode.next.next;
                length--;
            }
            else {
                currentNode = currentNode.next;
            }
        }
    }

    // This function returns Node from the list by index. O(N) time is expected.
    public Node getAt(int index) {
        var currentNode = firstNode;
        var currentIndex = 0;

        while (currentNode != null) {
            if (currentIndex == index) {
                break;
            }
            currentNode = currentNode.next;
            currentIndex++;
        }

        return currentNode;
    }

    // This function creates List from an array
    public static List fromArray(int[] a) {
        List list = new List();
        for (int i = a.length - 1; i >= 0; --i) {
            list.push_front(a[i]);
        }
        return list;
    }
}
