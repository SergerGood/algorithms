package homeworkTests;

import homework.BinarySearch.BinarySearch;
import homework.BinarySearch.BinarySearch.DatingUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    static Stream<Arguments> languages() {
        return Stream.of(
                Arguments.of(new String[]{"ADA",
                        "ALGOL",
                        "B",
                        "BASIC",
                        "C",
                        "C++"}, "BASIC", true),
                Arguments.of(new String[0], "Java", false),
                Arguments.of(new String[]{"Java"}, "Java", true),
                Arguments.of(new String[]{"Rust"}, "Java", false),
                Arguments.of(new String[]{"Basic", "C++", "Rust"}, "Java", false),
                Arguments.of(new String[]{"Basic", "C++", "Java"}, "Java", true),
                Arguments.of(new String[]{"Basic", "C++", "Java"}, "", false)
        );
    }

    @DisplayName("BinarySearch Languages")
    @ParameterizedTest
    @MethodSource("languages")
    void binarySearchTest(String[] knownLanguages, String language, boolean expected) {
        boolean actual = BinarySearch.doIKnowThisLanguage(knownLanguages, language);
        assertEquals(expected, actual,
                String.format("array %s %s contains \"%s\"",
                        Arrays.toString(knownLanguages), expected ? "" : "NOT", language));
    }

    static Stream<Arguments> iqList() {
        final DatingUser[] datingUsers = new DatingUser[]{
                new DatingUser(84, "Максим"),
                new DatingUser(91, "Виктория"),
                new DatingUser(96, "Артём"),
                new DatingUser(99, "Дарья"),
                new DatingUser(105, "Мария"),
                new DatingUser(111, "Иван"),
                new DatingUser(116, "София"),
                new DatingUser(120, "Анастасия"),
                new DatingUser(129, "Александр"),
                new DatingUser(131, "Михаил")};

        return Stream.of(
                Arguments.of(new DatingUser[0], 93, 110, Collections.emptyList()),
                Arguments.of(datingUsers, 80, 110, List.of("Максим", "Виктория", "Артём", "Дарья", "Мария")),
                Arguments.of(datingUsers, 93, 110, List.of("Артём", "Дарья", "Мария")),
                Arguments.of(datingUsers, 120, 140, List.of("Анастасия", "Александр", "Михаил")),
                Arguments.of(datingUsers, 140, 150, Collections.emptyList())
        );
    }

    @DisplayName("Find Dating Users by Iq")
    @ParameterizedTest
    @MethodSource("iqList")
    void iqListTest(DatingUser[] users, int lowerIqBound, int professorIq, List<DatingUser> expected) {
        List<String> actual = BinarySearch.findUsers(users, lowerIqBound, professorIq);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> phones() {
        final long[] phonesAscOrder = new long[]{
                79205164259L,
                79253732813L,
                79652296233L,
                79652308638L,
                79657296331L,
                79657296362L,
                79660147811L,
                79662068477L,
                79915101427L
        };

        final long[] phonesDescOrder = new long[]{
                79915101427L,
                79662068477L,
                79660147811L,
                79657296362L,
                79657296331L,
                79652308638L,
                79652296233L,
                79253732813L,
                79205164259L,
        };

        return Stream.of(
                Arguments.of(new long[0], 123, -1),
                Arguments.of(new long[]{321}, 321, 0),
                Arguments.of(new long[]{123}, 321, -1),
                Arguments.of(phonesAscOrder, 79876543210L, -1),
                Arguments.of(phonesAscOrder, 79205164259L, 0),
                Arguments.of(phonesAscOrder, 79657296331L, 4),
                Arguments.of(phonesAscOrder, 79915101427L, 8),
                Arguments.of(phonesAscOrder, 79205164259L, 0),
                Arguments.of(phonesDescOrder, 79876543210L, -1),
                Arguments.of(phonesDescOrder, 79915101427L, 0),
                Arguments.of(phonesDescOrder, 79657296331L, 4),
                Arguments.of(phonesDescOrder, 79205164259L, 8)
        );
    }

    @DisplayName("Find Phone Number")
    @ParameterizedTest
    @MethodSource("phones")
    void searchPhoneTest(long[] phones, long phone, int expected) {
        int actual = BinarySearch.findPhoneNumber(phones, phone);
        assertEquals(expected, actual);
    }
}
