import java.util.Arrays;

public class StoogeSort {

    static double[] P = {-0.3, 2, 3.12, 10, 4, -3, 0, -1.2, 0.5, 7.8, -13, -1.56, 0.2, 3};

    public static void main(String[] args) {
        stoogeSort(P,0,P.length-1);
        System.out.println(Arrays.toString(P));
    }

    public static void stoogeSort(double[] A, int ini, int fin){
    	//Si primer y último elemento están desordenados se intercambian
        if(A[ini]>A[fin]){
            double t = A[ini];
            A[ini] = A[fin];
            A[fin] = t;
        }
        int dif = fin-ini;
        if(dif>2){ // Caso base |A| <= 2
            stoogeSort(A,ini,fin-dif/3);//Ordeno dos primeros tercios
            stoogeSort(A,ini+dif/3,fin);//Ordeno dos últimos tercios
            stoogeSort(A,ini,fin-dif/3);//Vuelvo a ordenar dos primeros tercios
        }
    }
}
