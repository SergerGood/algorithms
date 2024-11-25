package homework.HashFunctions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashFunctionsTest {

    static final String lorem = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
            "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco" +
            " laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate " +
            "velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt" +
            " in culpa qui officia deserunt mollit anim id est laborum.";

    static Stream<Arguments> strings() {
        return Stream.of(Arguments.of("a", 97),
                Arguments.of("aa", 194),
                Arguments.of(" ", 32),
                Arguments.of("skillbox", 872),
                Arguments.of("java", 418),
                Arguments.of("hello world", 1116),
                Arguments.of(lorem, 42248),
                Arguments.of(null, 0)
        );
    }

    @DisplayName("Hash строки")
    @ParameterizedTest
    @MethodSource("strings")
    void hashString(String string, int expectedHash) {
        assertEquals(expectedHash, HashFunctions.hashString(string), "wrong hash for string=<" + string + ">");
    }

    static Stream<Arguments> intHash() {
        return Stream.of(
                Arguments.of(234, 24),
                Arguments.of(342, 24),
                Arguments.of(423, 24),
                Arguments.of(0, 0),
                Arguments.of(100, 1),
                Arguments.of(-234, -24),
                Arguments.of(549, 180),
                Arguments.of(549_493_621, 233_280),
                Arguments.of(549_493_620, 233_280)
        );
    }

    @DisplayName("Hash числа")
    @ParameterizedTest
    @MethodSource("intHash")
    void hashIntValue(Integer integer, Integer expectedHash) {
        assertEquals(expectedHash, HashFunctions.hashInt(integer), "wrong hash for int=<" + integer + ">");
    }


}
