
public class Calentamiento {

	static public int contarRec(Nodo n, int x){
		if(n==null)
			return 0;
		if(n.val == x)
			return 1 + contarRec(n.sig, x);
		return contarRec(n.sig, x);
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
	
	static public Nodo eliminar(Nodo n, int x){
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
	
	static public void eliminarDuplicados(Nodo n){
		Nodo vistos = null;
		Nodo actual = n;
		while(actual!=null){
			//if(contiene(vistos, actual.val)){
				
			//}
		}
	}
	
	static public Nodo invertir(Nodo n){
		if(n==null) return n;
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
	
	static public void main(String[] args){
		Nodo x = new Nodo(1, new Nodo(1, new Nodo(2, null)));
		Nodo y = new Nodo(1, new Nodo(1, new Nodo(2, null)));
		int ci = contarIter(x, 1);
		int cr = contarRec(x, 1);
		x = invertir(x);
		y = eliminar(x, 1);
		System.out.println(ci);
		System.out.println(cr);
	}
}
