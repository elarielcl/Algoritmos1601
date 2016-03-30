/**
 * Problema 1 - Auxiliar 1
 *
 */
public class Punto {
	
	//Campos para almacenar las coordenadas
	double x;
	double y;
	
	//Constructor
	public Punto(double x0, double y0){
		x = x0;
		y = y0;
	}

	public void moveBy(double dx, double dy){
		x += dx;
		y += dy;
	}
	
	public void moveTo(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public void scaleBy(double scale){
		x = scale*x;
		y *= scale;
	}
	
	//Este método devuelve un punto por lo que no cambia las coordenadas del punto actual
	public Punto substract(Punto other){
		double px = this.x-other.x;
		double py = this.y-other.y;
		Punto fin = new Punto(px,py);
		return fin;
	}
	
	public double module(){
		return Math.sqrt(x*x+y*y);
	}
	
	
}
