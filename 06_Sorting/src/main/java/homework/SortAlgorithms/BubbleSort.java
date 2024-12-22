package homework.SortAlgorithms;

public class BubbleSort {
    //Реализовать метод сортировки пузырьком
    public static void sort(int[] array) {
        boolean found = false;

        for (int j = 0; j < array.length - 1; j++) {
            for (int i = 0; i < array.length - 1 - j; i++) {
                if (array[i] > array[i + 1]) {

                    var tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;

                    found = true;
                }
            }

            if (!found) {
                break;
            }
        }
    }
}