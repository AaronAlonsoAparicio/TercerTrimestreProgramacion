package ficherosEjercicios;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Ejercicio1Personas {

	private static final String NombreDirectorio = "directorio";

	public static void main(String[] args) {
		/**
		 * Vais a crear la clase Persona, con: - un numero de id - nombre - dni - rol
		 *
		 * Vais a crear varios objetos de la clase Persona, con valores que os
		 * inventéis. Tendréis que implementar en la clase Persona un método para
		 * convertir la información de esa persona a "formato CSV" (separado por comas)
		 *
		 * Vais a crear un fichero en la carpeta "exportaciones", con nombre
		 * "personasClase.csv" que contenga la información de las personas. Cada persona
		 * en una linea
		 *
		 * Controlar las posibles excepciones y mostrar mensajes acordes
		 *
		 */

		crearDirectorio();

		Path rutaArchivoPath = RutaDelArchivo();

		if (Files.exists(rutaArchivoPath)) {
			ArrayList<String> personas = new ArrayList();

			Persona persona1 = new Persona(1, "Aaron", "31247897H", "Alumno");
			Persona persona2 = new Persona(2, "Julian", "32443243J", "Alumno");
			Persona persona3 = new Persona(3, "Miguel", "67565454K", "Alumno");
			Persona persona4 = new Persona(4, "Cristian", "54678094B", "Alumno");

			personasACsv(personas, persona1, persona2, persona3, persona4);

			try {
				Files.write(rutaArchivoPath, personas);
			} catch (IOException e) {
				System.out.println("El archivo o directorio ya existe.");
			}

		}

	}

	private static Path RutaDelArchivo() {
		Path rutaArchivoPath = Paths.get(NombreDirectorio + "/ficheroPrueba.csv");

		try {
			Files.createFile(rutaArchivoPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rutaArchivoPath;
	}

	private static void personasACsv(ArrayList<String> personas, Persona persona1, Persona persona2, Persona persona3,
			Persona persona4) {
		personas.add(persona1.toCSV());
		personas.add(persona2.toCSV());
		personas.add(persona3.toCSV());
		personas.add(persona4.toCSV());
	}

	public static void crearDirectorio() {
		Path directorio = Paths.get(NombreDirectorio);

		try {
			if (!Files.exists(directorio)) {
				Files.createDirectory(directorio);
				System.out.println("Directorio creado con exito.");

			}

		} catch (Exception excepcion) {
			System.out.println("El directorio ya existe.");
		}

	}

}