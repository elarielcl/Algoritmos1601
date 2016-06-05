public class AVL implements ArbolBinario{
	class Nodo {
		int v;
		int h;
		Nodo izq;
		Nodo der;
		public Nodo(int v, Nodo izq, Nodo der) {
			this.v = v;
			this.izq = izq;
			this.der = der;
			this.h= 1;
		}
	}
	Nodo raiz;
	public void insertar(int x) {
		raiz = insertar(raiz, x);
	}
	
	public Nodo insertar(Nodo a, int x){
		if( a == null)
			return new Nodo(x, null, null);
		Nodo b = a;
		if(x < b.v){
			b.izq = insertar(b.izq,x);

			actualizarAltura(b);
			
			if(b.der == null && b.izq.h == 2 || (b.der!=null && b.izq.h - b.der.h==2)){
				if( x < b.izq.v )
					b = rotateToLeft( b ); /* Caso 1 */
				else
					b = doubleToLeft( b ); /** Caso 2 */
			}
		}
		else if(x > b.v){
			b.der = insertar(b.der, x);
			
			actualizarAltura(b);
			
			if(b.izq == null && b.der.h == 2 || (b.izq != null && b.der.h - b.izq.h == 2)){
				if(x > b.der.v)
					b = rotateToRight( b ); /* Caso 4 */
				else
					b = doubleToRight( b ); /** Caso 3 */
			}
		}
		return b;
	}

	private Nodo doubleToRight(Nodo b) {
		b.der = rotateToLeft(b.der);
		return rotateToRight(b);
	}

	private Nodo rotateToRight(Nodo padre) {
		Nodo hijo = padre.der;
		padre.der = hijo.izq;
		hijo.izq = padre;
		actualizarAltura(padre);
		actualizarAltura(hijo);
		return hijo;
	}

	private Nodo doubleToLeft(Nodo b){
		b.izq = rotateToRight(b.izq);
		return rotateToLeft(b);
	}

	private Nodo rotateToLeft(Nodo padre) {		
		Nodo hijo = padre.izq;
		padre.izq = hijo.der;
		hijo.der = padre;
		actualizarAltura(padre);
		actualizarAltura(hijo);
		return hijo;
	}

	private void actualizarAltura(Nodo n) {
		n.h = 1+Math.max(n.izq == null ? 0 : n.izq.h, n.der == null ? 0 : n.der.h);
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
			AVL a = new AVL();
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
		
		//Ascendente
		System.out.println("Ascendente");
		for (int n = 100; n <= 1000000; n*=10) {
			int[] p = Tools.ascendente(n);
			AVL a = new AVL();
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
