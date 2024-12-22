package homework.SortAlgorithms;

public class CountingSort {
    // реализовать метод сортировки подсчетом
    public static void sort(int[] array, int maxValue) {
        var cnt = new int[maxValue];

        for (int i = 0; i < array.length; i++) {
            cnt[array[i]] += 1;
        }

        var position = 0;
        for (int i = 0; i < cnt.length; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                array[position] = i;
                position++;
            }
        }
    }
}
