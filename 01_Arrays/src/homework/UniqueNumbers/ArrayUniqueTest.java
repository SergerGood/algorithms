package homework.UniqueNumbers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayUniqueTest {

    static Stream<int[][]> providerAvoidJailDueToTaxFraud() {
        return Stream.of(
                new int[][]{
                        {12391203, 3828382, 334934939},
                        {45345345, 5341312, 55345345},
                        {334934939, 1234122, 657657},

                },
                new int[][]{
                        {1, 1, 1},
                        {1, 1, 1}
                },
                new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                }

        );
    }

    @DisplayName("Learning letters")
    @ParameterizedTest
    @ValueSource(strings = {"АААФФФФФФФЖЫЫЫЫБЫРВАААААЛГГГХЫХЫБЛИА", "ОК", "СКИЛЛБОКСТОПЧИК", "ААААААААА"})
    void lettersLearnedTodayTest(String word) {
        var actual = ArrayUnique.lettersLearnedToday(word);
        var size = actual.size();
        var actualSet = actual.stream().mapToInt(c -> c).boxed().collect(Collectors.toSet());
        var expectedSet = word.chars().boxed().collect(Collectors.toSet());

        assertEquals(size, expectedSet.size());
        assertEquals(expectedSet, actualSet);
    }


    @DisplayName("Avoiding jail due to tax fraud")
    @ParameterizedTest(name = "Example #{index}")
    @MethodSource("providerAvoidJailDueToTaxFraud")
    void avoidJailDueToTaxFraudTest(int[][] report) {
        var actual = ArrayUnique.avoidJailDueToTaxFraud(report);
        var expected = Arrays.stream(report)
                /* Array to List */
                .map(
                        x -> Arrays.stream(x)
                                .boxed()
                                .collect(Collectors.toList())
                )
                /* Merging lists */
                .reduce(new ArrayList<>(), (acc, current) -> {
                    acc.addAll(current);
                    return acc;
                }).stream()
                /* To frequency map */
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                LinkedHashMap::new,
                                Collectors.counting())
                )
                .entrySet().stream()
                /* Filtering repeating */
                .filter(e -> e.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);

        assertEquals(expected, actual);
    }

}
