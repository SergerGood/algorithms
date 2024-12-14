package com.skillbox;

// Stack implemented using dynamic array inside
public class Stack {
    // Array where we store the data
    private long[] array;
    // Number of elements that we actually store in the array. <= a.length
    private int size;

    public int getSize() {
        return size;
    }

    // This function is called when it's not enough memory to fit new elements.
    // It creates new long array and copies all the elements there.
    public void reallocate() {
        var newArray = new long[size * 2];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        array = newArray;
    }

    public Stack() {
        array = new long[10];
        size = 0;
    }

    // Adds element to the end of the stack
    public void push_back(long x) {
        if (size == array.length) {
            reallocate();
        }

        array[size] = x;
        size++;
    }

    // Removes last element from the stack and returns its value
    public long pop_back() {
        if (size == 0) {
            return 0;
        }

        var currentPosition = size - 1;
        var removedValue = array[currentPosition];

        array[currentPosition] = 0;
        size--;

        return removedValue;
    }

    // Returns value of the last element in the stack
    public long top() {
        return array[size];
    }

    // Calculates the result of reversed polish notation. https://en.wikipedia.org/wiki/Reverse_Polish_notation
    // This one is simplified. Every number and character are separated by exactly one space.
    // Only + - * should be supported.
    // Example: calcPolish("1 2 3 * -") should return -5 | because (1 - (2 * 3))
    public static long calcPolish(String s) {
        var stack = new Stack();
        var elements = s.split(" ");

        for (int i = 0; i < elements.length; i++) {
            var element = elements[i];

            if (isOperation(element)) {
                var secondOperator = stack.pop_back();
                var firstOperator = stack.pop_back();

                if (isPlus(element)) {
                    var result = firstOperator + secondOperator;
                    stack.push_back(result);
                } else if (isSign(element)) {
                    var result = firstOperator * secondOperator;
                    stack.push_back(result);
                } else if (isMinus(element)) {
                    var result = firstOperator - secondOperator;
                    stack.push_back(result);
                }
            } else {
                stack.push_back(Integer.parseInt(element));
            }
        }

        return stack.pop_back();
    }

    public static boolean isOperation(String symbol) {
        return isMinus(symbol) || isPlus(symbol) || isSign(symbol);
    }

    public static boolean isMinus(String symbol) {
        return symbol.equals("-");
    }

    public static boolean isPlus(String symbol) {
        return symbol.equals("+");
    }

    public static boolean isSign(String symbol) {
        return symbol.equals("*");
    }
}
