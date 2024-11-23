package homeworkTests;

import homework.Duplicates.TextEditor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextEditorTest {

    static Stream<Arguments> textEditorInsert() {
        return Stream.of(
                Arguments.of("Приет мир!", new CharTyped[]{c('в', 3)}, "Привет мир!"),
                Arguments.of("", new CharTyped[]{c('П', 0)}, "П"),
                Arguments.of("", new CharTyped[]{c('П', 0), c('Р', 1), c('И', 2)}, "ПРИ"),
                Arguments.of("ПРИВЕТ, МИР", new CharTyped[]{c('!', 10)}, "ПРИВЕТ, МИР!"),
                Arguments.of("", new CharTyped[]{c('П', 0), c('Р', 0), c('И', 0)}, "ИРП"),
                Arguments.of("VVV", new CharTyped[]{c('R', 1), c('Y', 0), c('8', 2)}, "YV8RVV"),
                Arguments.of("SKLBX", new CharTyped[]{c('O', 4), c('I', 2), c('L', 3)}, "SKILLBOX"),
                Arguments.of("", new CharTyped[]{c('!', 100)}, ""),
                Arguments.of("SKILLBOX", new CharTyped[]{c('?', 1000)}, "SKILLBOX")
        );
    }

    @DisplayName("Text Editor Insert Character At")
    @ParameterizedTest
    @MethodSource("textEditorInsert")
    void printCharsTest(String startText, CharTyped[] printChars, String expected) {
        TextEditor textEditor = new TextEditor(startText);
        for (CharTyped charTyped : printChars) {
            textEditor.insertCharacterAt(charTyped.position, charTyped.ch);
        }

        assertEquals(expected, textEditor.toString(), "startText=[" + startText + "]"
                + " print history => " + Arrays.toString(printChars));
    }

    static Stream<Arguments> textEditorBackspace() {
        return Stream.of(
                Arguments.of("Привет мир!", new int[]{3}, "Приет мир!"),
                Arguments.of("Привет мир!", new int[]{3, 3, 3, 3, 3}, "Приир!"),
                Arguments.of("Привет мир!", new int[]{0, 1, 2}, "рвт мир!"),
                Arguments.of("Привет мир!", new int[]{100}, "Привет мир!"),
                Arguments.of("Привет мир!", new int[]{-1}, "Привет мир!")
        );
    }

    @DisplayName("Text Editor Backspace")
    @ParameterizedTest
    @MethodSource("textEditorBackspace")
    void backspaceTest(String startText, int[] backspacePositions, String expected) {
        TextEditor textEditor = new TextEditor(startText);
        for (int position : backspacePositions) {
            textEditor.backspace(position);
        }

        assertEquals(expected, textEditor.toString(), startText + " backspace history: " + Arrays.toString(backspacePositions));
    }

    private static final class CharTyped {
        public final char ch;
        public final int position;

        public CharTyped(char ch, int position) {
            this.ch = ch;
            this.position = position;
        }

        @Override
        public String toString() {
            return "{char=" + ch + ", pos=" + position + '}';
        }
    }

    public static CharTyped c(char ch, int position) {
        return new CharTyped(ch, position);
    }
}
