package nl.saxion.concurrency.assignment1;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        Generator generator = new Generator();
        Sort sort = new Sort();
        //The array sizes for each test
        int[] tests = new int[]{25000,50000,100000, 200000, 400000};
        //Each test is an entry in the array list.
        //Each entry has ten results from the calculations
        var results = new  ArrayList<Duration[]>();

        for(int test = 0; test < tests.length; test++){
            int arraySize = tests[test];

            System.out.println("Starting test with " + arraySize + " array entries");
            
            //The array of integers to be sorted
            var array = generator.array(arraySize);
            //The array of the results
            var times = new Long[10];

            for(int i= 0;i< 10; i++){
                var start = Instant.now();

                sort.bubbleSort(array);

                var end = Instant.now();
                times[i] = Duration.between(start, end).toMillis(); 
            }

            System.out.println(Arrays.toString(times));


        }
    }
}
