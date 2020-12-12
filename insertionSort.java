import java.util.Scanner;
public class insertionSort

{
	public static int[] insertionSort(int[] arr)
	{
		arr = arr;

		for(int i=1;i<arr.length;i++)
		{
			for(int x=i;x>0 && compare(x-1,x,arr);x--)
			{
				swap(x-1,x,arr);
			}
		}
		return arr;
	}
	public static boolean compare(int a, int b,int[] arr)
	{
		if(arr[a]>arr[b])
		{
			return true;
		}
		return false;
	}
	public static void swap(int a, int b, int[] arr)
	{
		int j = arr[a];
		arr[a] = arr[b];
		arr[b] = j;
	}
	public static void main(String[] args)
	{
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the length of your array: ");

		int length = obj.nextInt();
		int arr[] = new int[length];

		System.out.println("Enter your elements: ");

		for(int x=0;x<length;x++)
		{
			int a = obj.nextInt();
			arr[x] = a;
		}
		System.out.println("Unsorted elements: ");
		for(int j=0;j<length;j++)
		{
			System.out.print(arr[j]+" ");
		}
		System.out.println(" ");
		System.out.println("Sorted element: ");
		insertion obj1 = new insertion();

		int[] value = obj1.insertionSort(arr);

		for(int j=0;j<length;j++)
		{
			System.out.print(value[j]+" ");
		}
	}
}