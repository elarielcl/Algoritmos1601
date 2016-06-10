import java.util.Stack;

public class Ciudades {

    static int caminosMinimo(int[][] grafo){
        int c = 0;
        int n = grafo.length;
        boolean[] visitados = new boolean[n];
        for (int i = 0; i < n; i++) {
            visitados[i] = false;
        }
        for (int i = 0; i < n; i++){
            if(visitados[i]) continue;
            visitar(i, grafo, visitados);
            c++;
        }
        return c - 1;
    }

    private static void visitar(int k, int[][] grafo, boolean[] visitados) {
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        while(!stack.isEmpty()) {
            int i = stack.pop();
            if (visitados[i]) continue;
            visitados[i] = true;
            for (int j = 0; j < grafo[i].length; j++)
                stack.push(grafo[i][j]);
        }
    }

    public static void main(String[] args) {

        // Grafo:   1--0--2--3   4--5    6
        //          |________|

        int[][] pais = {{1,2},{0,3},{0,3},{2,1},{5},{4},{}};
        System.out.println(caminosMinimo(pais));
    }

}
