package homework.InsertionPlace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UrbanDictionary {

    private final List<String> newRussianDictionary = new ArrayList<>();

    // Как и в любом словаре, у вас слова идут строго порядку.
    // Напишите функцию, которая будет вставлять в словарь новые слова

    public void insertNewWord(String word) {

        var index = findIndexToInsert(word);

        var newDictionary = new String[newRussianDictionary.size() + 1];

        for (int i = 0; i < newDictionary.length; i++) {
            if (i < index) {
                newDictionary[i] = newRussianDictionary.get(i);
            } else if (index == i) {
                newDictionary[i] = word;
            } else {
                newDictionary[i] = newRussianDictionary.get(i - 1);
            }
        }

        newRussianDictionary.clear();
        Collections.addAll(newRussianDictionary, newDictionary);
    }

    private int findIndexToInsert(String word) {
        var left = 0;
        var right = newRussianDictionary.size();

        while (left < right) {

            var middle = (left + right) / 2;
            int compare = newRussianDictionary()[middle].compareTo(word);

            if (compare < 0) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return left;
    }

    public String[] newRussianDictionary() {
        return newRussianDictionary.toArray(String[]::new);
    }
}
