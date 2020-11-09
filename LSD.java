public class LSD{
	public static void sort(){
		String a[] = {"sang", "pema", "ugye", "kinl"};
 		int N = a.length;
 		int W = a[0].length();
		int R = 256;
		String[] aux = new String[N];

		for(int i=0; i<N; i++){
 			System.out.println(a[i] + " ");
 		}

 		for (int d = W-1; d >= 0; d--){
			// Sort by key-indexed counting.
 			int[] count = new int[R+1];
			// Compute frequency counts.
			for (int i = 0; i < N; i++){
				count[a[i].charAt(d) + 1]++;
			}
			for (int r = 0; r < R; r++){
			// Transform counts to indices.
				count[r+1] += count[r];
			}
			for (int i = 0; i < N; i++){
			// Distribute.
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			for (int i = 0; i < N; i++){
			// Copy back.
		 		a[i] = aux[i];
		 	}
 		}
 		for(int i=0; i<N; i++){
 			System.out.println(a[i] + " ");
 		}
 	}
 	public static void main(String[] args){
 		sort();
 	}
}
