package nl.saxion.concurrency.assignment1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Generator {

    //Generates array of integers with specified size.
    public int[] array(Integer size){
        Random random = new Random();
        int[] array = new int[size];
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000000);
        }

        return array;
    }
}
