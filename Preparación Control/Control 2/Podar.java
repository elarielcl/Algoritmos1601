


public class Podar {
	static Arbol ejemplo = new Arbol(10, new Arbol(5, new Arbol(1, null, null), new Arbol(7, null, null)), new Arbol(15, new Arbol(12, null, null), new Arbol(20, null, null)));
	
	
	static Arbol podarMayores(Arbol r, int valor) {
		if (r != null)
		{
			if (r.val <= valor) r.der = podarMayores(r.der, valor);
			else return podarMayores(r.izq, valor);
		}
		return r;
	}
	
	public static void main(String[] args) {
		
		System.out.println(ejemplo);
		System.out.println(podarMayores(ejemplo, 14));
		System.out.println(podarMayores(ejemplo, 5));
	}

}

class Arbol {
	int val;
	Arbol izq;
	Arbol der;
	
	public Arbol(int val, Arbol izq, Arbol der) {
		this.val = val;
		this.izq = izq;
		this.der = der;
	}
	
	public String toString() {
		String s = "("+val+" ";
		s += this.izq == null ? "()" : this.izq.toString();
		s += " ";
		s += this.der == null ? "()" : this.der.toString();
		s+=")";
		return s;
	}
}
