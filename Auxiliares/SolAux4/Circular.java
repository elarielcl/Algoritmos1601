
public class Circular {

	public static void main(String[] args) {
		Nodo n1 = new Nodo(1,new Nodo(2, new Nodo(3,null)));
		Nodo n2 = new Nodo(2,new Nodo(5,new Nodo(8,null)));
		n2.sig.sig.sig = n2.sig;
		System.out.println(esCircular(n1));
		System.out.println(esCircular(n2));
	}

	public static boolean esCircular(Nodo first){
		/* Estrategia guardar la referencia de 2 elementos, recorrer la lista a velocidades
		 * distintas, las referencias se encontraran si hay un ciclo.
		 */
		Nodo ref1 = first;
		Nodo ref2 = first;
		if(ref1==null) return false; //Caso de lista vacia
		
		while(ref1!=null && ref2 != null && ref2.sig!=null){
			ref1 = ref1.sig;
			ref2 = ref2.sig.sig; //ref2 avanza al doble de rapido que ref1
			if(ref1==ref2)
				return true;
		}
		return false;
	}
	
}

