package nl.saxion.concurrency.assignment1;

public class Sort {


    /**
     * Merge two sorted arrays into a new sorted array
     *
     * @param left array
     * @param right array
     * @return the sorted merge of left and right
     *
     * for an explanation of the algorithm see: https://www.baeldung.com/java-merge-sorted-arrays
     */
    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftPos = 0, rightPos= 0, mergedPos = 0;
        while(leftPos < left.length && rightPos < right.length) {
            if (left[leftPos] < right[rightPos]) {
                result[mergedPos++] = left[leftPos++];
            } else {
                result[mergedPos++] = right[rightPos++];
            }
        }
        while (leftPos < left.length) result[mergedPos++] = left[leftPos++];
        while (rightPos < right.length) result[mergedPos++] = right[rightPos++];
        return result;
    }


    /**
    * bubbleSort function.
    * Sorts the array in
    * @param arr unsorted array
    *
    * Copied from: https://www.javatpoint.com/bubble-sort-in-java
    */
    static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return arr;

    }


    public static int[] insertionSort(int[] array) {  
        int n = array.length;  
        for (int j = 1; j < n; j++) {  
            int key = array[j];  
            int i = j-1;  
            while ( (i > -1) && ( array [i] > key ) ) {  
                array [i+1] = array [i];  
                i--;  
            }  
            array[i+1] = key;  
        }
        return array;
    }
    /**
     *
     * @param arr sorted array
     * @return true if array is sorted otherwise false
     */
    static boolean isSorted(int[] arr) {
        for(int i =1; i < arr.length; i++) {
            if (arr[i-1] > arr[i]) return false;
        }
        return true;
    }

}
