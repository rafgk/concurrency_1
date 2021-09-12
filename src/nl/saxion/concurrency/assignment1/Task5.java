package nl.saxion.concurrency.assignment1;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Task5 {
    public static void main(String[] args) {
        Generator generator = new Generator();
        Sort sort = new Sort();
        //The array sizes for each test
        int[] tests = new int[]{50000, 10000,1000, 500,50};

        for(int test = 0; test < tests.length; test++){
            int threshold = tests[test];

            System.out.println("Starting test with " + threshold + " threshold");
            
            //The array of integers to be sorted
            var arraySize = 100000;
            var array = generator.array(arraySize);
            //The array of the results
            var times = new Long[10];

            for(int i= 0;i< 10; i++){
                var tempArr = Arrays.copyOf(array, arraySize);

                ForkJoinPool pool = ForkJoinPool.commonPool();
                
                //Start timer
                var start = Instant.now();

                SortTask task = new SortTask(tempArr, threshold);
                pool.execute(task);

                int[] outArray = new int[arraySize];
                try {
                    outArray = task.get();         
                } catch (Exception e) {
                    System.out.println(e);
                }

                //End timer
                var end = Instant.now();
                //Check if array is actually sorted
                System.out.println("Out sorted: "+ sort.isSorted(outArray));

                times[i] = Duration.between(start, end).toMillis(); 
            }

            System.out.println(Arrays.toString(times));


        }
    }
}
