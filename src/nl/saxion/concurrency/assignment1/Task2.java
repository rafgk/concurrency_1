package nl.saxion.concurrency.assignment1;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        Generator generator = new Generator();
        Sort sort = new Sort();
        //The array sizes for each test
        int[] tests = new int[]{25000,50000,100000, 200000, 400000};
        //Each test is an entry in the array list.
        //Each entry has ten results from the calculations

        for(int test = 0; test < tests.length; test++){
            int arraySize = tests[test];

            System.out.println("Starting test with " + arraySize + " array entries");
            
            //The array of integers to be sorted
            var array = generator.array(arraySize);
            //The array of the results
            var times = new Long[10];

            //Split the array in two parts
            var array1 = Arrays.copyOfRange(array, 0, (arraySize+1)/2);
            var array2 = Arrays.copyOfRange(array,(arraySize+1)/2 , arraySize);

            
            for(int i= 0;i< 10; i++){

                var tempArr1 = Arrays.copyOf(array1,array1.length);
                var tempArr2 = Arrays.copyOf(array2,array2.length);

                var start = Instant.now();

                tempArr1 = sort.bubbleSort(tempArr1);
                tempArr2 = sort.bubbleSort(tempArr2);

                sort.merge(tempArr1, tempArr2);

                var end = Instant.now();
                times[i] = Duration.between(start, end).toMillis(); 
            }

            System.out.println(Arrays.toString(times));

            
        }
    }
}
