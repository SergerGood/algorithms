package com.skillbox;

import java.text.MessageFormat;

public class DLList {
    public class Node {
        int x;
        Node next;
        Node prev;

        public Node(int x) {
            this.x = x;
            this.next = null;
            this.prev = null;
        }

        @Override
        public String toString() {
            return MessageFormat.format("x = {0}, next x = {1}, prev x = {2}", x, next != null ? next.x : "null", prev != null ? prev.x : "null");
        }
    }
    // You should store pointer to the first element of the list here
    Node begin;
    // You should store pointer to the last element of the list here
    Node end;
    int length;

    // This function should add new element with value x to the front of the list
    public void push_front(int x) {
        var node = new Node(x);

        if (begin == null) {
            end = node;
        } else {
            begin.prev = node;
            node.next = begin;
        }

        begin = node;
        length++;
    }

    // This function should add new element with value x to the end of the list
    public void push_back(int x) {
        var node = new Node(x);

        if (end == null) {
            begin = node;
        } else {
            end.next = node;
            node.prev = end;
        }

        end = node;
        length++;
    }

    public DLList() {
        begin = null;
        end = null;
    }

    // This function could be useful for debug purposes
    public void print() {
        Node node = this.begin;
        while (node != null) {
            System.out.print(node.x + " ");
            node = node.next;
        }
        System.out.println();
    }

    // This function should return the number of element in the list
    public int getSize() {
        return length;
    }

    // This function should return an array with values the same as in list
    public int[] toArray() {
        var result = new int[length];

        if (begin == null) {
            return result;
        }

        var currentNode = begin;

        for (int i = 0; i < length; i++) {
            result[i] = currentNode.x;
            currentNode = currentNode.next;
        }

        return result;
    }

    // This function should remove the element node from the list
    public void remove(Node node) {
        var prev = node.prev;
        var next = node.next;

        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }

        node.prev = null;
        node.next = null;

        if (node == begin) {
            begin = next;
        }
        if (node == end) {
            end = prev;
        }

        length--;
    }

    // This function should remove first element in the list and return its value
    public int pop_front() {
        var removedValue = begin.x;
        remove(begin);

        return removedValue;
    }

    // This function should remove last element in the list and return its value
    public int pop_back() {
        var removedValue = end.x;
        remove(end);

        return removedValue;
    }

    // This function should insert element with the value val after the element x
    public void insertAfter(Node node, int val) {
        var newNode = new Node(val);
        var next = node.next;

        node.next = newNode;
        newNode.prev = node;

        if(next == null) {
            end = newNode;
        } else {
           newNode.next = next;
           next.prev = newNode;
        }

        length++;
    }

    // This function should return element at index
    public Node getAt(int index) {
        var currentNode = begin;
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

    // This function construct list from the array
    public static DLList fromArray(int[] array) {
        DLList list = new DLList();
        for (int i = 0; i < array.length; ++i) {
            list.push_back(array[i]);
        }
        return list;
    }

}
