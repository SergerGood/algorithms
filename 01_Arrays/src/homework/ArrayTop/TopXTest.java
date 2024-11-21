package homework.ArrayTop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class TopXTest {

    static Stream<Arguments> providerFindTopElements() {
        return Stream.of(
                // Это только один из примеров, при которых код не работает
                // Вам нужно найти еще!
                Arguments.of(new int[]{10, 20, 30, 40}, -1)
        );
    }

    static Stream<Arguments> providerFindBottomElements() {
        return Stream.of(
                Arguments.of(new int[]{40, 50, 60, 10, 20, 30, 70, 80}, 3)
        );
    }

    static Stream<Arguments> providerFindTopElementsWithRepeating() {
        return Stream.of(
                Arguments.of(new int[]{100, 100, 100, 55, 8}, 3),
                Arguments.of(new int[]{100, 100, 100, 55, 8}, 2),
                Arguments.of(new int[]{100, 55, 8, 100, 100}, 4),
                Arguments.of(new int[]{0, 0, 0, 0}, 4)
        );
    }

    @DisplayName("Finding top elements")
    @ParameterizedTest
    @MethodSource("providerFindTopElements")
    void findTopElementsThrowsTest(int[] array, int numberOfElements) {
        assertDoesNotThrow(() ->
                TopX.findTopElements(array, numberOfElements)
        );
    }

    @DisplayName("Finding bottom elements")
    @ParameterizedTest
    @MethodSource("providerFindBottomElements")
    void findBottomElementsTest(int[] array, int numberOfElements) {
        var actual = TopX.findBottomElements(array, numberOfElements);
        Arrays.sort(array);
        var expected = Arrays.copyOf(array, numberOfElements);
        out.println("Actual: " + Arrays.toString(actual));
        out.println("Expected: " + Arrays.toString(expected));
        assertArrayEquals(expected, actual);
    }


    @DisplayName("Dealing with repeating elements")
    @ParameterizedTest
    @MethodSource("providerFindTopElementsWithRepeating")
    void findTopElementsWithRepeatingTest(int[] array, int numberOfElements) {
        var actual = TopX.findTopElements(array, numberOfElements);
        var actualList = Arrays.stream(actual).boxed().collect(Collectors.toList());
        var expected = Arrays.stream(array).boxed().sorted(Collections.reverseOrder()).limit(numberOfElements).collect(Collectors.toList());
        assertEquals(expected, actualList);
    }


}
