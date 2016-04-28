
public class Arbol {
	public Arbol izq;
	public Arbol der;
	public int valor;
	
	public Arbol(){
		izq=null;
		der=null;
	}
	
	public Arbol(Arbol izq, Arbol der, int valor){
		this.izq = izq;
		this.der = der;
		this.valor = valor;
	}
	/*ineficiente*/
	static public boolean esAVL(Arbol a){
		int altizq, altder;
        if (a == null) { //caso base
            return true;
        }
        //Altura de los subarboles
        altizq = a.izq.altura();
        altder = a.der.altura();
        //Verificar si la condición de AVL se cumple
        if (Math.abs(altizq - altder) <= 1
                && esAVL(a.izq)
                && esAVL(a.der)) {
            return true;
        }
        //Al encontrar un nodo que no cumpla la condicion, se termina
        return false;
	}
	
	static boolean esAVLlin(Arbol a){
		boolean [] result = {true};
		int altura = alturaBalanceado(a, result);
		return result[0];
	}
	
	private static int alturaBalanceado(Arbol a, boolean[] result) {
		if(a==null) return 0;
		int altizq = alturaBalanceado(a.izq, result);
		int altder = alturaBalanceado(a.der, result);
		
		if(Math.abs(altizq-altder) > 1){
			result[0] = false;
		}
		
		return 1 + Math.max(altizq, altder);
	}

	public int altura(){
		if(this == null) return 0;
		return 1 + Math.max(this.izq.altura(), this.der.altura());
	}
}
