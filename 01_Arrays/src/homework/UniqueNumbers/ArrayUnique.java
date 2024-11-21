package homework.UniqueNumbers;

import java.util.ArrayList;
import java.util.List;

class ArrayUnique {
    static List<Character> lettersLearnedToday(String word) {

        List<Character> existingChars = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {

            char currentChar = word.charAt(i);
            boolean alreadyExist = false;

            for (char existingChar : existingChars) {
                if (existingChar == currentChar) {
                    alreadyExist = true;
                    break;
                }
            }

            if (!alreadyExist) {
                existingChars.add(currentChar);
            }
        }

        return existingChars;
    }

    static int avoidJailDueToTaxFraud(int[][] report) {

        List<Integer> uniqueSums = new ArrayList<>();

        for (int[] reportList : report) {

            for (int currentSum : reportList) {

                for (int uniqueSun : uniqueSums) {
                    if (uniqueSun == currentSum) {
                        return currentSum;
                    }
                }

                uniqueSums.add(currentSum);
            }
        }

        return -1;
    }
}
