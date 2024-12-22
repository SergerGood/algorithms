package homework.SimpleRecursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleRecursionTest {
    static int findIterationFibonacci(int n)
    {
        /* Declare an array to store Fibonacci numbers. */
        int[] f = new int[n+2]; // 1 extra to handle case, n = 0
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++)
        {
       /* Add the previous 2 numbers in the series
         and store it */
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }

    @DisplayName("Find number of Fibonacci")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 7, 12})
    void findFibonacciTest(int n) {
        var actual = SimpleRecursion.findRecursionFibonacci(n);
        var expected = findIterationFibonacci(n);

        assertEquals(expected, actual);
    }
}
