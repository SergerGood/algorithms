package homeworkTests;

import homework.InsertionPlace.UrbanDictionary;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UrbanDictionaryTest {
    static Stream<Arguments> dictionaryInsert() {
        return Stream.of(
                Arguments.of(List.of("a"), new String[]{"a"}),
                Arguments.of(List.of("Контент", "Лутер", "Тренд", "Фиксер", "Фэшн", "Хипстер"),
                        new String[]{"Контент", "Лутер", "Тренд", "Фиксер", "Фэшн", "Хипстер"}),
                Arguments.of(List.of("a", "z", "b"), new String[]{"a", "b", "z"}),
                Arguments.of(List.of("zz", "za", "zzza"), new String[]{"za", "zz", "zzza"})
        );
    }

    @DisplayName("insert text in dictionary")
    @ParameterizedTest
    @MethodSource("dictionaryInsert")
    void printCharsTest(List<String> words, String[] expected) {
        UrbanDictionary dictionary = new UrbanDictionary();

        words.forEach(dictionary::insertNewWord);
        String[] actual = dictionary.newRussianDictionary();
        assertArrayEquals(expected, actual,
                String.format("%nexpected:%s%nactual:  %s%n", Arrays.toString(expected), Arrays.toString(actual)));
    }
}
