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
        altizq = altura(a.izq);
        altder = altura(a.der);
        
        //Verificar si es ABB
        if ((a.izq == null || a.izq.valor < a.valor) && 
        		(a.der == null || a.der.valor > a.valor)) {
            
        	//Verificar si la condici�n de AVL se cumple
	        if (Math.abs(altizq - altder) <= 1
	                && esAVL(a.izq)
	                && esAVL(a.der)) {
	            return true;
	        }
        }

        //Al encontrar un nodo que no cumpla la condicion, se termina
        return false;
	}
	
	static boolean esAVLlin(Arbol a){
		return alturaBalanceado(a) != -1;
	}
	
	private static int alturaBalanceado(Arbol a) {
		if(a==null) return 0;
		int altizq = alturaBalanceado(a.izq);
		int altder = alturaBalanceado(a.der);
		
		//Alguno de los hijos no es AVL
		if (altizq == -1 || altder == -1) return -1;
		
		//En este nivel no se cumple que es ABB
		if (!(  (a.izq == null || a.izq.valor < a.valor) && 
        		(a.der == null || a.der.valor > a.valor))	) return -1;
		
		//En este nivel no se cumple que es AVL
		if(Math.abs(altizq-altder) > 1) return -1;
		
		return 1 + Math.max(altizq, altder);
	}

	public static int altura(Arbol a){
		if(a == null) return 0;
		return 1 + Math.max(altura(a.izq), altura(a.der));
	}
	
	static public void main(String [] args) {
		//Arbol balanceado que no es ABB
		Arbol a = new Arbol(new Arbol(null, null, 4), new Arbol(null, null, 2), 3);
		//Arbol no balanceado
		Arbol b = new Arbol(new Arbol(new Arbol(null,null,1),null,2),null,3);
		//Arbol AVL
		Arbol c = new Arbol(new Arbol(new Arbol(null,null,1),null,2),new Arbol(null,null,4),3);
		
		System.out.println(esAVL(a));
		System.out.println(esAVL(b));
		System.out.println(esAVL(c));
		
		System.out.println(esAVLlin(a));
		System.out.println(esAVLlin(b));
		System.out.println(esAVLlin(c));
	}
}

