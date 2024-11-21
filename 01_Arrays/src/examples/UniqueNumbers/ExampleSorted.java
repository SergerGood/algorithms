package examples.UniqueNumbers;

import java.util.ArrayList;
import java.util.List;

class ExampleSorted {

    /*
        Запустите BenchmarkSorted чтобы посмотреть сколько времени занимает выполнение этого кода
    */
    static List<Long> findUniqueSorted(long[] phoneNumbers) {
        List<Long> uniqueNumbers = new ArrayList<>();
        // Возьмем самый первый элемент
        long prevNumber = phoneNumbers[0];

        // И начнем двигаться по массиву начиная со второго элемента
        for (int i = 1; i < phoneNumbers.length; i++) {
            // Как только текущий элемент не равен предыдущему —
            // Бинго! Предыдущий элемент уже можно записывать как уникальный
            if (phoneNumbers[i] != prevNumber) {
                uniqueNumbers.add(prevNumber);
                prevNumber = phoneNumbers[i];
            }
        }

        // В конце у нас останется последний элемент массива,
        // нужно не забыть его тоже положить в массив уникальных элементов
        uniqueNumbers.add(prevNumber);
        return uniqueNumbers;
    }

    /*
        ————————————————————————
        —— Подумать на досуге ——
        ————————————————————————

        Заметьте, что нам нужно последовательно сравнивать пары элементов массива.
        Нулевой с первым, первый со вторым, второй с третьим и т.д.
        Это классическая подзадача, которая постоянно встречается в разных алгоритмах,
        и решать ее можно по-разному.

        Один из способов это итерация не по всему массиву,
        а например начиная с индекса 1 (как в этом примере),
        или наоборот итерация не до конца а только до предпоследнего элемента.


        Также можно итерироваться с начала и до конца,
        но предусмотреть специальные условия в теле цикла для первого или последнего элемента.
        (Упражнение на разминку мелкой кодерской моторики)

        Попробуйте переписать алгоритм с использованием циклов:

        (1)  for(int i=0; i<phoneNumbers.length - 1; i++)
        (2)  for(int i=0; i<phoneNumbers.length; i++)

     */
    public static void main(String[] args) {
        long[] phoneNumbers = new long[]{
                +79000000000L, +79000000000L,
                +79000000001L,
                +79000000002L, +79000000002L,
                +79000000003L, +79000000003L, +79000000003L, +79000000003L,
                +79000000004L
        };

        List<Long> uniqueNumbers = findUniqueSorted(phoneNumbers);
        System.out.println("Unique numbers: " + uniqueNumbers);
    }
}
