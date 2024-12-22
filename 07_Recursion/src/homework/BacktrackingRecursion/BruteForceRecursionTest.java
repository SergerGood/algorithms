package homework.BacktrackingRecursion;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BruteForceRecursionTest {

    static Stream<Arguments> providerPossibleMessagesTest() {
        return Stream.of(
                Arguments.of("", new ArrayList<>()),
                Arguments.of("2", new ArrayList<>(Arrays.asList("a", "b", "c"))),
                Arguments.of("43", new ArrayList<>(Arrays.asList("gd", "ge", "gf", "hd", "he", "hf", "id", "ie", "if"))),
                Arguments.of("239", new ArrayList<>(Arrays.asList("adw", "adx", "ady", "adz",
                        "aew", "aex", "aey", "aez",
                        "afw", "afx", "afy", "afz",
                        "bdw", "bdx", "bdy", "bdz",
                        "bew", "bex", "bey", "bez",
                        "bfw", "bfx", "bfy", "bfz",
                        "cdw", "cdx", "cdy", "cdz",
                        "cew", "cex", "cey", "cez",
                        "cfw", "cfx", "cfy", "cfz")))
        );
    }

    static Stream<Arguments> providerOrderOfReleaseFeaturesTest() {
        var l1 = new ArrayList<ArrayList<Integer>>();
        l1.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        l1.add(new ArrayList<>(Arrays.asList(1, 3, 2)));
        l1.add(new ArrayList<>(Arrays.asList(2, 1, 3)));
        l1.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        l1.add(new ArrayList<>(Arrays.asList(3, 1, 2)));
        l1.add(new ArrayList<>(Arrays.asList(3, 2, 1)));

        var l2 = new ArrayList<ArrayList<Integer>>();
        l2.add(new ArrayList<>(Arrays.asList(13, 21)));
        l2.add(new ArrayList<>(Arrays.asList(21, 13)));

        var l3 = new ArrayList<ArrayList<Integer>>();
        l3.add(new ArrayList<>(Collections.singletonList(98)));
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, l1),
                Arguments.of(new int[]{13, 21}, l2),
                Arguments.of(new int[]{98}, l3)
        );
    }

    @DisplayName("Find all possible order of release features")
    @ParameterizedTest
    @MethodSource("providerOrderOfReleaseFeaturesTest")
    void orderOfReleaseFeaturesTest(int[] numbersOfFeatures, List<List<Integer>> releaseFeatures) {
        var actual = new HashSet<>(BruteForceRecursion.orderOfReleaseFeatures(numbersOfFeatures));
        var expected = new HashSet<>(releaseFeatures);

        assertEquals(expected, actual);
    }

    @DisplayName("Help Ivan check powers of 3")
    @ParameterizedTest
    @ValueSource(ints = {12, 11, 91, 112})
    void checkPowersOfThreeTest(int number) {
        var actual = BruteForceRecursion.checkPowersOfThree(number);
        var expected = !Integer
                .toString(number, 3)
                .contains("2");

        assertEquals(expected, actual);
    }

    @DisplayName("Find possible messages")
    @ParameterizedTest
    @MethodSource("providerPossibleMessagesTest")
    void possibleMessagesTest(String number, List<String> messages) {
        var actual = new HashSet<>(BruteForceRecursion.possibleMessages(number));
        var expected = new HashSet<>(messages);

        assertEquals(expected, actual);
    }
}
