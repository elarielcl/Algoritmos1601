
public class ABB implements ArbolBinario{
	class Nodo {
		int v;
		Nodo izq;
		Nodo der;
		public Nodo(int v, Nodo izq, Nodo der) {
			this.v = v;
			this.izq = izq;
			this.der = der;
		}
	}
	Nodo raiz;
	public void insertar(int x) {
		raiz = insertar(raiz, x);
	}
	
	private Nodo insertar(Nodo n, int x) {
		if (n == null) return new Nodo(x, null, null);
		if (x < n.v) n.izq = insertar(n.izq, x);
		else if (x > n.v) n.der = insertar(n.der, x);
		return n;
	}
	
	public boolean buscar(int x) {
		return buscar(raiz, x);
	}

	
	private boolean buscar(Nodo n, int x) {
		if (n == null) return false;
		if (x < n.v) return buscar(n.izq, x);
		return buscar(n.der, x);
	}
	
	public int altura() {
		return altura(raiz);
	}

	private int altura(Nodo n) {
		if (n == null) return 0;
		return 1 + Math.max(altura(n.izq), altura(n.der));
	}

	public static void main(String[] args) {
		//Azar
		System.out.println("Azar");
		for (int n = 100; n <= 1000000; n*=10) {
			int[] p = Tools.permutacion(n);
			ABB a = new ABB();
			double inicio = System.currentTimeMillis();
			for (int i = 0; i < n; ++i)
				a.insertar(p[i]);
			System.out.println("n="+n+" ,insercion="+(System.currentTimeMillis()-inicio)/n);
			inicio = System.currentTimeMillis();
			for (int i = 0; i < n; ++i)
				a.buscar(p[i]);
			System.out.println("n="+n+" ,busqueda="+(System.currentTimeMillis()-inicio)/n);
			System.out.println("n="+n+" ,altura="+a.altura());
		}
		
		//Ascendente , lineal en n
		System.out.println("Ascendente");
		for (int n = 100; n <= 10000; n*=10) {
			int[] p = Tools.ascendente(n);
			ABB a = new ABB();
			double inicio = System.currentTimeMillis();
			for (int i = 0; i < n; ++i)
				a.insertar(p[i]);
			System.out.println("n="+n+" ,insercion="+(System.currentTimeMillis()-inicio)/n);
			inicio = System.currentTimeMillis();
			for (int i = 0; i < n; ++i)
				a.buscar(p[i]);
			System.out.println("n="+n+" ,busqueda="+(System.currentTimeMillis()-inicio)/n);
			System.out.println("n="+n+" ,altura="+a.altura());
		}

	}
	
	

	

}
