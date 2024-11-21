package homework.ArrayMax;


import one.util.streamex.EntryStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayMaxTest {

    static Stream<int[]> providerFindSmallestTransaction() {
        return Stream.of(
                new int[]{-1000, -100, -10, -1},
                new int[]{-1000},
                new int[]{-1000, -100, -10, -1, -1},
                new int[]{-1000, -100, -10, -1, -1, 0},
                new int[]{Integer.MIN_VALUE}
        );
    }

    static Stream<int[]> providerFindBestStudentMistakes() {
        return Stream.of(
                new int[]{9, 4, 1, 8, 7, 13, 6, 5},
                new int[]{1000},
                new int[]{9, 4, 1, 8, 7, 13, 6, 5, 1, 1, 1, 1, 1},
                new int[]{9, 4, 1, 8, 7, 13, 6, 5, 0},
                new int[]{Integer.MAX_VALUE}
        );
    }

    static Stream<int[]> providerFindAverageTime() {
        return Stream.of(
                new int[]{9999},
                new int[]{9, 4, 1, 8, 7, 9, 4, 1, 8, 7, 8, 7, 18, 3, 13, 6, 5},
                new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}
        );
    }

    static Stream<int[][]> providerFindMostProfitableClient() {
        return Stream.of(
                new int[][]{
                        {11, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                        {12, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                        {13, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                        {14, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                        {15, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                        {16, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                        {17, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                        {18, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                        {19, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                        {10, 2, 3, 4, 5, 6, 7, 8, 9, 0}
                },
                new int[][]{
                        {1, Integer.MAX_VALUE, Integer.MIN_VALUE},
                        {1, 2, 3},

                },
                new int[][]{
                        {1, 9999, -10},
                        {1},

                },
                new int[][]{
                        {95, 67, 13, 55, 44, 11, 10},
                        {7, 190, 4, 44, 11, 1, 99},
                        {0, 5, -1, 500, 14, 90, 1},
                }

        );
    }

    @DisplayName("Finding smallest transaction")
    @ParameterizedTest
    @MethodSource("providerFindSmallestTransaction")
    void findSmallestTransactionTest(int[] array) {
        var actual = ArrayMax.findSmallestTransaction(array);
        Arrays.sort(array);
        var expected = array[array.length - 1];
        assertEquals(expected, actual);
    }

    @DisplayName("Finding best student")
    @ParameterizedTest
    @MethodSource("providerFindBestStudentMistakes")
    void findBestStudentMistakesTest(int[] array) {
        var actual = ArrayMax.findBestStudentMistakes(array);
        Arrays.sort(array);
        var expected = array[0];
        assertEquals(expected, actual);
    }


    @DisplayName("Finding average time")
    @ParameterizedTest
    @MethodSource("providerFindAverageTime")
    void findAverageTimeTest(int[] array) {
        var actual = ArrayMax.findAverageTime(array);
        var expected = Arrays.stream(array).average().orElseThrow();
        assertEquals(expected, actual, 0.1);

    }

    @DisplayName("Finding most profitable client")
    @ParameterizedTest(name = "Example #{index}")
    @MethodSource("providerFindMostProfitableClient")
    void findMostProfitableClientTest(int[][] arrays) {
        var actual = ArrayMax.findMostProfitableClient(arrays);
        var expected = EntryStream.of(arrays)
                .mapValues(arr -> Arrays.stream(arr).average().orElseThrow())
                .max(Comparator.comparing(Map.Entry::getValue)).orElseThrow()
                .getKey();
        Assertions.assertEquals(expected, actual);


    }


}
