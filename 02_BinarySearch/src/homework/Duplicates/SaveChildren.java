package homework.Duplicates;

import java.util.Arrays;

public class SaveChildren {
    public static void permutateWords(char[][] words) {

        var duplicateIndex = foundDuplicateIndex(words);

        while (duplicateIndex != -1) {
            var duplicateWord = words[duplicateIndex];

            var firstSymbol = duplicateWord[0];
            var lastSymbol = duplicateWord[duplicateWord.length - 1];

            duplicateWord[duplicateWord.length - 1] = firstSymbol;
            duplicateWord[0] = lastSymbol;

            duplicateIndex = foundDuplicateIndex(words);
        }
    }

    private static int foundDuplicateIndex(char[][] words) {
        var i = 0;

        while (i < words.length) {

            for (int k = i + 1; k < words.length; k++) {
                if (Arrays.equals(words[k], words[i])) {
                    return i;
                }
            }
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        char[][] words = new char[][] {
                {'ш', 'б', 'а', 'к', 'а' },
                {'к', 'а', 'т', 'e', 'н', 'к' },
                {'г', 'у', 'с', 'ъ', 'к' },
                {'ш', 'б', 'а', 'к', 'а' },
        };
        permutateWords(words);
    }
}
