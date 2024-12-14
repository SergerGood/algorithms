package com.skillbox;

import java.util.Arrays;

public class Main {

    public static void MyAssert(boolean x) {
        if (!x) {
            throw new RuntimeException();
        }
    }

    public static void testToArray() {
        int[] t1 = {1, 2, 5, 1, 2, 6, 1, 6, 8, 324, -10, 20};
        int[] t2 = {0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 2, 3};
        MyAssert(Arrays.equals(t1, DLList.fromArray(t1).toArray()));
        MyAssert(Arrays.equals(t2, DLList.fromArray(t2).toArray()));
        MyAssert(!Arrays.equals(t2, DLList.fromArray(t1).toArray()));
    }

    public static void testSize() {
        int[] t1 = {1, 2, 3, 4, 5, 6};
        int[] t2 = {1};
        int[] t3 = new int[10000];
        MyAssert(DLList.fromArray(t1).getSize() == 6);
        MyAssert(DLList.fromArray(t2).getSize() == 1);
        MyAssert(DLList.fromArray(t3).getSize() == 10000);
        MyAssert(new DLList().getSize() == 0);
    }

    public static void testPushAndPop() {
        DLList l = new DLList();
        l.push_front(1);
        l.push_front(2);
        l.push_front(3);
        l.push_back(4);
        l.push_back(5);
        l.push_back(6);
        MyAssert(Arrays.equals(l.toArray(), new int[]{3, 2, 1, 4, 5, 6}));
        MyAssert(6 == l.pop_back());
        MyAssert(5 == l.pop_back());
        MyAssert(3 == l.pop_front());
        MyAssert(Arrays.equals(l.toArray(), new int[]{2, 1, 4}));
    }

    public static void removeAndInsertAfter() {
        DLList l= new DLList();
        for (int i = 0; i < 10; ++i) {
            l.push_back(1);
        }
        for (int i = 9; i >= 0; --i) {
            l.insertAfter(l.getAt(i), i);
        }
        MyAssert(Arrays.equals(l.toArray(), new int[]{1, 0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 1, 9}));
        for (int i = 9; i >= 0; --i) {
            l.remove(l.getAt(2 * i));
        }
        MyAssert(Arrays.equals(l.toArray(), new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
        MyAssert(l.getSize() == 10);
        for (int i = 0; i < 10; ++i) {
            l.pop_back();
        }
        MyAssert(l.getSize() == 0);
        for (int i = 0; i < 7; ++i) {
            l.push_front(1);
            l.push_back(2);
        }
        MyAssert(l.getSize() == 14);
        for (int i = 0; i < 14; ++i) {
            l.pop_front();
        }
        MyAssert(l.getSize() == 0);
        l.push_front(1);
        MyAssert(l.end.x == 1);
        l.pop_back();
        l.push_back(2);
        MyAssert(l.begin.x == 2);
        l.pop_front();
        l.push_back(7);
        MyAssert(l.end.x == 7);
    }

    public static void main(String[] args) {
        testToArray();
        testSize();
        testPushAndPop();
        removeAndInsertAfter();
        System.out.println("All tests for DLList passed successfully! Congrats");
    }
}
