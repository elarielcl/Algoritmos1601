import java.io.*;
public class Diff {

	public static void main(String[] args) throws IOException {
		levDistance(toStringArray(args[0]), toStringArray(args[1]));
	}
	
	private static String[] toStringArray(String file) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader(file));
		int ls = 0;
		while (r.readLine() != null) ls++;
		r.close();
		
		String[] a = new String[ls];
		r = new BufferedReader(new FileReader(file));
		for (int i = 0; i<ls; ++i)
			a[i] = r.readLine();
		r.close();
		return a;
	}
	
	private static void levDistance(String[] a, String[] b) {
		if (a == null || b == null) return;
		int [][] lev = new int[a.length+1][b.length+1];
		
		//Casos base
		for (int i = 0; i <= a.length; i++)
			lev[i][0] = i;
		for (int j = 0; j<=b.length; ++j)
			lev[0][j] = j;
		
		//Ecuacion de recurrencia
		for (int i = 1; i<=a.length; ++i)
			for (int j = 1; j<=b.length; ++j) {
				lev[i][j] = Math.min(Math.min(lev[i-1][j], lev[i][j-1]) + 1,
						lev[i-1][j-1] + (a[i-1].equals(b[j-1])? 0:1));
			}
			
		//Impresion de ediciones
		int i = a.length;
		int j = b.length;
		while (lev[i][j] != 0) {
			if (i == 0) {
				System.out.println((i+1)+".   -> "+ b[j-1]);
				j--;
			}
			else if(j == 0) {
				System.out.println(i+". "+a[i-1]+ " ->");
				i--;
			}
			else {
				int min = Math.min(Math.min(lev[i-1][j], lev[i][j-1]) + 1,
						lev[i-1][j-1] + (a[i-1].equals(b[j-1])? 0:1));
				if (min == lev[i-1][j] + 1) {
					System.out.println(i+". "+a[i-1]+ " ->");
					i--;
				} else if (min == lev[i][j-1] + 1) {
					System.out.println((i+1)+".   -> "+ b[j-1]);
					j--;
				} else {
					if(!a[i-1].equals(b[j-1]))
						System.out.println(i+". " +a[i-1]+ " -> "+ b[j-1]);
					i--;
					j--;
				}
			}
		}
		System.out.println("Distance =  "+lev[a.length][b.length]);
	}
}
