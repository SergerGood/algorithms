package examples.ArrayMaxDynamic;

import static java.lang.System.out;

class MaxDynamic {
    public static void main(String[] args) {
        // Возьмем тот же массив что и в примере с сортировкой
        int[] ages = new int[]{49, 31, 19, 66, 94, 27, 15};

        int maxAge = 0;

        // И пройдем по нему циклом for
        for (int i = 0; i < ages.length; i++) {
            // На каждом шаге будем обновлять текущий максимум
            maxAge = Math.max(maxAge, ages[i]);
        }

        // В итоге в maxAge будет абсолютный максимум
        out.printf("MaxAge = %d\n", maxAge);

    }
}
