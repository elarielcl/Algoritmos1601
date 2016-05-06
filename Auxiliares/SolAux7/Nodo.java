public class Nodo{
	
	Nodo izq, der;
	int info;
	
	public Nodo(Nodo izq, int info, Nodo der){
		this.info = info;
		this.izq = izq;
		this.der = der;
	}
	
	public int altura(){
		if(this == null) return 0;
		int altizq = izq == null? 0 : izq.altura();
		int altder = der == null? 0 : der.altura();
		return 1 + Math.max(altizq, altder);
	}
}