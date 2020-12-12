import java.util.Arrays;
import java.util.Random;

public class quick{
    public void quicksort(int[] A){
        quicksort(A, 0, A.length-1);
    }
    private void quicksort(int[] A, int low, int high){
        if (low < high+1){
            int p = partition(A, low, high);
            quicksort(A, low, p-1);
            quicksort(A, p+1, high);

        }
    }
    private void swap(int[] A,int index1,int index2){
        //return random pivot index between low and high inclusive.
        int temp = A[index1];
        A[index1] = A[index2];
        A[index2] = temp;
    }
    private int getPivot(int low,int high){
        Random rand = new Random();
        return rand.nextInt ((high-low) + 1)+ low;  
        //move all n < pivot to left of pivot and all n > pivot
        //to right of pivot, then return pivot index
    }
    private int partition(int[] A, int low, int high){
        swap(A, low, getPivot(low, high));
        int border = low + 1;
        for (int i = border; i <= high; i++){
            if (A[i] < A[low]){
                swap(A, i, border++);
            }
        }
        swap(A, low, border-1);
        return border-1;

    }
    public static void main(String[] args) {
        quick qs = new quick();
        int[] A = {5,4,7,9,1,0,12};
        System.out.println("Before Sorting(QuickSort): "+Arrays.toString(A));
        qs.quicksort(A);
        System.out.println("After Sorting(QuickSort): "+Arrays.toString(A));
    }
}