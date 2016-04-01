import java.util.Arrays;

public class StoogeSort {

    static double[] P = {-0.3, 2, 3.12, 10, 4, -3, 0, -1.2, 0.5, 7.8, -13, -1.56, 0.2, 3};

    public static void main(String[] args) {
        stoogeSort(P,0,P.length-1);
        System.out.println(Arrays.toString(P));
    }

    public static void stoogeSort(double[] A, int ini, int fin){
        if(A[ini]>A[fin]){
            double t = A[ini];
            A[ini] = A[fin];
            A[fin] = t;
        }
        int dif = fin-ini;
        if(dif>2){
            stoogeSort(A,ini,fin-dif/3);
            stoogeSort(A,ini+dif/3,fin);
            stoogeSort(A,ini,fin-dif/3);
        }
    }

    /**
     * Analisis del algoritmo:
     * Ecuacion de recurrencia: T(n) = 3T(2n/3) + 1, T(1) = 1
     * Desenrrollando:  T(n) = 3*3T(4n/9) +2
     *                  T(n) = 3^k T((2/3)^k n) + k
     * Si k = log_(3/2) n:
     *                  T(n) = 3^(log_(3/2) n)*T(1) + log_(3/2) n
     *                  T(n) = 3^(log_(3/2) n) + log_(3/2) n
     * Dado que: 3^(log_(3/2) n) = n^(log_(3/2) 3)
     * Se llega a:      T(n) = n^(log_(3/2) 3) + log_(3/2) n
     *                  T(n) = O(n^2.709...)
     * Luego es peor que BubbleSort y QuickSort
     */

}
