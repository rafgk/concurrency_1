package nl.saxion.concurrency.assignment1;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class Task4 {

    public static int[] sortArray(int[] array, int threshold){
        TreeRunnable treeRunnable = new TreeRunnable(array, threshold);
        Thread thread = new Thread(treeRunnable);

        thread.start();
        try{
            thread.join();
        }catch(Exception e){
            System.err.println(e);
        }

        return treeRunnable.getResult();


    }

    public static void main(String[] args) {
        Generator generator = new Generator();
        //The array sizes for each test
        int[] tests = new int[]{50000, 10000,1000, 500,50};
        //Each test is an entry in the array list.
        //Each entry has ten results from the calculations
        
        for(int test = 0; test < tests.length; test++){
            int arraySize = 100000;
            int threshold = tests[test];

            System.out.println("Threshold: " + threshold );
            
            //The array of integers to be sorted
            var array = generator.array(arraySize);
            //The array of the results
            var times = new Long[10];
   
            for(int i= 0;i< 10; i++){
                //System.out.println( "Sorted at start:" + sort.isSorted(array));

                var start = Instant.now();

                sortArray(array, threshold);
                
                var end = Instant.now();
                times[i] = Duration.between(start, end).toMillis(); 
            }

            System.out.println(Arrays.toString(times));   
        }
    }

}
