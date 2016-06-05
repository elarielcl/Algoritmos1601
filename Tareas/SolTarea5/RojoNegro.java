public class RojoNegro implements ArbolBinario{

    private static final boolean RED   = true;
    private static final boolean BLACK = false;
    
    class Nodo {
        int v;
        Nodo izq;
        Nodo der;
        private boolean color;
        
        public Nodo(int v, Nodo izq, Nodo der) {
            this.v = v;
            this.izq = izq;
            this.der = der;
            this.color = true;
        }
    }
    Nodo raiz;
    
    public void insertar(int x) {
        raiz = insertar(raiz, x);
        raiz.color = BLACK; 
    }

    private Nodo insertar(Nodo n, int x) { 
        if (n == null) return new Nodo(x, null, null);

        if      (x < n.v) n.izq  = insertar(n.izq,  x); 
        else if (x > n.v) n.der = insertar(n.der, x); 
        else              n.v   = x;

        if (esRojo(n.der) && !esRojo(n.izq))      n = rotarIzquierda(n);
        if (esRojo(n.izq)  &&  esRojo(n.izq.izq)) n = rotarDerecha(n);
        if (esRojo(n.izq)  &&  esRojo(n.der))     invertirColores(n);
        
        return n;
    }

    private Nodo rotarDerecha(Nodo n) {
        Nodo x = n.izq;
        n.izq = x.der;
        x.der = n;
        x.color = x.der.color;
        x.der.color = RED;
        return x;
    }

    private Nodo rotarIzquierda(Nodo n) {
        Nodo x = n.der;
        n.der = x.izq;
        x.izq = n;
        x.color = x.izq.color;
        x.izq.color = RED;
        return x;
    }

    private void invertirColores(Nodo n) {
        n.color = !n.color;
        n.izq.color = !n.izq.color;
        n.der.color = !n.der.color;
    }
    
    private boolean esRojo(Nodo x) {
        if (x == null) return false;
        return x.color == RED;
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
			RojoNegro a = new RojoNegro();
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
			RojoNegro a = new RojoNegro();
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