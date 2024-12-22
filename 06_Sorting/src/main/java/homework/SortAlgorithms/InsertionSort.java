package homework.SortAlgorithms;

public class InsertionSort {
    // реализовать метод сортировкой вставками
    public static void sort(Animal[] array) {
        for (int i = 0; i < array.length; i++) {
            var current = array[i];
            var position = i;
            for (position = i; (position > 0 && array[position - 1].getWeight() > current.getWeight()); position--) {
                array[position] = array[position - 1];
            }
            array[position] = current;
        }
    }
}
