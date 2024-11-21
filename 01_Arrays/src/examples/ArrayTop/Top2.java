package examples.ArrayTop;

import static java.lang.System.out;

class Top2 {
    public static void main(String[] args) {
        int[] ages = new int[]{49, 31, 19, 66, 94, 27, 15};

        int top1Age = 0;
        int top2Age = 0;

        // Найдем первый максимум в массиве
        for (int i = 0; i < ages.length; i++) {
            top1Age = Math.max(top1Age, ages[i]);
        }

        // Добавим второй проход по массиву
        // И рассмотрим только элементы, которые меньше первого максимума
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < top1Age) {
                top2Age = Math.max(top2Age, ages[i]);
            }
        }

        out.printf("First Max: %d\nSecond Max: %d\n", top1Age, top2Age);
    }
}
