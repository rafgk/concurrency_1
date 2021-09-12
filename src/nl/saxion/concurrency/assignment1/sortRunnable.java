package nl.saxion.concurrency.assignment1;

public class sortRunnable implements Runnable {
    private Sort sort = new Sort();
    private int[] array;
    public sortRunnable(int[] array){
        this.array = array;
    }

    public void run(){
        array = sort.insertionSort(array);
    }

    public int[] getResult(){
        return array;
    }

}
