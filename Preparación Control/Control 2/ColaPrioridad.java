import java.util.Arrays;

public class ColaPrioridad {
	static int[] heap = {0, 9, 5, 7, 1, 3, 2};//Max
	static int n = 6;
	
	public static void eliminar (int i) {
		if (i<1 || i>n) return;
		
		//Sumergir infinito
		for (; i!=1; i/=2) heap[i] = heap[i/2];
		
		//Poner último elemento en el tope y hundirlo
		heap[i] = heap[n--];
		while (2*i <= n) {
			int j = 2*i;
			if (j<n && heap[j]<heap[j+1]) j++;
			if (heap[i] > heap[j]) break;
			int t = heap[i];
			heap[i] = heap[j];
			heap[j] = t;
			
			i=j;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(heap));
		eliminar(3);
		System.out.println(Arrays.toString(heap));
	}

}

