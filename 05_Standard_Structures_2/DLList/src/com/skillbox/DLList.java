package com.skillbox;

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
    }
    // You should store pointer to the first element of the list here
    Node begin;
    // You should store pointer to the last element of the list here
    Node end;

    // This function should add new element with value x to the front of the list
    public void push_front(int x) {
    }

    // This function should add new element with value x to the end of the list
    public void push_back(int x) {
    }

    public DLList() {
        begin = null;
        end = null;
    }

    // This function could be useful for debug purposes
    public void print() {
        Node n = this.begin;
        while (n != null) {
            System.out.print(n.x + " ");
            n = n.next;
        }
        System.out.println();
    }

    // This function should return the number of element in the list
    public int getSize() {
    }

    // This function should return an array with values the same as in list
    public int[] toArray() {
    }


    // This function should remove the element x from the list
    public void remove(Node x) {
    }

    // This function should remove first element in the list and return its value
    public int pop_front() {
    }

    // This function should remove last element in the list and return its value
    public int pop_back() {
    }

    // This function should insert element with the value val after the element x
    public void insertAfter(Node x, int val) {
    }

    // This function should return element at index
    public Node getAt(int index) {
    }

    // This function construct list from the array
    public static DLList fromArray(int[] a) {
        DLList l = new DLList();
        for (int i = 0; i < a.length; ++i) {
            l.push_back(a[i]);
        }
        return l;
    }

}
