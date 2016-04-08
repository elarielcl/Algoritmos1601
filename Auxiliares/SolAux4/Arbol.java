
public class Arbol {
	public Arbol izq;
	public Arbol der;
	public int valor;
	
	public Arbol(){
		izq=null;
		der=null;
	}
	
	public Arbol(Arbol izq, Arbol der, int valor){
		this.izq = izq;
		this.der = der;
		this.valor = valor;
	}
	
	static public boolean inordenEquivalente(Arbol A, Arbol B){
		Nodo x = inorden(A);
		Nodo y = inorden(B);
		return equivalentes(x,y);
	}

	private static boolean equivalentes(Nodo x, Nodo y) {
		Nodo actualx = x;
		Nodo actualy = y;
		while(actualx!=null && actualy!=null){
			if(actualx.val!=actualy.val)
				return false;
			actualx = actualx.sig;
			actualy = actualy.sig;
		}
		if(actualx!=null || actualy!=null)
			return false;
		return true;
	}

	private static Nodo inorden(Arbol a) {
		Nodo n = null;
		return inorden_rec(a, n);
	}

	private static Nodo inorden_rec(Arbol a, Nodo n) {
		if(a==null) return n;
		Nodo auxder = inorden_rec(a.der, n);
		auxder = new Nodo(a.valor, auxder);
		return inorden_rec(a.izq, auxder);
	}
	
	static public void main(String[] args){
		Arbol A = new Arbol(new Arbol(null, null, 1), 
				new Arbol(null, null, 3), 2);
		Arbol B = new Arbol(new Arbol(new Arbol(null,null,1), null, 2), null, 3);
		Arbol C = new Arbol(new Arbol(null, null, 1), 
				new Arbol(null, null, 2), 3);
		boolean x = inordenEquivalente(A, A);
		boolean y = inordenEquivalente(A, B);
		boolean z = inordenEquivalente(A, C);
		boolean w = inordenEquivalente(B, C);
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(w);
	}
}
