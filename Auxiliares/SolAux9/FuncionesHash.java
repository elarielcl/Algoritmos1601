
public class FuncionesHash {
	
	static final int M = 37;
	static final int P = 31;
	static int [] integerHashTable = new int[M];
	static String [] stringHashTable = new String[M];
	
	static public int hash(int n) {
		return (n & 0x7fffffff) % M;
	}
	
	static public int hash(String s) {
		int hash = 0;
		for (int i = 0; i < s.length(); i++)
		    hash = (P * hash + s.charAt(i)) % M;
		return hash;
	}
	
	public static void main(String[] args) {
		System.out.println(hash(-4234));
		System.out.println(hash("Sebastian"));
		System.out.println(hash("Ariel"));
		System.out.println(hash("Sergio"));//Colision con Ariel :O
	}

}

