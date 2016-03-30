public class Aux2P1 {

    static int[] A = {5,9,23,-5,7,2,0,-8,31,-14,3,1,-7,10,-2,4,-11};

    // Estrategia: La distancia máxima es la diferencia del máximo con el mínimo.
    // Invariante: Desde 0 hasta i, se conoce el minimo y el máximo y por lo tanto la distancia máxima
    // Caso Inicial: i=0 (min=max, dist=0). Caso Final: i=n (dist=max-min).
    public static void main(String[] args) {

        int min = A[0];
        int max = A[0];

        for(int i = 0; i < A.length; i++) {
            if(A[i]<min)
                min = A[i];
            else if(A[i]>max)
                max = A[i];
        }

        System.out.println("Distancia máxima:"+(max-min)+" - desde "+min+" hasta "+max);

    }

}
