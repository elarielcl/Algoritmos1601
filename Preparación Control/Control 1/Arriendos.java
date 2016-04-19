
public class Arriendos {

	public static void main(String[] args) {
		int[][] a = {{0,1,2,3},{1,0,2,3},{1,2,0,3},{1,2,3,0}};
		System.out.println(minimoCosto(a));

	}

	private static int minimoCosto(int[][] a) {
		int n = a.length;
		int[][] C = new int[n][n];
		for (int l = n-1; l>0; --l) {
			for (int i = 0; i<l; ++i) {
				int j = i + n-l;
				C[i][j] = a[i][j];
				for (int k = i+1; k<j; ++k) 
					if (C[i][k] + C[k][j] < C[i][j]) C[i][j] = C[i][k] + C[k][j]; 
			}
		}
		return C[0][n-1];
	}

}
