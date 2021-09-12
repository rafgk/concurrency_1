package nl.saxion.concurrency.assignment1;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class SortTask extends RecursiveTask<int[]> {
    private int[] array;
    private int threshold;

    public SortTask(int[] array, int threshold){
        this.array = array;
        this.threshold = threshold;
    }
    
    @Override
    protected int[] compute(){
        Sort sort = new Sort();

        if(array.length > threshold){
            var array1 = Arrays.copyOfRange(array, 0, array.length/2);
            var array2 = Arrays.copyOfRange(array,array.length/2 , array.length);
            
            var leftTask = new SortTask(array1,threshold);
            var rightTask = new SortTask(array1,threshold);

            leftTask.fork();
            rightTask.fork();

            array1 = leftTask.join();
            array2 = rightTask.join();

            return sort.merge(array1, array2);

        }else{
            return sort.insertionSort(array);
        }
    }
}
