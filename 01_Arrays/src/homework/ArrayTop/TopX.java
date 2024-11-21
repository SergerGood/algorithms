package homework.ArrayTop;

import java.util.Arrays;

class TopX {

    private static int findMaxUnderBoundary(int[] inputArray, boolean[] processed) {

        var foundIndex = -1;

        // Найдем текущий максимум
        int currentMax = Integer.MIN_VALUE;
        for (int k = 0; k < inputArray.length; k++) {
            // Рассмотрим только те элементы, которые меньше заданного числа
            if (inputArray[k] > currentMax && !processed[k]) {
                currentMax = Math.max(currentMax, inputArray[k]);
                foundIndex = k;
            }
        }

        if (foundIndex != -1) {
            processed[foundIndex] = true;
        }

        return currentMax;
    }

    public static int[] findTopElements(int[] inputArray, int numberOfElements) {

        if (numberOfElements < 1) {
            return new int[0];
        }

        // Создадим массив для результата
        int[] topElements = new int[numberOfElements];

        boolean[] processed = new boolean[inputArray.length];

        // Выполним цикл столько раз, сколько максимумов нам нужно найти
        for (int i = 0; i < numberOfElements; i++) {
            // Найдем текущий максимум
            topElements[i] = findMaxUnderBoundary(inputArray, processed);
        }
        return topElements;
    }

    private static int findMinUnderBoundary(int[] inputArray, int bottomBoundary) {

        int currentMin = Integer.MAX_VALUE;
        for (int k : inputArray) {
            if (k > bottomBoundary) {
                currentMin = Math.min(currentMin, k);
            }
        }
        return currentMin;
    }

    public static int[] findBottomElements(int[] inputArray, int numberOfElements) {

        int[] bottomElements = new int[numberOfElements];
        int previousMin = Integer.MIN_VALUE;

        for (int i = 0; i < numberOfElements; i++) {
            int currentMin = findMinUnderBoundary(inputArray, previousMin);
            previousMin = currentMin;
            bottomElements[i] = currentMin;
        }

        return bottomElements;
    }

    public static void main(String[] args) {
        int[] array = new int[]{10, 66, 4, 16, 99, 35, 11, 123};

        int[] top5 = findTopElements(array, 5);
        System.out.println("Top 5: " + Arrays.toString(top5));


        int[] top8 = findTopElements(array, 8);
        System.out.println("Top 8: " + Arrays.toString(top8));
    }
}
