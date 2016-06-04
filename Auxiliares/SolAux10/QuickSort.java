import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    static void quickSort(int[] a) {
        sort(a, 0, a.length-1);
    }

    static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int k = particionarC(a, lo, hi);
        sort(a, lo, k-1);
        sort(a, k+1, hi);
    }
    
    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    //a)
    static int particionar(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        //Eleccion del pivote
        int ip = new Random().nextInt(hi-lo+1) + lo;
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

    // b)
    static int particionarB(int[] a, int lo, int hi){
        //Eleccion del pivote
        int ip = new Random().nextInt(hi-lo+1) + lo;
        swap(a,lo,ip);
        int p = a[lo];
        
        //En j se guardara la posicion final del pivote
        int j = lo;

        //Se recorre el arreglo de izquierda a derecha
        for (int i = lo + 1; i <= hi; i++) {
            //Si algun elemento es menor que el pivote, se pone en la posición anterior del pivote y se aumenta en 1 la posicion final del pivote
            if(a[i]<p){
                j++;
                swap(a,i,j);
            }
        }

        //Se deja el pivote en su posicion correcta
        swap(a,lo,j);

        return j;
    }

    // c)
    static  int particionarC(int[] a, int lo, int hi){
        //Eleccion del pivote
        int ip = new Random().nextInt(hi-lo+1) + lo;
        swap(a,lo,ip);
        int p = a[lo];

        // Significado de variables
        //  [ p |---- < p --- | -- = p ---| --- ??? --- | --- > p ----]
        // lo--lo+1------------i-----------k-------------j------------hi
        int i = lo + 1;
        int j = hi;
        int k = lo + 1;

        while (true){
            while (a[i] < p) {
                if (k == hi) break;
                i++;
                k++;
            }

            while(a[k] == p){ 
                if (k == hi) break;
                k++;
            }

            while (p < a[j]) { 
                if (j == lo) break;
                j--;
            }

            if (k >= j) break;

            swap(a,k,j);
            if(a[k]!=p) {
                swap(a,k,i);
                ++i;
                ++k;
            }
        }
        
        // Poner el pivote en su posicion
        swap(a,lo,i);
        
        return j;
    }
    
    //Otra implementacion de c) y considerando optimizacion
    static void sortMejorado(int[] a, int lo, int hi) {
    	if (hi <= lo) return;
    	
        //Eleccion del pivote
        int ip = new Random().nextInt(hi-lo+1) + lo;
        swap(a,lo,ip);
        int p = a[lo];

        int lt = lo, gt = hi;
        int i = lo;
        while (i <= gt) {
            if      (a[i] < p) swap(a, lt++, i++);
            else if (a[i] > p) swap(a, i, gt--);
            else              i++;
        }
 
        sortMejorado(a, lo, lt-1);
        sortMejorado(a, gt+1, hi);
    }

    public static void main(String[] args) {
        final int[] a = {2, 5, 3, 1, 8, 9, 4, 7, 6};
        quickSort(a);
        System.out.println(Arrays.toString(a));


		//Para c)) con sort optimizado para las repeticiones
		final int[] b = {3, 1, 2, 3, 3, 2, 3, 1, 1,2,3,2,3,1,1,1,2,3,2,1,2,1,1,2,2,2};
		sortMejorado(b, 0, b.length-1);
		System.out.println(Arrays.toString(b));
    }
}


