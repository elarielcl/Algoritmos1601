public class Avl{
	public static Nodo insertar(Nodo a, int x){
		if( a == null)
			return new Nodo(null, x, null);
		Nodo b = a;
		if(x < b.info){
			b = new Nodo(insertar(b.izq,x),b.info,b.der);
			if( b.izq.altura() - b.der.altura()==2 ){
				if( x < b.izq.info )
					b = rotateToLeft( b ); /* Caso 1 */
				else
					b = doubleToLeft( b ); /** Caso 2 */
			}
		}
		else if(x > b.info){
			b = new Nodo(b.izq, b.info, insertar(b.der, x));
			if(b.der.altura() - b.izq.altura() == 2){
				if(x > b.der.info)
					b = rotateToRight( b ); /* Caso 4 */
				else
					b = doubleToRight( b ); /** Caso 3 */
			}
		}
		return b;
	}

	private static Nodo doubleToRight(Nodo b) {
		Nodo n = rotateToLeft(b.der);
		b.der = new Nodo(n.izq, n.info, n.der);
		n = rotateToRight(b);
		b = new Nodo(n.izq, n.info, n.der);
		return b;
	}

	private static Nodo rotateToRight(Nodo b) {
		Nodo n = b.der;
		if(n.izq == null){
			Nodo ni = n.izq;
			b.der = new Nodo(ni.izq, ni.info, ni.der);
		}
		else
			b.der = null;
        n.izq = new Nodo(b.izq, b.info, b.der);
        b = new Nodo(n.izq, n.info, n.der);
		return b;
	}

	private static Nodo doubleToLeft(Nodo b){
		Nodo n = rotateToRight(b.izq);
		b.izq = new Nodo(n.izq, n.info, n.der);
		n = rotateToLeft(b);
		b = new Nodo(n.izq, n.info, n.der);
        return b;
	}

	private static Nodo rotateToLeft(Nodo b) {		
		Nodo n = b.izq;
		if(n.der == null){
			Nodo nd = n.der;
			b.izq = new Nodo(nd.izq, nd.info, nd.der);
		}
		else
			b.izq = null;
		n.der = new Nodo(b.izq, b.info, b.der);
		b = new Nodo(n.izq, n.info, n.der);
		return b;
	}
}
