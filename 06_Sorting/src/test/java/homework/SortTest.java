package homework;

import homework.SortAlgorithms.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SortTest {
    static Stream<int[]> bubbleSortData() {
        return Stream.of(
                new int[]{334934939, 1234122, 657657},
                new int[]{},
                new int[]{1},
                new Random().ints(10_000).toArray());
    }

    static Stream<int[]> selectionSortData() {
        return Stream.of(
                new int[]{3, 2, 1},
                new int[]{},
                new int[]{1},
                IntStream.iterate(100, x -> x > 0, x -> (x - 1)).toArray());
    }

    @DisplayName("Bubble sort")
    @ParameterizedTest(name = "Sorting #{index}")
    @MethodSource("bubbleSortData")
    void bubbleSortTest(int[] array) {
        var userArray = Arrays.copyOf(array, array.length);
        Arrays.sort(array);
        BubbleSort.sort(userArray);
        Assertions.assertArrayEquals(array, userArray);
    }

    @DisplayName("Selection sort")
    @ParameterizedTest(name = "Sorting #{index}")
    @MethodSource("selectionSortData")
    void selectionSortTest(int[] array) {
        var arr = new Arr(array);
        SelectionSort.sort(arr);
        assertEquals(array.length * 2, arr.getIteration());
    }

    @Test
    @DisplayName("Insertion sort")
    void insertionSortTest() {
        var listOfAnimals = List.of(
                new ZooAnimal(100, "Zebra Fibi"),
                new ZooAnimal(505, "Lion Gunter"),
                new ZooAnimal(5, "Meerkat Joe"),
                new ZooAnimal(100, "Zebra Monika"),
                new ZooAnimal(50, "Deer Ross"),
                new ZooAnimal(5, "Meerkat Chandler")
        );
        var arr = listOfAnimals.toArray(ZooAnimal[]::new);
        var userArr = listOfAnimals.toArray(ZooAnimal[]::new);

        InsertionSort.sort(userArr);
        ZooAnimal.sort(arr);
        assertArrayEquals(arr, userArr);
    }

    @Test
    @DisplayName("Counting sort")
    void countingSortTest() {
        var array = new Random().ints(10_000_000, 1, 100).toArray();
        var userArray = Arrays.copyOf(array, array.length);

        var start = System.currentTimeMillis();
        Arrays.sort(array);
        var quickSort = System.currentTimeMillis() - start;

        start = System.currentTimeMillis();
        CountingSort.sort(userArray, 100);
        var countingSort = System.currentTimeMillis() - start;

        assertTrue((quickSort / countingSort) > 2);
    }


    private static class Arr implements SuperArray {
        private final int[] array;
        int iteration = 0;

        public Arr(int[] array) {
            this.array = array;
        }

        @Override
        public int getSize() {
            return array.length;
        }

        @Override
        public int get(int position) {
            return array[position];
        }

        @Override
        public void set(int position, int value) {
            iteration++;
            array[position] = value;
        }

        public int getIteration() {
            return iteration;
        }
    }

    private static class ZooAnimal implements Animal {
        private final int weight;
        private final String name;

        public ZooAnimal(int weight, String name) {
            this.weight = weight;
            this.name = name;
        }

        @Override
        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "ZooAnimal{" +
                    "weight=" + weight +
                    ", name='" + name + '\'' +
                    '}';
        }

        public static void sort(Animal[] array) {
            for (int left = 0; left < array.length; left++) {
                Animal value = array[left];
                int i = left - 1;
                for (; i >= 0; i--) {
                    if (value.getWeight() < array[i].getWeight()) {
                        array[i + 1] = array[i];
                    } else {
                        break;
                    }
                }
                array[i + 1] = value;
            }
        }
    }
}
