import java.util.Arrays;
public class TuercasYTornillos
{
    public static void main(String[] args)
    {
        int tornillos[] = {5, 1, 2, 3, 6, 4};
        int tuercas[] = {2, 3, 4, 6, 5, 1};
 
        ordenarCruzado(tornillos, tuercas, 0, 5);
 
        System.out.println("Los pares de tornillos y tuercas son : ");
        System.out.println(Arrays.toString(tornillos));
        System.out.println(Arrays.toString(tuercas));
    }
 
    private static void ordenarCruzado(int[] tornillos, int[] tuercas, int lo, int hi)
    {
        if (lo < hi)
        {
            int p = particionar(tornillos, lo, hi, tuercas[hi]);
            particionar(tuercas, lo, hi, tornillos[p]);
            ordenarCruzado(tornillos, tuercas, lo, p-1);
            ordenarCruzado(tornillos, tuercas, p+1, hi);
        }
    }
 
    static int particionar(int[] a, int lo, int hi, int p) {
    	int i = lo;
        int j = hi;

        while (true) {
            // Avanzar i
        	while (a[i] < p)
            {
            	++i;
            	if (i == hi) break;
            }
            
        	// Avanzar j
            while (p < a[j])
            {
            	--j;
            	if (j == lo) break;
            }

            if (i >= j) break;

            swap(a,i,j);
        }
        return j;
    }
    
    static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


}