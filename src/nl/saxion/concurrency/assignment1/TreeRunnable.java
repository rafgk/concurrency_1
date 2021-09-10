package nl.saxion.concurrency.assignment1;

import java.util.Arrays;

public class TreeRunnable implements Runnable {
    Sort sort = new Sort();
    int[] array;
    int threshold;

    public TreeRunnable(int[] array, int threshold){
        this.array = array;
        this.threshold = threshold;
    }

    public void run(){
        solve();
    }

    private void solve(){
        if(array.length <= threshold){
            array = sort.bubbleSort(array);
        }else{
            //split arrays
            int[] array1 = Arrays.copyOfRange(array, 0, (array.length+1)/2);
            int[] array2 = Arrays.copyOfRange(array,(array.length+1)/2 , array.length);

            TreeRunnable treeRunnable1 = new TreeRunnable(array1, threshold);
            TreeRunnable treeRunnable2 = new TreeRunnable(array2, threshold);


            Thread thread1 = new Thread(treeRunnable1);
            Thread thread2 = new Thread(treeRunnable2);

            thread1.start();
            thread2.start();

            try {
                thread1.join();
                thread2.join();   
            } catch (Exception e) {
                System.err.println(e);
            }

            //Get the results and merge the two arrays
            array = sort.merge(treeRunnable1.getResult(), treeRunnable2.getResult());

        }
    }

    public int[] getResult(){
        return array;
    }


}