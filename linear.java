public class linear
{
	public static void search()
	{
		int [] a ={3,6,4,5,2,8};
		int target = 2;
		int n = a.length;
		for (int i = 0; i < n; i++){
			if (a[i] == target) {
				System.out.println("target value is found = " +  a[i]);
				return;
			}
			else{
				System.out.println("Not found");
			}

		}
	}
	public static void main(String[] args) {
		search();
	}
}
