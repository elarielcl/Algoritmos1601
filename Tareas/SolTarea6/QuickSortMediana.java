import java.util.Random;


public class QuickSortMediana implements Ordenacion {
	static Random rnd = new Random();
	@Override
	public void ordenar(int[] a) {
		ordenar(a, 0, a.length-1);
	}

	private static void ordenar(int[] a, int i, int j) {
		if (j <= i) return;
        int k = particionar(a, i, j);
        ordenar(a, i, k-1);
        ordenar(a, k+1, j);
	}

	private static int particionar(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        //Eleccion del pivote
        int ip = seleccionar3Mediana(a, lo, hi);
        swap(a,lo,ip);

        int p = a[lo];
        while (true) {
            // Avanzar i
            while (a[++i] < p)
                if (i == hi) break;

            // Avanzar j
            while (p < a[--j])
                if (j == lo) break;

            if (i >= j) break;

            swap(a,i,j);
        }
        // Poner el pivote en su posicion
        swap(a,lo,j);

        return j;
    }

	private static int seleccionar3Mediana(int[] a, int lo, int hi) {
		int ip1 = rnd.nextInt(hi-lo+1) + lo;
		int ip2 = rnd.nextInt(hi-lo+1) + lo;
		int ip3 = rnd.nextInt(hi-lo+1) + lo;
		if (a[ip1] <= a[ip2] && a[ip2] <= a[ip3]) return ip2;
		else if (a[ip2] <= a[ip1] && a[ip1] <= a[ip3]) return ip1;
		return ip3;
	}
	
	private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
