import java.util.Stack;

public class MayorSiguiente {

	public static void main(String[] args) {
		int [] a = {2, 9, 5, 13, 10};
		mayorSiguiente(a);

	}

	private static void mayorSiguienteIneficiente(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int mayorSiguiente = -1;
			for (int j = i; j < a.length; j++) {
				if (a[i] < a[j]) {
					mayorSiguiente = a[j];
					break;
				}
			}
			System.out.println(a[i] + "-->" + mayorSiguiente);
		}
	}
	
	private static void mayorSiguiente(int[] a) {
		Stack<Integer> pila = new Stack<Integer>();
		pila.push(a[0]);
		
		for (int i = 1; i < a.length; i++) {
			while (!pila.empty() &&  pila.peek() < a[i]) {
				System.out.println(pila.pop() + "-->" + a[i]);
			}
			pila.push(a[i]);
		}
		
		while (!pila.empty())
			System.out.println(pila.pop() + "-->" + -1);
	}

}

