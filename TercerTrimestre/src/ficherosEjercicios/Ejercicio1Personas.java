package ficherosEjercicios;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Ejercicio1Personas {
	
	public static void main(String[] args) {
		/**
		 * Vais a crear la clase Persona, con:
		 * - un numero de id
		 * - nombre
		 * - dni
		 * - rol
		 *
		 * Vais a crear varios objetos de la clase Persona, con valores que os inventéis.
		 * Tendréis que implementar en la clase Persona un método para convertir la información de esa persona a "formato
		 * CSV" (separado por comas)
		 *
		 * Vais a crear un fichero en la carpeta "exportaciones", con nombre "personasClase.csv" que contenga la información de las personas. Cada persona en una linea
		 *
		 * Controlar las posibles excepciones y mostrar mensajes acordes
		 *
		 * */ 
		
		
	
		
	Path rutaArchivoPath = Paths.get("ficheroPrueba.csv");

	
	try {
		Files.createFile(rutaArchivoPath);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	if(Files.exists(rutaArchivoPath)) {
			ArrayList<Persona> personas = new ArrayList();
		
		personas.add(new Persona(1,"Aaron", "31247897H", "Alumno"));
		personas.add(new Persona(2,"Julian","32443243J","Alumno"));
		personas.add(new Persona(3,"Miguel","67565454K","Alumno"));
		
		
		
		for (Persona persona : personas) {
			String lista = persona.toCSV();
			Files.write(rutaArchivoPath, lista);
			
			
			
			
		}
		
	
		
	}
		
		
		
		
		
		
		
		
		
	}

}
