import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	static void quickSort(int[] a) {
		sort(a, 0, a.length-1);
	}
	
	static void sort(int[] a, int lo, int hi) {
		if (hi <= lo) return;
		int k = particionar(a, lo, hi);
		sort(a, lo, k-1);
		sort(a, k+1, hi);
	}
	
	
	//a)
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
	
	// b)
	
	// c)
	
	public static void main(String[] args) {
		final int[] a = {2, 5, 3, 1, 8, 9, 4, 7, 6};
		quickSort(a);
		System.out.println(Arrays.toString(a));
		
		/*
		//Para c))
		final int[] b = {2, 1, 3, 2, 3, 2, 3, 1, 1};
		quickSort(b);
		System.out.println(Arrays.toString(b));
		*/
		
	}
	
	
	

}

