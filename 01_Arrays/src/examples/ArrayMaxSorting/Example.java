package examples.ArrayMaxSorting;

import java.util.Arrays;

import static java.lang.System.out;

class Example {
    public static void main(String[] args) {
        // Объявим массив, который будет содержать, например, возраста всех членов семьи.

        int[] ages = new int[]{49, 31, 19, 66, 94, 27, 15};

        // Функция Arrays.sort отсортирует этот массив по возрастанию,
        // в начале будет самый маленький элемент, а в конце самый большой
        Arrays.sort(ages);

        //Теперь нам достаточно всего лишь взять последний элемент
        // (т.к. индексы начинаются с нуля, то индекс последнего элемента - это длина массива минус один).
        int maxAge = ages[ages.length - 1]; //будет равен 94

        out.println(maxAge);

    }
}