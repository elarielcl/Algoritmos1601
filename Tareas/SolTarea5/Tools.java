import java.util.Random;
public class Tools {
	
	static public int[] permutacion(int n) {
		 	int[] a = new int[n];
		 	for (int i = 0; i < n; ++i)
		 		a[i] = i+1;
		 	
		 	Random rnd = new Random();
		    for (int i = 0; i < n; i++) {
		        int r = i + rnd.nextInt(n-i);
		        int temp = a[i];
		        a[i] = a[r];
		        a[r] = temp;
		    }
		    return a;
	}
	
	static public int[] ascendente(int n) {
		int[] a = new int[n];
	 	for (int i = 0; i < n; ++i)
	 		a[i] = i+1;
	 	return a;
	}
}
