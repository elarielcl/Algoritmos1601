import java.util.Scanner;

public class Romano {

	//Suponemos que el numero es un numero romano bien formateado
	public static int romano(String num) {
		int acc = 0;
		boolean lastI = false, lastX = false;
		for (int i = 0; i<num.length(); ++i) {
			char c = num.charAt(i);
			switch (c) {
				case 'I' :
					++acc;	
					lastI = true;
					lastX = false;
					break;
				case 'V' :
					if (lastI) acc += 3; // Porque ya se sumo 1 de I
					else acc += 5;
					lastI = false;
					lastX = false;
					break;
				case 'X' :
					if (lastI) acc += 8; // Porque ya se sumo 1 de I
					else acc += 10;
					lastI = false;
					lastX = true;
					break;
				case 'L':
					if (lastX) acc += 30;// Porque ya se sumaron 10 de X
					else acc += 50;
					lastI = false;
					lastX = false;
					break;
			}
		}
		return acc;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(romano(in.next()));
	}

}
