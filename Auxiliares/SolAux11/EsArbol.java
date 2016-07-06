
public class EsArbol {
	static int[][] grafo1 = {{1,2},{0,3},{0,3},{2,1},{5},{4}};//No conexo, con ciclo
	static int[][] grafo2 = {{1,2},{0,3},{0,3},{2,1,4},{3,5},{4}};//Conexo con ciclo
	static int[][] grafo3 = {{1,2},{0,3},{0},{1},{5},{4}};//No conexo sin ciclo
	static int[][] grafo4 = {{1,2},{0,3},{0},{1,4},{3,5},{4}};//No conexo sin ciclo

    static boolean tieneCiclo; 
    
    
    static public boolean esArbol(int [][] grafo) {
    	boolean[] visitado = new boolean[grafo.length];
    	
    	tieneCiclo = false;
    	tieneCiclo(grafo, visitado, 0, 0);
    	if (tieneCiclo) return false;
    	
    	
    	for (boolean v : visitado)
			if (!v) return false;
		
    	return true;
    }
    
    private static void tieneCiclo(int[][] grafo, boolean[] visitado,
			int desde, int v) {
		visitado[v] = true;
		for (int w : grafo[v]) {
			if (!visitado[w]) tieneCiclo(grafo, visitado, v, w);
			else if (w != desde) {
				tieneCiclo = true;
			}
		}
	}

	static public void main (String[] args) {
		System.out.println(esArbol(grafo1));
		System.out.println(esArbol(grafo2));
		System.out.println(esArbol(grafo3));
		System.out.println(esArbol(grafo4));
    }
}
