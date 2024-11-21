package examples.UniqueNumbers;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.util.List;
import java.util.Random;

import static examples.UniqueNumbers.Example.findUnique;
import static java.lang.System.out;

class Benchmark {

    private static long[] generateRandom(int size) {
        long[] arr = new long[size];
        Random f = new Random(System.currentTimeMillis());
        for (int i = 0; i < size; i++) {
            arr[i] = f.nextLong();
        }
        return arr;
    }

    public static void main(String[] args) {
        int totalUnique = 0;

        // Make it like 30-50 for faster results,
        // 100 iterations may take ~5-10 minutes
        int totalIterations = 100;
        double[] sizes = new double[totalIterations];
        double[] durations = new double[totalIterations];
        int size = 100;

        out.printf("Running %d iterations,\nHang on, this will take a while...\n", totalIterations);
        for (int i = 0; i < totalIterations; i++) {

            long[] testArray = generateRandom(size);
            long start = System.currentTimeMillis();
            List<Long> unique = findUnique(testArray);
            long duration = System.currentTimeMillis() - start;

            sizes[i] = size;
            durations[i] = duration;
            totalUnique += unique.size();
            size += 1000;

            out.printf("(%d/%d) findUnique([%d elements]) took %d milliseconds\n", i, totalIterations, size, duration);
        }

        XYChart chart = QuickChart.getChart("Does it look like N^2 / 2?", "Size", "Time", "time(size)", sizes, durations);


        SwingWrapper wrapper = new SwingWrapper<>(chart);
        wrapper.displayChart();
        out.printf("Total unique numbers = %d\n", totalUnique);
    }
}
