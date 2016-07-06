import java.util.Arrays;
import java.util.Random;


public class Tiempos {

	static public int[] permutacion(int n) {
		int[] a = new int[n];
		for (int i = 0; i<n; ++i)
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
	
	public static void main(String[] args) {
		
		int n = 30000000;
		int[] merge = permutacion(n);
		int[] quick1 = Arrays.copyOf(merge, merge.length);
		int[] quick2 = Arrays.copyOf(merge, merge.length);
		int[] quick3 = Arrays.copyOf(merge, merge.length);
		
		long ini;
		
		
		ini = System.currentTimeMillis();
		new MergeSort().ordenar(merge);
		System.out.println("MergeSort = "+ (System.currentTimeMillis() - ini) + " milisegundos");
		
		ini = System.currentTimeMillis();
		new QuickSortClasico().ordenar(quick1);
		System.out.println("QuickSortClasico = "+ (System.currentTimeMillis() - ini) + " milisegundos");
		
		ini = System.currentTimeMillis();
		new QuickSortMediana().ordenar(quick2);
		System.out.println("QuickSortMediana = "+ (System.currentTimeMillis() - ini) + " milisegundos");
		
		ini = System.currentTimeMillis();
		new QuickSortMedianaInsercion().ordenar(quick3);
		System.out.println("QuickSortMedianaInsercion = "+ (System.currentTimeMillis() - ini) + " milisegundos");
		
	}
}
