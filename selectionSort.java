import java.util.Scanner;
public class selectionSort
{
	public static int[] sort(int[] array)
	{
		int n = array.length;
		for (int i=0;i<n-1;i++) 
		{
			int smallest = i;
			for (int j=i;j<n;j++)
			{
				if(array[j] < array[smallest])
					smallest = j;
			}
			int x = array[smallest];
			array[smallest] = array[i];
			array[i] = x;
		}
		return array;
	}
	public static void main(String[] args) 
	{
		Scanner obj = new Scanner(System.in);
		System.out.println("Enter the length: ");
		int len = obj.nextInt();
		int[] array = new int[len];
		System.out.println("Enter the element: ");
		for (int i=0;i<len;i++)
		{
			int b = obj.nextInt();
			array[i] = b;
		}

		selection obj1 = new selection();
		int[] x = obj1.sort(array);
		for (int j=0;j<len;j++) 
		{
			System.out.print(x[j]+" ");
		}
	}
}