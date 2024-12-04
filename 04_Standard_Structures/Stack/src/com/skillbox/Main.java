package com.skillbox;

public class Main {

    public static void MyAssert(boolean x) {
        if (!x) {
            throw new RuntimeException();
        }
    }

    public static void testPolish() {
        MyAssert(Stack.calcPolish("8 9 + 1 7 - *") == -102);
        MyAssert(Stack.calcPolish("9 9 9 9 9 9 9 9 9 * * * * * * * *") == 387420489);
        MyAssert(Stack.calcPolish("2 3 4 5 * 6 - 7 + 8 9 2 * 3 4 1 - 3 4 + * 5 - + * + - * +") == -985);
        MyAssert(Stack.calcPolish("1 2 - 1 2 3 4 5 6 7 8 9 * * * * * * * * * 9 8 7 6 * * * *") == -1097349120);
        MyAssert(Stack.calcPolish("1234") == 1234);
        MyAssert(Stack.calcPolish("-1234") == -1234);
        MyAssert(Stack.calcPolish("1234 1 1 + +") == 1236);
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < 10000; ++i) {
            b.append(i + " ");
        }
        for (int i = 0; i < 10000; ++i) {
            b.append("+");
            if (i != 9999) {
                b.append(" ");
            }
        }
        MyAssert(Stack.calcPolish(b.toString()) == (10000 * 9999) / 2);
        b = new StringBuilder();
        b.append("0 ");
        for (int i = 0; i < 20000; ++i) {
            b.append(i + " +");
            if (i != 19999) {
                b.append(" ");
            }
        }
        MyAssert(Stack.calcPolish(b.toString()) == (20000 * 19999) / 2);
    }


    public static void main(String[] args) {
        testPolish();
        System.out.println("All tests for List passed successfully! Congrats");
    }
}
