package homework.BacktrackingRecursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BruteForceRecursion {

    // Task #1
    public static List<List<Integer>> orderOfReleaseFeatures(int[] numbersOfFeatures) {
        List<List<Integer>> result = new ArrayList<>();
        gen(numbersOfFeatures, 0, result);

        return result;
    }

    private static void gen(int[] numbersOfFeatures, int index, List<List<Integer>> result) {
        if (index == numbersOfFeatures.length) {
            List<Integer> resultRow = new ArrayList<>();
            for (int num : numbersOfFeatures) {
                resultRow.add(num);
            }
            result.add(resultRow);
            return;
        }

        for (int i = index; i < numbersOfFeatures.length; i++) {
            swap(numbersOfFeatures, i, index);
            gen(numbersOfFeatures, index + 1, result);
            swap(numbersOfFeatures, i, index);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Task #2
    public static boolean checkPowersOfThree(int number) {
        if (number == 0) {
            return true;
        }

        if (number % 3 > 1) {
            return false;
        }

        return checkPowersOfThree(number / 3);
    }

    // Task #3
    public static List<String> possibleMessages(String digits) {

        digitToPossibleLetters.put(0, new char[0]);
        digitToPossibleLetters.put(1, new char[0]);
        digitToPossibleLetters.put(2, "abc".toCharArray());
        digitToPossibleLetters.put(3, "def".toCharArray());
        digitToPossibleLetters.put(4, "ghi".toCharArray());
        digitToPossibleLetters.put(5, "jkl".toCharArray());
        digitToPossibleLetters.put(6, "mno".toCharArray());
        digitToPossibleLetters.put(7, "pqrs".toCharArray());
        digitToPossibleLetters.put(8, "tuv".toCharArray());
        digitToPossibleLetters.put(9, "wxyz".toCharArray());

        List<String> result = new ArrayList<>();
        generateSymbols(digits, 0, new StringBuilder(), result);

        return result;
    }

    private static void generateSymbols(String digits, int index, StringBuilder row, List<String> result) {
        if (digits.isEmpty()) {
            return;
        }

        if (index == digits.length()) {
            result.add(row.toString());
            return;
        }

        var digit = Character.getNumericValue(digits.charAt(index));
        var letters = digitToPossibleLetters.get(digit);

        for (char symbol : letters) {
            row.append(symbol);
            generateSymbols(digits, index + 1, row, result);
            row.deleteCharAt(row.length() - 1);
        }
    }

    // This can be a hashtable, any structure to map 'number' to 'letters' it can manifest as
    private static HashMap<Integer, char[]> digitToPossibleLetters = new HashMap<>();
}
