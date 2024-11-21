package examples.UniqueNumbers;

import java.util.ArrayList;
import java.util.List;

class Example {

    /*
        Запустите Benchmark чтобы посмотреть сколько времени занимает выполнение этого кода
    */
    static List<Long> findUnique(long[] phoneNumbers) {
        // Заведем список уникальных номеров, "Блокнотик"
        List<Long> uniqueNumbers = new ArrayList<>();

        // Пройдемся циклом по нашим номерам
        for (long currentNumber : phoneNumbers) {

            // Проверим есть ли уже этот номер в "Блокнотике"
            boolean alreadyExists = false;
            for (Long existingNumber : uniqueNumbers) {
                if (currentNumber == existingNumber) {
                    alreadyExists = true;
                    break;
                }
            }

            // Если его там нет — то добавим
            if (!alreadyExists) {
                uniqueNumbers.add(currentNumber);
            }
        }
        return uniqueNumbers;
    }

    public static void main(String[] args) {
        long[] phoneNumbers = new long[]{+79161002030L, +79255558877L, +79219990000L, +79161002030L};
        List<Long> uniqueNumbers = findUnique(phoneNumbers);
        System.out.println("Unique numbers: " + uniqueNumbers);
    }
}

/*
    ————————————————————————
    —— Подумать на досуге ——
    ————————————————————————

    Этот пример можно решить многими способами,
    здесь мы намеренно рассматриваем самый явный и примитивный подход,
    чтобы разобраться во времени выполнения этого кода.

    Как бы вы переписали этот кода с использованием всех ваших знаний?
    Как бы изменилось время выполнения этого кода?

*/


/*
 * 1. В этом примере мы используем ArrayList а не обычный массив long[],
 * т.к. В Java такие массивы всегда фиксированного размера.
 *
 * Здесь мы заранее не знаем сколько уникальных номеров у нас должно получиться,
 * поэтому мы используем “динамический” массив ArrayList,
 * в который можно добавить сколько угодно элементов.
 *
 * Массивы фиксированного размера характерны для таких языков как Java, C, C++, C#,
 * и практически не встречаются в Python, PHP и JS.
 *
 * Немного позже мы еще вернемся к обсуждению устройства и свойств динамических массивов.
 *
 * Сейчас важно понимать, что для решения этой задачи мы будем использовать именно их.
 *
 *
 * 2. Для простой итерации по массиву, когда индексы элементов для нас не важны,
 * в Java используется упрощенный синтаксис for(variable : array),
 * похожая конструкция есть в большинстве других языков программирования.
 *
 * 3. В строке 19 мы сравниваем Long и long,
 * currentNumber == existingNumber
 * Знатоки Java обратят внимание, что в этот момент произойдет unboxing.
 */
