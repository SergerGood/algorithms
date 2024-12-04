package com.skillbox;

import java.util.Arrays;

public class Main {

    public static void MyAssert(boolean x) {
        if (!x) {
            throw new RuntimeException("One of the tests failed.");
        }
    }

    public static void testToArray() {
        int[] t1 = {1, 2, 5, 1, 2, 6, 1, 6, 8, 324, -10, 20};
        int[] t2 = {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 2, 3};
        MyAssert(Arrays.equals(t1, List.fromArray(t1).toArray()));
        MyAssert(Arrays.equals(t2, List.fromArray(t2).toArray()));
        MyAssert(!Arrays.equals(t2, List.fromArray(t1).toArray()));
    }

    public static void testSize() {
        int[] t1 = {1, 2, 3, 4, 5, 6};
        int[] t2 = {1};
        int[] t3 = new int[10000];
        MyAssert(List.fromArray(t1).getSize() == 6);
        MyAssert(List.fromArray(t2).getSize() == 1);
        MyAssert(List.fromArray(t3).getSize() == 10000);
        MyAssert(new List().getSize() == 0);
    }
    public static void testEverySecond() {
        int[] t1 = {1, 2, 3, 4, 5, 6};
        int[] a1 = {1, 3, 5};
        int[] t2 = {1};
        int[] a2 = {1};
        int[] t3 = {1, 1, 1, 1};
        int[] a3 = {1, 1};
        int[] t4 = {6, 1, 6, 1, 6, 2, 5, 3, 7};
        int[] a4 = {6, 6, 6, 5, 7};
        List l = List.fromArray(t1);
        List l2 = l.copyEverySecond();
        MyAssert(Arrays.equals(l2.toArray(), a1));
        MyAssert(Arrays.equals(l.toArray(), t1));

        l = List.fromArray(t2);
        l2 = l.copyEverySecond();
        MyAssert(Arrays.equals(l2.toArray(), a2));
        MyAssert(Arrays.equals(l.toArray(), t2));

        l = List.fromArray(t3);
        l2 = l.copyEverySecond();
        MyAssert(Arrays.equals(l2.toArray(), a3));
        MyAssert(Arrays.equals(l.toArray(), t3));

        l = List.fromArray(t4);
        l2 = l.copyEverySecond();
        MyAssert(Arrays.equals(l2.toArray(), a4));
        MyAssert(Arrays.equals(l.toArray(), t4));
    }

    public static void testFilterX() {
        int[] t1 = {1, 2, 3, 4, 5, 6};
        int[] a1 = {1, 3, 5};
        int[] t2 = {1};
        int[] a2 = {1};
        int[] t3 = {12, 6, 1, 7};
        int[] a3 = {1, 7};
        int[] t4 = {8, 2, 12, 4, 120, 1240, 5, 1224, 2024};
        int[] a4 = {2, 5};
        int[] t5 = new int[10000];
        List l = List.fromArray(t1);
        l.filterDivisible(2);
        MyAssert(Arrays.equals(l.toArray(), a1));

        l = List.fromArray(t2);
        l.filterDivisible(7);
        MyAssert(Arrays.equals(l.toArray(), a2));

        l = List.fromArray(t3);
        l.filterDivisible(3);
        MyAssert(Arrays.equals(l.toArray(), a3));

        l = List.fromArray(t4);
        l.filterDivisible(4);
        MyAssert(Arrays.equals(l.toArray(), a4));

        l = List.fromArray(t5);
        l.filterDivisible(7);
        MyAssert(l.getSize() == 0);
    }

    public static void testGetAndInsert() {
        List l = new List();
        l.push_front(4);
        l.push_front(3);
        l.push_front(1);
        l.insertAfter(l.getAt(0), 2);
        l.insertAfter(l.getAt(3), 5);
        List.Node n = l.getAt(2);
        for (int i = 0; i < 5; ++i) {
            l.insertAfter(n, 100);
        }
        int[] ans = {1, 2, 3, 100, 100, 100, 100, 100, 4, 5};
        MyAssert(Arrays.equals(l.toArray(), ans));
        l = new List();
        for (int i = 0; i < 5; ++i) {
            l.push_front(0);
            l.insertAfter(l.getAt(0), 1);
        }
        int[] ans2 = {0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
        MyAssert(Arrays.equals(l.toArray(), ans2));
    }
    public static void main(String[] args) {
        testToArray();
        testSize();
        testEverySecond();
        testFilterX();
        testGetAndInsert();
        System.out.println("All tests for List passed successfully! Congrats");
    }
}
