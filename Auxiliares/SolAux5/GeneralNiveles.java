import java.util.LinkedList;
import java.util.Queue;

public class GeneralNiveles {

	public static void main(String[] args) {
		Arbol a = new Arbol(new Arbol(null, new Arbol(null ,null,3),2), null, 1);
		imprimirPorNiveles(a);
	}
	
	private static void imprimirPorNiveles(Arbol a) {
		Queue<Arbol> q = new LinkedList<Arbol>();
		q.add(a);

        while (!q.isEmpty()) {
            Arbol v = q.remove();
            System.out.println(v.valor); // Visitar
            Arbol hijo = v.hijo;
            while (hijo != null) {
            	q.add(hijo);
            	hijo = hijo.hermano;
            }
        }
	}

}

class Arbol {
	public Arbol hijo;
	public Arbol hermano;
	public int valor;
	
	public Arbol(){
		hijo=null;
		hermano=null;
	}
	
	public Arbol(Arbol hijo, Arbol hermano, int valor){
		this.hijo = hijo;
		this.hermano = hermano;
		this.valor = valor;
		}
}
