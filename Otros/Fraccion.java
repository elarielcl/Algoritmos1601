import java.util.Scanner;

public class Fraccion {
	private int num; //numerador
	private int den; //denominador
	
	public Fraccion(int num, int den) {
		if (den == 0) throw new NumberFormatException("Denominador 0");
		this.num = num;
		this.den = den;		
	}
	
	public Fraccion(String frac) {
		String[] partes = frac.split("/");
		if (partes.length != 2) throw new NumberFormatException("La fracción debe contener un único \"/\"");
		
		// Lo siguiente lanza su propio NumberFormatException en caso de fallar
		this.num = Integer.parseInt(partes[0]);
		this.den = Integer.parseInt(partes[1]);
	}
	
	public static int mcd(int a, int b) {
		while (b != 0) {
			int t = b;
			b = a%b;
			a = t;
		}
		return a;
	}
	
	public void simplificar() {
		int m = mcd(num,den);
		this.num /= m;
		this.den /= m;
	}
	
	public Fraccion suma(Fraccion other) {
		Fraccion sum = new Fraccion(this.num*other.den + other.num*this.den, this.den*other.den);
		sum.simplificar();
		return sum;
	}
	
	@Override
	public String toString() {
		return this.num + "/" + this.den;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Fraccion acc = new Fraccion(0,1);
		System.out.println("n?");
		int n = in.nextInt();
		for (int i = 1; i <= n; ++i) {
			System.out.println("Fraccion "+ i + "?");
			acc = acc.suma(new Fraccion(in.next()));
		}
		System.out.println("La suma total es: " + acc.toString());
		
	}

}
