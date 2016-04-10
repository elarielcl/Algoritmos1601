import java.util.Scanner;

public class Koch {
	static int LMIN = 5;
	
	public static void curvaDeKoch(Turtle tortuga, int largo) {
		if (largo < LMIN) tortuga.goForward(largo);
		else {
			curvaDeKoch(tortuga, largo/3);
			tortuga.turnLeft(60);
			curvaDeKoch(tortuga, largo/3);
			tortuga.turnRight(120);
			curvaDeKoch(tortuga, largo/3);
			tortuga.turnLeft(60);
			curvaDeKoch(tortuga, largo/3);
		}
		
	}
	
	public static void main(String[] args) {
		int l = 189;
		System.out.print("Angulo de rotación: ");
		double a = new Scanner(System.in).nextDouble();
		Turtle t  = new Turtle(l, l, 150-a, 2*l,2*l);
        
		t.setPenUp();
        t.goForward(l*Math.sqrt(7)/4);
        t.turnRight(150);
        
        t.setPenDown();
        curvaDeKoch(t, l);
        t.turnRight(120);
        curvaDeKoch(t, l);
        t.turnRight(120);
        curvaDeKoch(t, l);

	}

}
