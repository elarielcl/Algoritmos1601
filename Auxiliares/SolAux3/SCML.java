public class SCML {

    public static void main(String[] args) {
        
    	String X = "ABCBDAB";
        String Y = "BDCABA";
        
        int lX = X.length();
        int lY = Y.length();

        //En c[i][j] se tiene el largo de la SCML entre X1 ... Xi y Y1...Yj
        int[][] c = new int[lX+1][lY+1]; 
        for (int i = 1; i <= lX; i++) {
            for (int j = 1; j <= lY ; j++) {
            	if (X.charAt(i-1) == Y.charAt(j-1))
                    c[i][j] = c[i-1][j-1] + 1;
                else 
                    c[i][j] = Math.max(c[i-1][j], c[i][j-1]);
            }
        }
        System.out.println("Largo de SCML");
        System.out.println(c[lX][lY]);

        
        System.out.println("\nUna SCML");
        String reverso = "";
        int i = lX, j = lY;
        while(i > 0 && j > 0) {
        	
        	if (X.charAt(i-1) == Y.charAt(j-1)) {
            	reverso += X.charAt(i-1);
                i--;
                j--;
            }
        	
            else if (c[i-1][j] >= c[i][j-1]) 
            	i--;
            else
            	j--;
        }
        System.out.println(invertirString(reverso));

    }
    
    static public String invertirString(String a) {
    	
    	String inv = "";
    	for (int i = a.length()-1; i>=0; --i)
    	    inv += a.charAt(i);
    	return inv;
    	
    }

}
