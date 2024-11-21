package examples.UniqueNumbers;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static examples.UniqueNumbers.ExampleSorted.findUniqueSorted;
import static java.lang.System.out;

class BenchmarkSorted {
    private static long[] generateRandomSorted(int size) {
        long[] arr = new long[size];
        Random f = new Random(System.currentTimeMillis());
        for (int i = 0; i < size; i++) {
            arr[i] = f.nextLong();
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        long totalUnique = 0;

        // Make it like 300-500 for faster results,
        // 1000 iterations may take ~5-10 minutes
        int totalIterations = 1000;
        double[] sizes = new double[totalIterations];
        double[] durations = new double[totalIterations];
        int size = 1000;

        out.printf("Running %d iterations,\nHang on, this will take a while...\n", totalIterations);
        for (int i = 0; i < totalIterations; i++) {

            long[] testArray = generateRandomSorted(size);
            long start = System.currentTimeMillis();
            List<Long> unique = findUniqueSorted(testArray);
            long duration = System.currentTimeMillis() - start;

            sizes[i] = size;
            durations[i] = duration;
            totalUnique += unique.size();
            size += 5000;

            out.printf("(%d/%d) findUniqueSorted([%d elements]) took %d milliseconds\n", i, totalIterations, size, duration);
        }

        XYChart chart = QuickChart.getChart("Wow, waaaat?", "Size", "Time", "time(size)", sizes, durations);


        SwingWrapper wrapper = new SwingWrapper<>(chart);
        wrapper.displayChart();
        out.printf("Total unique numbers = %d\n", totalUnique);
    }
}
