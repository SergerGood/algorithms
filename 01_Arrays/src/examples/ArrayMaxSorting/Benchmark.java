package examples.ArrayMaxSorting;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

class Benchmark {
    public static void main(String[] args) {
        int count = 10000000;
        int[] arr = new int[count];
        Random f = new Random(System.currentTimeMillis());
        for (int i = 0; i < count; i++) {
            arr[i] = f.nextInt();
        }
        long startTime = System.currentTimeMillis();

//        Arrays.sort(arr);
//        int maxAge = arr[arr.length - 1];
//        out.println(maxAge);

//        int maxAge = 0;
//        for (int i = 0; i < arr.length; i++) {
//            maxAge = Math.max(maxAge, arr[i]);
//        }
//        out.println(maxAge);


        long duration = System.currentTimeMillis() - startTime;
        //String.format()
        out.printf("It took %.3f seconds to sort %d elements\n", duration / 1000f, count);
        out.printf("Sorted: [ %d, %d, ... %d, %d ]\n\n", arr[0], arr[1], arr[arr.length - 2], arr[arr.length - 1]);
    }
}
