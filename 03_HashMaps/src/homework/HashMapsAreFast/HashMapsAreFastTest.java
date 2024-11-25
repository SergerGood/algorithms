package homework.HashMapsAreFast;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapsAreFastTest {

    static Stream<Arguments> phonesNumbers() {
        return Stream.of(
                Arguments.of(new long[]{1L, 2L, 3L}, new long[]{1L, 2L, 3L}),
                Arguments.of(new long[]{1L, 1L, 1L}, new long[]{1L}),
                Arguments.of(new long[]{2L, 1L, 2L, 1L, 4L, 6L, 1L}, new long[]{2L, 1L, 4L, 6L}),
                Arguments.of(new long[]{2223L, 102L, 2223L, 102L, 4589L, 6803L, 102L},
                        new long[]{2223L, 102L, 4589L, 6803L}),
                Arguments.of(new long[0], new long[0])
        );
    }

    @DisplayName("Телефонная база")
    @ParameterizedTest
    @MethodSource("phonesNumbers")
    void hashString(long[] phones, long[] uniquePhones) {
        long[] actual = new HashMapsAreFast().getUniqueNumbers(phones);
        assertArrayEquals(uniquePhones, actual,
                String.format("%nexpected:%s%nactual:  %s%n%n", Arrays.toString(uniquePhones), Arrays.toString(actual)));
    }

    static final int[] integersSimple = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    static Stream<Arguments> sums() {
        return Stream.of(
                Arguments.of(integersSimple, 13, true),
                Arguments.of(integersSimple, 0, false),
                Arguments.of(integersSimple, 19, true),
                Arguments.of(integersSimple, -1, false),
                Arguments.of(integersSimple, 11, true)

        );
    }

    @DisplayName("Сумма чисел - малый набор")
    @ParameterizedTest
    @MethodSource("sums")
    void sumSimple(int[] integers, int sumSearch, boolean expected) {
        HashMapsAreFast hashMapsAreFast = new HashMapsAreFast();
        boolean actual = hashMapsAreFast.isThereTwoNumbers(integers, sumSearch);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> sumsBig() {
        return Stream.of(
                Arguments.of(bigArray, 1, true),
                Arguments.of(bigArray, 2, true),
                Arguments.of(bigArray, 100, false),
                Arguments.of(bigArray, 0, true),
                Arguments.of(bigArray, 8, true),
                Arguments.of(bigArray, -30, false),
                Arguments.of(bigArray, 10, false),
                Arguments.of(bigArray, -8, false)
        );
    }

    private final static int[] bigArray = createBigArray();

    private static int[] createBigArray() {
        int amount = 100_000;
        int[] numbers = new int[]{1, 2, 3, 4, 5, -1, -2, -3, -4};
        Random random = new Random(3843);

        return IntStream.range(0, amount)
                .map((i) -> numbers[random.nextInt(numbers.length)])
                .toArray();
    }

    @DisplayName("Сумма чисел - большой набор")
    @ParameterizedTest
    @MethodSource("sumsBig")
    void sumBig(int[] integers, int sumSearch, boolean expected) {
        HashMapsAreFast hashMapsAreFast = new HashMapsAreFast();
        boolean actual = hashMapsAreFast.isThereTwoNumbers(integers, sumSearch);
        assertEquals(expected, actual);
    }


}
