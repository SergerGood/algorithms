package homework.Duplicates;

public class TextEditor {
    public static final char SPACE_CHAR = ' ';
    // Больше 255 символов в память не влезает =/
    public final char[] text = new char[255]; // Тип String ещё не изобрели :(
    public int textLength; // текущая длина текста в массиве text

    // Пустое место в этом массиве забито просто “пробелами”
    // Например, если textLength = 3, и text = ‘ш’,’к’,’я’, … еще 252 символа ‘пробел’

    public void insertCharacterAt(int position, char c) {

        if (position < 0 || position > textLength) {
            return;
        }

        for (int i = textLength; i > position; i--) {
            text[i] = text[i - 1];
        }

        text[position] = c;
        textLength++;
    }

    public void backspace(int position) {

        if (position < 0 || position > textLength) {
            return;
        }

        for (int i = position; i < textLength; i++) {
            text[i] = text[i + 1];
        }

        textLength--;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : text) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString().trim();
    }


    // Конструктор готов!
    public TextEditor() {
        textLength = 0;
        for (int i = 0; i < 255; i++) {
            text[i] = SPACE_CHAR;
        }
    }

    // Второй конструктор заполняет массив переданным текстом
    public TextEditor(String text) {
        this();
        for (int i = 0; i < Math.min(text.length(), this.text.length); i++) {
            this.text[i] = text.charAt(i);
        }
        textLength = text.length();
    }
}
