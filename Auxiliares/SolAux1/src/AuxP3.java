import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Problema 3 - Auxiliar 1
 *
 */
public class AuxP3 {

	public static void main(String[] args) {
		
		//Los codigos que pueden generar excepciones deben estar cubiertos por un try/catch
		try {
			System.out.println("Parte a");
			PA();
			System.out.println("Parte b");
			PB();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	//Parte a
	public static void PA() throws IOException{
		//FileReader genera un lector para el streaming de archivos
		FileReader reader = new FileReader(new File("notas.txt"));
		BufferedReader buffer = new BufferedReader(reader);
		
		//Se pueden leer linea por linea del buffer
		String linea = buffer.readLine();
		
		//Contadores
		int azules = 0;
		int rojos = 0;
		int total = 0;
		
		while(linea!=null){ //Mientras la linea leida contenga información
			total++;
			String[] componentes = linea.split(";");
			
			double c1 = Double.parseDouble(componentes[1]);
			double c2 = Double.parseDouble(componentes[2]);
			double c3 = Double.parseDouble(componentes[3]);
			
			double prom = (c1+c2+c3)/3.0; //3.0 hace que se convierta a un double
			
			if(prom>=4){
				azules++;
			}
			else{
				rojos++;
			}
			
			linea = buffer.readLine(); //Se lee la linea siguiente
			
		}
		
		System.out.println("Azules:"+(100*azules/total)+"%");
		System.out.println("Rojo:"+(100*rojos/total)+"%");
		
	}
	
	//Parte b
	public static void PB() throws IOException{
		//FileWriter genera un escritor para el archivo eximidos.txt
		FileWriter writer = new FileWriter(new File("eximidos.txt"));
		
		//Se lee notas.txt de la misma forma que en la parte a
		FileReader reader = new FileReader(new File("notas.txt"));
		BufferedReader buffer = new BufferedReader(reader);
		
		String linea = buffer.readLine();
		
		String eximidos = ""; //Almacenara los datos de los eximidos
		
		while(linea!=null){
			String[] componentes = linea.split(";");
			
			double c1 = Double.parseDouble(componentes[1]);
			double c2 = Double.parseDouble(componentes[2]);
			double c3 = Double.parseDouble(componentes[3]);
			
			double prom = (c1+c2+c3)/3.0;			
			
			//Se evalua si esta eximido
			if(prom >= 5.5){
				eximidos += componentes[0]+"\n";
			}
			
			linea = buffer.readLine();
		}
		
		//Se escribe en el archivo y se cierra
		writer.write(eximidos);
		writer.close();
		
	}

}
