package examples.ArrayTop;

import java.util.Arrays;

class TopXExample {

    private static int findMaxUnderBoundary(int[] inputArray, int topBoundary) {

        // Найдем текущий максимум
        int currentMax = Integer.MIN_VALUE;
        for (int k = 0; k < inputArray.length; k++) {
            // Рассмотрим только те элементы, которые меньше заданного числа
            if (inputArray[k] < topBoundary) {
                currentMax = Math.max(currentMax, inputArray[k]);
            }
        }
        return currentMax;
    }

    private static int[] findTopElements(int[] inputArray, int numberOfElements) {

        // Создадим массив для результата
        int[] topElements = new int[numberOfElements];

        // Нам требуется знать предыдущее значение максимума,
        // По-умолчанию мы положим туда максимальное значение для типа int
        int previousMax = Integer.MAX_VALUE;

        // Выполним цикл столько раз, сколько максимумов нам нужно найти
        for (int i = 0; i < numberOfElements; i++) {
            // Найдем текущий максимум
            int currentMax = findMaxUnderBoundary(inputArray, previousMax);

            // Обновим значение "предыдущего" максимума
            previousMax = currentMax;

            // Положим результат в выходной массив
            topElements[i] = currentMax;
        }
        return topElements;
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 66, 4, 16, 99, 35, 11, 123};

        int[] top5 = findTopElements(array, 5);
        System.out.println("Top 5: " + Arrays.toString(top5));


        int[] top8 = findTopElements(array, 8);
        System.out.println("Top 8: " + Arrays.toString(top8));
    }
}
