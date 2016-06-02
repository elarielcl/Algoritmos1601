import java.util.Arrays;
import java.util.Random;

public class Seleccionar {

	static int seleccionar(int[] a, int k) {
		if (a == null || k>a.length || k<1) return Integer.MIN_VALUE;
		int[] temp =  Arrays.copyOf(a, a.length); // Arreglo temporal para no modificar "a"
		Arrays.sort(temp); // Java implementa ordenacion con QuickSort utilizando 2 pivotes para particionar
		return temp[k-1]; // Arreglos en Java empiezan en 0
	}
	
	static int seleccionarRapido(int[] a, int k) {
		if (a == null || k>a.length || k<1) return Integer.MIN_VALUE;
		int[] temp =  Arrays.copyOf(a, a.length); // Arreglo temporal para no modificar "a"
		
		int lo = 0, hi = temp.length - 1;
        while (hi > lo) {
            int i = particionar(a, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i-1];
        }
        return a[lo-1];
	}
	
	static int particionar(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        
        //Eleccion del pivote
        int ip = new Random().nextInt(hi-lo+1) + lo;
        int temp = a[lo];
        a[lo] = a[ip];
        a[ip] = temp;
        
	    int p = a[lo];
        while (true) { 
            // Avanzar i
            while (a[++i] < p)
                if (i == hi) break;

            // Avanzar j
            while (p < a[--j])
                if (j == lo) break;

            if (i >= j) break;

            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        // Poner el pivote en su posicion
        temp = a[lo];
        a[lo] = a[j];
        a[j] = temp;
        return j;
    }
	
	
	
	public static void main(String[] args) {
		final int[] a = {2, 5, 3, 1, 8, 9, 4, 7, 6};
		System.out.println(seleccionar(a, 2));
		System.out.println(seleccionar(a, 4));
		
		System.out.println(seleccionarRapido(a, 2));
		System.out.println(seleccionarRapido(a, 4));
	}

}

