/*
 * Codigo original con modifier static mal escrito
 * y error producto de division entera, por ejemplo,
 * mayor(4, 3) entrega 3
 */
public class Mayor {
    static public void main(String[] args) {
	System.out.println(mayor(4, 3));
    }
    static public int mayor(int x, int y) {
	return (int) ((x+y)/2.0 + Math.abs((x-y)/2.0));
    }
}
