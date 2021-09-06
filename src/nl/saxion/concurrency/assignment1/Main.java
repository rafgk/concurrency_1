package nl.saxion.concurrency.assignment1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Sort sort = new Sort();
        Generator generator = new Generator();

        var testArr = generator.array(5);
        System.out.println(Arrays.toString(testArr));
        testArr = sort.bubbleSort(testArr);
        System.out.println(Arrays.toString(testArr));
    }
}
