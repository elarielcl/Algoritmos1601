
public class Peliculas {

	public static void main(String[] args) {
		
		int [][] P = {{4,6}, {1,3}, {0,2}, {3,5}, {2,4}};
		System.out.println(maximoPeliculas(P));
		System.out.println(maximoPeliculasAvaro(P));
	}
	
	
	public static int maximoPeliculas(int [][] P) {
		boolean [] indicatriz = new boolean[P.length];
		return Math.max(maximoPeliculasRec(P,  indicatriz, true, 0),
				maximoPeliculasRec(P,  indicatriz, false, 0));
		
	}
	
	private static int maximoPeliculasRec(int[][] P, boolean[] indicatriz, boolean b, int i) {
		indicatriz[i] = b;
		if (i == indicatriz.length-1) {
			
			//Revisar factibilidad de solución
			int n = 0;
			for (int j = 0;  j < indicatriz.length; j++) {
				if (indicatriz[j]) {
					for (int k = j+1; k < indicatriz.length; k++) {
						if (indicatriz[k] && Math.max(P[j][0],P[k][0]) < Math.min(P[j][1],P[k][1]))
							return 0;
					}
					++n;
				}
					
			}
			return n;
		}
		
		return Math.max(maximoPeliculasRec(P,  indicatriz, true, i+1),
				maximoPeliculasRec(P,  indicatriz, false, i+1));
	}

	public static int maximoPeliculasAvaro(int [][] P) {
		sortBy(P, 1);
		int n = 1;
		int lastEnd = P[0][1];
		for (int i = 1; i < P.length; i++) {
			if (lastEnd <= P[i][0]) {
				lastEnd = P[i][1];
				++n;
			}
		}
		return n;
	}

	public static void sortBy(int [][] a, int idx) {
		int N = a.length;
		for (int i = 1; i < N ; ++i) {
			for (int j = i; j > 0 && a[j-1][idx] > a[j][idx] ; --j){
				int[] t = a[j];
				a[j] = a[j-1];
				a[j-1] = t;
			}
		}
	}
}
