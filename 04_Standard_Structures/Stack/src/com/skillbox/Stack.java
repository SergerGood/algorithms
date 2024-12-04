package com.skillbox;

// Stack implemented using dynamic array inside
public class Stack {
    // Array where we store the data
    private long[] a;
    // Number of elements that we actually store in the array. <= a.length
    private int size;

    public int getSize() {
        return size;
    }

    // This function is called when it's not enough memory to fit new elements.
    // It creates new long array and copies all the elements there.
    public void reallocate() {
        /* IMPLEMENT THIS */
    }

    public Stack() {
        a = new long[10];
        size = 0;
    }

    // Adds element to the end of the stack
    public void push_back(long x) {
        /* IMPLEMENT THIS */
    }

    // Removes last element from the stack and returns its value
    public long pop_back() {
        /* IMPLEMENT THIS */
        return 0;
    }

    // Returns value of the last element in the stack
    public long top() {
        /* IMPLEMENT THIS */
        return 0;
    }

    // Calculates the result of reversed polish notation. https://en.wikipedia.org/wiki/Reverse_Polish_notation
    // This one is simplified. Every number and character are separated by exactly one space.
    // Only + - * should be supported.
    // Example: calcPolish("1 2 3 * -") should return -5 | because (1 - (2 * 3))
    public static long calcPolish(String s) {
        /* IMPLEMENT THIS */
        return 0;
    }




}
