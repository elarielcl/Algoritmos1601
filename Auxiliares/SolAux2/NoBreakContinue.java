import java.util.Scanner;
public class NoBreakContinue {
    static public void main(String[] args) {
	double suma = 0, n = 0, x;
	Scanner in = new Scanner(System.in);
	while ((x = in.nextDouble()) != 0)
	    if (1 <= x && x <= 7) {
		suma += x;
		n++;
	    }
	System.out.println("Promedio = " + suma/n);
    }
}
