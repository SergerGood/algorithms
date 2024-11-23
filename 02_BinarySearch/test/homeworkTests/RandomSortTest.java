package homeworkTests;

import homework.Duplicates.RandomSort;
import homework.Duplicates.SortedCheck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RandomSortTest {

    static Stream<Arguments> arrays() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, true),
                Arguments.of(new int[]{1}, true),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, true),
                Arguments.of(new int[]{1, 2, 2, 3, 3, 4, 4, 5}, true),
                Arguments.of(new int[]{-1, 0, 1}, true),
                Arguments.of(new int[]{0, 1, 0}, false),
                Arguments.of(new int[]{0, -1, -2}, false),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 4}, false),
                Arguments.of(new int[]{2, 1}, false)
        );
    }

    @DisplayName("IsSorted Array")
    @ParameterizedTest
    @MethodSource("arrays")
    void iqListTest(int[] array, boolean expected) {
        boolean actual = RandomSort.myIsSorted(array);
        assertEquals(expected, actual);
    }

    @DisplayName("RandomSort")
    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5})
    void randomSortTest(int n){
        Random random = new Random(3444547);
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(500);
        }

        RandomSort.randomSort(array);

        assertTrue(SortedCheck.isSorted(array), "array after sort = " + Arrays.toString(array));
    }
}
