
public class Calentamiento {

	static public void imprimirListaIter(Nodo n){
		Nodo actual = n;
		if (actual != null){
			System.out.print(actual.val);
			actual = actual.sig;
		}
		while (actual != null) {
			System.out.print(","+actual.val);
			actual = actual.sig;
		}
		System.out.println();
	}
	
	static public void imprimirListaRec(Nodo n){
		if (n == null) return;
		if (n.sig == null)
			System.out.println(n.val);
		else {
			System.out.print(n.val + ",");
			imprimirListaRec(n.sig);
		}
			
	}
	
	static public int contarIter(Nodo n, int x){
		int count = 0;
		Nodo actual = n;
		while(actual!= null){
			if(actual.val == x)
				count++;
			actual = actual.sig;
		}
		return count;
	}
	
	static public int contarRec(Nodo n, int x){
		if(n==null)
			return 0;
		if(n.val == x)
			return 1 + contarRec(n.sig, x);
		return contarRec(n.sig, x);
	}
	
	static public Nodo eliminarIter(Nodo n, int x){
		if (n == null) return null;
		while(n.val==x){
			n = n.sig;
			if (n == null) return null;
		}
		
		Nodo prev = n;
		Nodo actual = n.sig;
		while(actual!=null){
			if(actual.val == x){
				prev.sig = actual.sig;
			}
			prev = actual;
			actual = actual.sig;
		}
		return n;
	}
	
	static public Nodo eliminarRec(Nodo n, int x){
		if (n == null) return null;
		if (n.val == x) return eliminarRec(n.sig, x);
		n.sig = eliminarRec(n.sig, x);
		return  n;
	}
	
	static public void eliminarDuplicadosIter(Nodo n){
		Nodo actual = n;
		while(actual!=null){
			actual.sig = eliminarIter(actual.sig, actual.val);
			actual = actual.sig;
		}
	}
	
	static public void eliminarDuplicadosRec(Nodo n){
		if (n != null) {
			n.sig = eliminarRec(n.sig, n.val);
			eliminarDuplicadosRec(n.sig);
		}
	}
	
	static public Nodo invertirIter(Nodo n){
		Nodo reversedPart = null;
		Nodo current = n;
		while (current != null) {
		    Nodo next = current.sig;
		    current.sig = reversedPart;
		    reversedPart = current;
		    current = next;
		}
		return reversedPart;
	}
	
	static public Nodo invertirRec(Nodo n){
		if (n == null || n.sig == null) return n;
		Nodo sig = n.sig;
		Nodo resto = invertirRec(sig);
		sig.sig = n;
		n.sig = null;
		return resto;
	}
	
	static public void main(String[] args){
		Nodo x = new Nodo(1, new Nodo(1, new Nodo(2, new Nodo(2, null))));
		imprimirListaRec(x);
		Nodo y,z ;
		int ci = contarIter(x, 1);
		int cr = contarRec(x, 1);
		
		System.out.println(ci);
		System.out.println(cr);
		System.out.println();
		
		x = invertirIter(x);
		imprimirListaIter(x);
		x = invertirRec(x);
		imprimirListaRec(x);
		
		y = eliminarIter(x, 1);
		z = eliminarRec(x,1);
		imprimirListaIter(z);
		imprimirListaRec(y);
		eliminarDuplicadosIter(x);
		imprimirListaIter(x);
		
		
		
	}
}

