public class BubbleSort{
	 void sort(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (arr[j] > arr[j+1]) 
                { 
                    // swap arr[j+1] and arr[j] 
                    int temp = arr[j]; 
                    arr[j] = arr[j+1]; 
                    arr[j+1] = temp; 
                } 
    } 

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println("Sorted");
    }

    public static void main(String args[])
    {
        int arr[] = {10, 11, 31, 43, 23, 32, 12, 13};
        BubbleSort s = new BubbleSort();
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println("Unsorted");

        s.sort(arr);
        printArray(arr);
    }
}


