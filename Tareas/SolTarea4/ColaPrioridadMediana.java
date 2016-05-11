import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ColaPrioridadMediana {

	private double[] mitadSuperior; //Min-Heap
	private int N1; //Numero de elementos de mitadSuperior
	
	private double[] mitadInferior; //Max-Heap
	private int N2; //Numero de elementos de mitadInferior
	
	private int capacidad;
	
	public ColaPrioridadMediana(int cap) {
		mitadSuperior = new double[cap/2 + 3];
		N1 = 0;
		
		mitadInferior = new double[cap/2 + 3];
		N2 = 0;
		
		capacidad = cap;
	}
	
	public ColaPrioridadMediana() {
		this(100);
	}
	
	public void insertar(double x) {
		if (N1+N2 == capacidad) {
			System.out.println("Se ha sobrepasado la capacidad máxima del TDA");
			System.exit(0);
		}
		if (x < mitadInferior[1]) {
			insertMax(x);
		}else {
			insertMin(x);
		}
		
		if (Math.abs(N1-N2) == 2) {
			if (N1 < N2) {
				insertMin(delMax());
			}
			else {
				insertMax(delMin());
			}
		}
	}
	
	public double getMediana() {
		if (N1 == N2) return (mitadSuperior[1] + mitadInferior[1])/2;
		else if (N1 > N2) return mitadSuperior[1];
		return mitadInferior[1];
	}
	
	private void insertMin(double x) {
        mitadSuperior[++N1] = x;
        swimMin(N1);
    }
	
	private double delMin() {
		double t = mitadSuperior[1];
    	mitadSuperior[1] = mitadSuperior[N1];
    	mitadSuperior[N1] = t;
        double min = mitadSuperior[N1--];
        sinkMin(1);
        return min;
    }
	
	 private void swimMin(int k) {
	        while (k > 1 && mitadSuperior[k/2] > mitadSuperior[k]) {
	        	double t = mitadSuperior[k];
	        	mitadSuperior[k] = mitadSuperior[k/2];
	        	mitadSuperior[k/2] = t;
	            k = k/2;
	        }
	    }

	    private void sinkMin(int k) {
	        while (2*k <= N1) {
	            int j = 2*k;
	            if (j < N1 && mitadSuperior[j] > mitadSuperior[j+1]) j++;
	            if (mitadSuperior[k] <= mitadSuperior[j]) break;
	            double t = mitadSuperior[k];
	        	mitadSuperior[k] = mitadSuperior[j];
	        	mitadSuperior[j] = t;
	            k = j;
	        }
	    }
	
	    private void insertMax(double x) {
	        mitadInferior[++N2] = x;
	        swimMax(N2);
	    }
		
		private double delMax() {
			double max = mitadInferior[1];
			double t = mitadInferior[1];
			mitadInferior[1] = mitadInferior[N2];
			mitadInferior[N2] = t;
			N2--;
	        sinkMax(1);
	        return max;
	    }
		
		 private void swimMax(int k) {
		        while (k > 1 && mitadInferior[k/2] < mitadInferior[k]) {
		        	double t = mitadInferior[k];
		        	mitadInferior[k] = mitadInferior[k/2];
		        	mitadInferior[k/2] = t;
		            k = k/2;
		        }
		    }

		    private void sinkMax(int k) {
		        while (2*k <= N2) {
		            int j = 2*k;
		            if (j < N2 && mitadInferior[j] < mitadInferior[j+1]) j++;
		            if (mitadInferior[k] >= mitadInferior[j]) break;
		            double t = mitadInferior[k];
		        	mitadInferior[k] = mitadInferior[j];
		        	mitadInferior[j] = t;
		            k = j;
		        }
		    }

	
	
	public static void main(String[] args) throws IOException {
		ColaPrioridadMediana c = new ColaPrioridadMediana();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		while (!(linea = in.readLine()).equals("")) {
			c.insertar(Double.parseDouble(linea));
		}
		System.out.println("El subsidio aplica hasta $" + c.getMediana() + " de ingreso familiar");

	}

}

