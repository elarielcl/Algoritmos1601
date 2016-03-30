public class Invertir {
    static public void main(String[] args) {
	int[] a = {1, 2, 3, 4};
	invertirArreglo(a);
	
	System.out.println("Arreglo invertido");
	for (int i : a)
	    System.out.println(i);
	System.out.println("");
	
	//Dado que los strings son inmutables
	//no podemos ocupar el mismo concepto
	//anterior para invertir el arreglo

	//En vez de eso podemos "construir"
	//el String que corresponde al inverso
	
	String b = "HolA";
	String inverso = invertirString(b);
	System.out.println(b);
	System.out.println(inverso);

	//Sin embargo, podemos aplicar la idea
	//anterior usando un pequeño truco
	char[] cInverso = b.toCharArray();
	invertirArreglo(cInverso);
	System.out.println(new String(cInverso));
	
    }

    
    static public void invertirArreglo(int[] a) {
	int N = a.length;
	for (int i = 0; i<N/2; ++i) {
	    int t = a[i];
	    a[i] = a[N-i-1];
	    a[N-i-1] = t;
	}
    }

    static public String invertirString(String a) {
	String inv = "";
	for (int i = a.length()-1; i>=0; --i)
	    inv += a.charAt(i);
	return inv;
    }

    static public void invertirArreglo(char[] a) {
	int N = a.length;
	for (int i = 0; i<N/2; ++i) {
	    char t = a[i];
	    a[i] = a[N-i-1];
	    a[N-i-1] = t;
	}
    }
}
