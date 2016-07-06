public class MergeSort implements Ordenacion {

	@Override
	public void ordenar(int[] a) {
		ordenar(a, 0, a.length-1);
	}

	private static void ordenar(int[] a, int i, int j) {
		if (j <= i) return;
		
		int m = i + (j - i)/2;
		
		ordenar(a, i, m);
		ordenar(a, m+1, j);
		merge(a, i, j);
	}

	private static void merge(int[] a, int i, int j) {
		int m = i + (j - i)/2;
		int[] primera = new int[m-i+1];
		int[] segunda = new int[j-m];
		
		int k;
		for (k=i; k <= m; ++k) 
			primera[k-i] = a[k];
		for (; k <= j; ++k)
			segunda[k-m-1] = a[k];
		
		int x = 0, y = 0;
		for (k=i; k<=j; ++k) {
			if (x >= primera.length) a[k] = segunda[y++];
			else if (y >= segunda.length) a[k] = primera[x++];
			else if (primera[x] < segunda[y]){
				a[k] = primera[x++];
			}
			else a[k] = segunda[y++];
		}
	}
}
