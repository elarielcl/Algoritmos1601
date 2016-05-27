
public class TablaHashEncadenamiento {
	
	class ListaEnlazada {
		class Nodo {
			String valor;
			Nodo sig;
			public boolean contiene(String k) {
				if (valor.equals(k)) return true;
				if (sig == null) return false;
				return sig.contiene(k);
			}
			
			public String toString() {
				if (sig == null) return valor;
				return valor + "," + sig.toString();
			}
		}
		Nodo raiz;
		public void insertar(String k) {
			Nodo c = new Nodo();
			c.valor = k;
			c.sig = raiz;
			raiz = c;
		}
		public boolean contiene(String k) {
			if (raiz == null) return false;
			return raiz.contiene(k);
		}
		
		public String toString() {
			if (raiz == null) return "{}";
			return "{" + raiz.toString() + "}";
		}
	}
	
	ListaEnlazada [] tabla;
	private int M;
	private final int P = 31;
	public TablaHashEncadenamiento(int M) {
		this.M = M;
		tabla = new ListaEnlazada[M];
		for (int i = 0; i < tabla.length; i++) {
			tabla[i] = new ListaEnlazada();
		} 
	}	
	
	public boolean contiene(String k) {
		return tabla[hash(k)].contiene(k);
	}
	
	public void insertar(String k) {
		tabla[hash(k)].insertar(k);
	}
	
	private int hash(String s) {
		int hash = 0;
		for (int i = 0; i < s.length(); i++)
		    hash = (P * hash + s.charAt(i)) % M;
		return hash;
	}
	
	public String toString() {
		String s = "Tabla";
		for (int i = 0; i < tabla.length; i++) {
			s += "\n" + tabla[i].toString();
		}
		return s;
	}
	
	public static void main(String[] args) {
		TablaHashEncadenamiento t = new TablaHashEncadenamiento(7);
		t.insertar("Hola");
		t.insertar("Adios");
		System.out.println(t.contiene("Hola"));
		System.out.println(t.contiene("Chao"));
		
		System.out.println();
		System.out.println(t);
		
		t.insertar("Chao");
		System.out.println();
		System.out.println(t);
		
		t.insertar("Gracias");
		System.out.println();
		System.out.println(t);
		
		t.insertar("Perdon");
		System.out.println();
		System.out.println(t);
		
	}

}

