public class PrefijoMasLargo {

	public static int prefijoMasLargo(char[] texto, char[] patron) {
		int l = 0;
		
		

        // Construccion del automata
		int R = 256;
        int m = patron.length;
        int n = texto.length;
        int[][] automata = new int[R][m]; 
        automata[patron[0]][0] = 1; 
        for (int x = 0, j = 1; j < m; j++) {
            for (int c = 0; c < R; c++) 
                automata[c][j] = automata[c][x]; 
            automata[patron[j]][j] = j+1; 
            x = automata[patron[j]][x]; 
        } 
        
        
        // Busqueda en el texto
        int i, j;
        for (i = 0, j = 0; i < n && j < m; i++) {
            j = automata[texto[i]][j];
            l = Math.max(j, l);
        }
        
        return l;
	}
	
	
	public static void main(String[] args) {
		System.out.println(prefijoMasLargo("anitalavalatina".toCharArray(), "ana".toCharArray()));
		System.out.println(prefijoMasLargo("anitalavalatina".toCharArray(), "ani".toCharArray()));
		System.out.println(prefijoMasLargo("anitalavalatina".toCharArray(), "ar".toCharArray()));
	}

}
