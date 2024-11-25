package homework.Duplicates;

import java.util.Random;

public class RandomSort {
    public static boolean myIsSorted(int[] array) {

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }

        return true;
    }


    public static void randomSort(int[] array) {

        while (!myIsSorted(array)) {

            Random random = new Random();

            var someElementIndex = random.nextInt(array.length);
            var someOtherElementIndex = random.nextInt(array.length);

            var someElement = array[someElementIndex];
            var someOtherElement = array[someOtherElementIndex];

            array[someOtherElementIndex] = someElement;
            array[someElementIndex] = someOtherElement;
        }
    }
}
