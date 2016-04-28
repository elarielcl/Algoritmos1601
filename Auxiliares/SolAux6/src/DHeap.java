public class DHeap {
	private int[] heap;
	private int largo;
	private int d;
	
	private final static int factor = 2;
	private final static int largo_inicial = 10;
	private final static int default_d = 2;
	
	public DHeap() {
		this(default_d);
	}
	
	public DHeap(int arity) {
		this.d = arity;
		this.heap = new int[largo_inicial];
		this.largo = 0;
		
	}
	
	public boolean estaVacio() {
		return largo == 0;
	}

	public int minimo() {
		if (largo == 0) { throw new java.lang.IllegalStateException("Empty Heap"); }
		
		return heap[0];
	}
	
	public void insertar(int x) {
		//caso arreglo vacio
		if (largo==0) {
			heap[0] = x;
			largo++;
			return;
		}
		//caso arreglo lleno
		if (largo == heap.length) {
			int[] newArray = new int[largo*factor];
			for(int i=0; i<largo; i++) {
				newArray[i] = heap[i];
			}
			heap = newArray;
		}
		int i = largo; //lo definimos afuera para usarlo despues
		//partir desde abajo e ir intercambiando con el padre	
		for(; heap[(i-1)/d] > x; i=(i-1)/d) {
			//si llegamos a la raiz, se acaba
			if (i==0) break;
			//si no, lo intercambio con el padre
			heap[i] = heap[(i-1)/d];
		}
		//agregamos x en la posición correspondiente
		heap[i] = x;
		largo++;
	}
	
	public int extraerMin() {
		if (largo == 0) { throw new java.lang.IllegalStateException("Empty Heap"); }
		
		int result = heap[0];
		int ultimo = heap[largo-1];
		int hijo;
		int i=0;
		
		//tomamos el ultimo elem y lo ponemos en la raiz
		//luego, vamos subiendo por el heap, para reparar la condicion
		for(; (i*d)+1 < largo; i=hijo) {
			hijo = (i*d)+1; //el primer hijo
			
			//si el nodo no tiene hijos
			if (hijo > largo) { break; }
			
			//encontrar el hijo mas pequeño
			int j=1, hijoMin = hijo;
			for(; j<d; j++) {
				if (hijo+j == largo) break;
				if(heap[hijoMin] > heap[hijo+j])
					hijoMin = hijo+j;
			}
			
			hijo = hijoMin;
			if (ultimo > heap[hijo]) {
				heap[i] = heap[hijo];
			}else{
				break;
			}
		}
		
		heap[i] = ultimo;
		largo--;
		return result;
	}
}