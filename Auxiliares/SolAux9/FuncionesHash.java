
public class FuncionesHash {
	
	static final int M = Integer.MAX_VALUE;
	static final int P = 31; //Java usa 31 para el hashcode
	
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
		System.out.println("Sergio".hashCode());
	}

}

