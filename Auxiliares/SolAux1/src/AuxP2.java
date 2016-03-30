import java.util.Scanner;

/**
 * Problema 2 - Auxiliar 1
 *
 */
public class AuxP2 {

	public static void main(String[] args) {
		
		//Parte c
		Scanner sc = new Scanner(System.in);
		String frase = sc.nextLine();
		frase = borrar(' ',frase); //Los char se escriben con ' y los String con "
		frase = frase.toLowerCase(); //Recordar que los strings son inmutables
		System.out.println(esPalindrome(frase));
		
	}
	
	//Parte a
	public static boolean esPalindrome(String palabra){
		
		for(int i=0; i<palabra.length()/2; i++){
			if(palabra.charAt(i)!=palabra.charAt(palabra.length()-1-i)){
				return false;
			}
		}
		
		return true;
	}
	
	//Parte b
	public static String borrar(char c, String p){
		String x = ""; //Aqui se irá guardando la palabra sin el caracter
		for(int i=0; i<p.length(); i++){
			if(c!=p.charAt(i)){
				x += p.charAt(i);
			}
		}
		return x;
	}

}
