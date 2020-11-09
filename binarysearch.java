import java.util.*;
public class binarysearch{
	public static void sort(int arr[]){
		int n =arr.length;

		for(int i =0;i<n-1;i++){
			int least = i;
			for(int k =i;k<n;k++){
				if(arr[k]<arr[least]){
					least =k;
				}
			}
			int temp = arr[least];
			arr[least] = arr[i];
			arr[i] = temp;
			}
	}
	public static void binary(int arr[],int n,int first,int last,int search){
		int mid = (first+last)/2;
		while(first<=last){
		
		
		 if(search <arr[mid]){
			last=mid-1;
		}
		else if(search==arr[mid]){
			System.out.println("Found the element.");
         break;
}
		else if(search >mid){
			first = mid+1;
		}
		mid =(first + last)/2;

if(first>last){
	System.out.println("Element is not found");
}

	}


	}
	public static void main(String [] args){
	  	binarysearch obj = new binarysearch();

		int [] arr= {4,5,7,1,9,3};
		int n= arr.length;
		obj.sort(arr);
		for(int i=0;i<n;i++){
		System.out.println(" "+arr[i]);
		}
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter the element you want to search: ");
		int search = ob.nextInt();
		obj.binary(arr,n,0,3,search);
	}
		
}