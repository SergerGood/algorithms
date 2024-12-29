package homework.SimpleRecursion;

public class SimpleRecursion {

    // Task #1
    static int findRecursionFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return findRecursionFibonacci(n - 1) + findRecursionFibonacci(n - 2);
        }
    }
}
