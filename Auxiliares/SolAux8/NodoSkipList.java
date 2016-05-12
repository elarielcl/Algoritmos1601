public class NodoSkipList {
	double info;
	NodoSkipList[] sigs;
	int n;
	
	static public boolean buscar(double x, NodoSkipList l) {
		for (int i = l.n; i>=0; --i) {
			if (l.sigs[i].info == x) return true;
			else if (l.sigs[i].info < x) { //Si este nodo es menor que lo que busco, sigo buscando después de el
				l = l.sigs[i];
				i = l.n + 1; //Pues el for disminuye el contador para la siguiente iteración
			}
		}
		return l.info == x;
	}
}

