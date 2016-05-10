public class Avl{
	public static Nodo insertar(Nodo a, int x){
		if( a == null)
			return new Nodo(null, x, null);
		Nodo b = a;
		if(x < b.info){
			b.izq = insertar(b.izq,x);
			if( b.izq.altura() - b.der.altura()==2 ){
				if( x < b.izq.info )
					b = rotateToLeft( b ); /* Caso 1 */
				else
					b = doubleToLeft( b ); /** Caso 2 */
			}
		}
		else if(x > b.info){
			b.der = insertar(b.der, x);
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
		b.der = rotateToLeft(b.der);
		return rotateToRight(b);
	}

	private static Nodo rotateToRight(Nodo padre) {
		Nodo hijo = padre.der;
		padre.der = hijo.izq;
		hijo.izq = padre;
		return hijo;
	}

	private static Nodo doubleToLeft(Nodo b){
		b.izq = rotateToRight(b.izq);
		return rotateToLeft(b);
	}

	private static Nodo rotateToLeft(Nodo padre) {		
		Nodo hijo = padre.izq;
		padre.izq = hijo.der;
		hijo.der = padre;
		return hijo;
	}
}
