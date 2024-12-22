package homework.SortAlgorithms;

public class SelectionSort {
    // реализовать метод сортировки выбором
    public static void sort(SuperArray array) {
        for (int i = 0; i < array.getSize(); i++) {
            var minIndex = i;
            for (int j = i + 1; j < array.getSize(); j++) {
                if (array.get(j) < array.get(minIndex)) {
                    minIndex = j;
                }
            }

            var current = array.get(i);
            array.set(i, array.get(minIndex));
            array.set(minIndex, current);
        }
    }
}
