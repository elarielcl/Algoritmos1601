import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Expresion {

	class Arbol {
		public String val;
		public Arbol left;
		public Arbol right;
	}
	private Arbol root;
	public Expresion(String formula) throws Exception {
		String [] tokens = formula.split(" ");
		Stack<Arbol> s = new Stack<Arbol>();
		
		for (String token : tokens) {
			Arbol current = new Arbol();
			current.val = token;
			if (token.equals("_"))current.left = s.pop(); 
			else if (isOperator(token)) {
				current.right = s.pop();
				current.left = s.pop();
			}
			s.push(current);
		}
		
		if (s.size() != 1) throw new Exception("Not an expression");
		root = s.pop();
	}
	
	public String toSimpleString() {
		return recursiveToSimpleString(root);
	}
	
	static String recursiveToSimpleString(Arbol a) {
		if (a.right == null) {
			if (a.left == null) return a.val;
			return "(-" + recursiveToSimpleString(a.left) + ")";
		}
		return "(" + recursiveToSimpleString(a.left) + a.val + recursiveToSimpleString(a.right) + ")";
	}
	
	public String toString() {
		return recursiveToString(root);
	}

	static String recursiveToString(Arbol a) {// Padres deciden si poner paréntesis
		String retorno = null;
		if (a.right == null) {
			if (a.left == null) retorno = a.val;
			else {
				retorno = recursiveToString(a.left);
				if (isOperator(a.left.val)) retorno = "("+retorno+")";
				retorno = "-"+retorno;
			}
		}
		else {
			String left = recursiveToString(a.left);
			String right = recursiveToString(a.right);
			if (a.val.equals("+")) {
				if (a.left.val.equals("_")) left = "(" + left + ")";
				if (a.right.val.equals("_")) right = "(" + right + ")";
				retorno = left + "+" + right;
			}else if (a.val.equals("-")) {
				if (a.left.val.equals("_")) left = "(" + left + ")";
				if (a.right.val.equals("_") || a.right.val.equals("+") || a.right.val.equals("-")) right = "(" + right + ")";
				retorno = left + "-" + right;
			}else if (a.val.equals("*")) {
				if (a.left.val.equals("_")|| a.left.val.equals("+") || a.left.val.equals("-")) left = "(" + left + ")";
				if (a.right.val.equals("_")|| a.right.val.equals("+") || a.right.val.equals("-")) right = "(" + right + ")";
				retorno = left + "*" + right;
			}else if (a.val.equals("/")) {
				if (a.left.val.equals("_")|| a.left.val.equals("+") || a.left.val.equals("-")) left = "(" + left + ")";
				if (isOperator(a.right.val)) right = "(" + right + ")";
				retorno = left + "/" + right;
			}
		}
		
		return retorno;
	}

	static boolean isOperator(String token) {
		return token.equals("_") || token.equals("-") || token.equals("+") || token.equals("*") || token.equals("/");
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String postfijo = in.readLine();
			try {
				Expresion e = new Expresion(postfijo);
				System.out.println(e.toString());
			} catch (Exception e) {
				System.out.println("Formula incorrecta");
			}
		}
	}

}

