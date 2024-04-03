package ficheros;

	import java.io.IOException;
	import java.nio.file.*;
	import java.util.ArrayList;
	import java.util.List;

	public class LectorFichero {
	    public static void main(String[] args) {

	        String nombreCompletoFichero = "/home/diego/ficheroPACO.txt";
	        Path rutaFichero = Paths.get(nombreCompletoFichero);

	            try {
	                ArrayList<String> lineas = (ArrayList<String>)Files.readAllLines(rutaFichero);

	                System.out.println("Vamos a mostrar el contenido del fichero: " + nombreCompletoFichero);
	                for(String linea : lineas){
	                    System.out.println(linea);
	                }
	                System.out.println("[Final del fichero]");
	            } catch (NoSuchFileException e) {
	                System.err.println("Ese fichero no existe");
	            } catch (FileSystemException e) {
	                System.err.println("Excepcion de sistema de ficheros " + e);
	            } catch (IOException e) {
	                System.err.println("Excepcion generica al consultar el fichero " + e);
	            }
	    }
	}
	
	
	


