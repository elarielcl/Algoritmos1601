public class CoinGame {

	private static final int NOTHING = 0;
	private static final int R = 1;
	private static final int A = 2;
	private static final int C = 3;
	private static final int CC = 4;
	private static final int CS = 5;


	static public boolean lanzarMoneda() {
		return Math.random() >= 0.5;
	}
	
	static public boolean juegoConMonedas() {
		int estado = NOTHING;
		while (estado != R && estado != A) {
			boolean cara = lanzarMoneda();
			if (estado == NOTHING) {
				if (cara) {
					estado = C;
				}
			}
			else if (estado == C) {
				if (cara) {
					estado = CC;
				}else {
					estado = CS;
				}
			}else if (estado == CC) {
				if (!cara) {
					estado = A;
				}
			}else { //CS
				if (cara) {
					estado = C;
				}else {
					estado = R;
				}
			}
		}
		return estado == R;
	}
	 
    
    static public void main(String[] args) {
    	int n = 100000;
    	int ganaRoberto = 0;
    	for (int i = 0; i<n; ++i)
    		if (juegoConMonedas())
    			++ganaRoberto;
    	System.out.println("Porcentaje de juegos que Gana Alicia: " + 100.0*(n-ganaRoberto)/n);
    	System.out.println("Porcentaje de juegos que Gana Roberto: " + 100.0*(ganaRoberto)/n);
    }
}