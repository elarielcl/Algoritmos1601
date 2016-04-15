/* Adapted from http://algs4.cs.princeton.edu/13stacks/Evaluate.java */
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShuntingYard {
	
	public static void main(String[] args) throws IOException { 
        Stack<String> ops  = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();

        String[] tokens = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
		    String s = tokens[i];
            if      (s.equals("("))               ;
            else if (s.equals("+"))    ops.push(s);
            else if (s.equals("-"))    ops.push(s);
            else if (s.equals("*"))    ops.push(s);
            else if (s.equals("/"))    ops.push(s);
            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if      (op.equals("+"))    v = vals.pop() + v;
                else if (op.equals("-"))    v = vals.pop() - v;
                else if (op.equals("*"))    v = vals.pop() * v;
                else if (op.equals("/"))    v = vals.pop() / v;
                vals.push(v);
            }
            else vals.push(Double.parseDouble(s));
        }
        System.out.println(vals.pop());
    }
}

