public class Aux2P3 {

    static int C = 3;
    static int[] P = {60,56,55,57,61,64,70,74,72,68,73,65,63,69,70};

    public static void main(String[] args) {
        int ganado = ganancias(P,0,false);
        System.out.println("Ganancia máxima: "+ganado);
    }

    // Estrategia: separar los casos de si tiene accion o no, definir desde el dia que se está evaluando.
    public static int ganancias(int[] P, int desde, boolean tieneAccion){
        int n = P.length;
        //Caso base (ultimo día) si tiene accion la vende, si no pasa.
        if(desde == n-1){
            if(tieneAccion)
                return P[n-1];
            else
                return 0;
        }
        else{
            if(tieneAccion){ //Si tiene accion se evaluan los casos pasar y vender
                int casoPasar = ganancias(P,desde+1,true);
                int casoVender = P[desde] + ganancias(P,desde+1,false);
                return max(casoPasar,casoVender);
            }
            else{ //Si no tiene accion se evaluan los casos pasar y comprar recursivamente
                int casoPasar = ganancias(P,desde+1,false);
                int casoComprar = -P[desde] - C + ganancias(P,desde+1,true);
                return max(casoPasar,casoComprar);
            }
        }
    }

    private static int max(int a, int b) {
        return (a>b)?a:b;
    }

}
