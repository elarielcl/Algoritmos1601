
public class Peliculas {

	public static void main(String[] args) {
		
		int [][] P = {{4,6}, {1,3}, {0,2}, {3,5}, {2,4}};
		System.out.println(maximoPeliculas(P));
		System.out.println(maximoPeliculasAvaro(P));
	}
	
	
	public static int maximoPeliculas(int [][] P) {
		boolean [] indicatriz = new boolean[P.length]; //indicatriz[i] indica si la pelicula i está en el subconjunto
		
		//Esto dice que que el óptimo es el máximo entre los subconjuntos
		//de películas que tienen al primer elemento y las que no lo tienen
		return Math.max(maximoPeliculasRec(P,  indicatriz, true, 0),
				maximoPeliculasRec(P,  indicatriz, false, 0));
		
	}
	
	
	//La idea general el armar "recursivamente" todos los subconjuntos de P(a través de indicatriz)
	//y cuando se tiene un subconjunto armado(caso base) revisar si en el hay películas que se superponen
	//en caso que esto suceda retornar 0 y si no el tamaño del subconjunto
	private static int maximoPeliculasRec(int[][] P, boolean[] indicatriz, boolean b, int i) {
		indicatriz[i] = b;
		if (i == indicatriz.length-1) {
			
			//Revisar factibilidad de solución
			int n = 0;
			for (int j = 0;  j < indicatriz.length; j++) {
				if (indicatriz[j]) {//Si el subconjunto tiene el elemento j
					for (int k = j+1; k < indicatriz.length; k++) {
						if (indicatriz[k] && Math.max(P[j][0],P[k][0]) < Math.min(P[j][1],P[k][1]))//Y se intersecta con el elemento k
							return 0;
					}
					++n;
				}
				//Esto retorna 0 si el subconjunto no es factible y el número de elementos si es que lo es
			}
			return n;
		}
		
		return Math.max(maximoPeliculasRec(P,  indicatriz, true, i+1),
				maximoPeliculasRec(P,  indicatriz, false, i+1));
	}

	
	
	public static int maximoPeliculasAvaro(int [][] P) {
		sortBy(P, 1); //Ordenar películas por hora de fin
		
		//Elegir las películas según orden creciente de hora de
		//fin y a medida que estas no se superpongan
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

	//InsertionSort por la coordenada idx
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
