package com.skillbox;

public class List {
    public class Node {
        int x;
        Node next;
        public Node(int x) {
            this.x = x;
            this.next = null;
        }
    }

    // Pointer to the beginning of the list
    Node begin;

    // Adds element to the beginning of the list
    public void push_front(int x) {
        /* TODO IMPLEMENT THIS */
    }

    public List() {
        begin = null;
    }

    // This function could be useful for debugging and testing.
    public void print() {
        Node n = this.begin;
        while (n != null) {
            System.out.print(n.x + " ");
            n = n.next;
        }
        System.out.println();
    }

    // This function should return copy of the list where every second element is removed. Initial list should not be changed.
    // E.g. if we run copyEverySecond on list [1, 2, 3, 4, 5, 6, 7, 100, 120, 162, 0, 1] new list with values [1, 3, 5, 7, 120, 0] should be returned.
    public List copyEverySecond() {
        /* TODO IMPLEMENT THIS */
        return new List();
    }

    // Returns number of elements in list
    public int getSize() {
        /* TODO IMPLEMENT THIS */
        return 0;
    }

    // This function converts our list to an array. New array is created with values the same as in list.
    public int[] toArray() {
        /* TODO IMPLEMENT THIS */
        return new int[0];
    }

    // This function removes elements x.next from the list
    // O(1) time is expected
    public void removeAfter(Node x) {
        /* TODO IMPLEMENT THIS */
    }

    // This function inserts new element with value val right after the element x.
    // O(1) time is expected
    public void insertAfter(Node x, int val) {
        /* TODO IMPLEMENT THIS */
    }

    // This function removes all elements from the list that are divisible by x.
    // E.g. list {1, 2, 3, 4, 4, 10, 7}  after filterDivisible(2) would look like {1, 3, 7}.
    // O(N) time is expected.
    public void filterDivisible(int x) {
        /* TODO IMPLEMENT THIS */
    }

    // This function returns Node from the list by index. O(N) time is expected.
    public Node getAt(int index) {
        /* TODO IMPLEMENT THIS */
        return null;
    }

    // This function creates List from an array
    public static List fromArray(int[] a) {
        List l = new List();
        for (int i = a.length - 1; i >= 0; --i) {
            l.push_front(a[i]);
        }
        return l;
    }

}
