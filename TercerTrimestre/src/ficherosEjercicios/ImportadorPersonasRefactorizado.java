package ficheros;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class ImportadorPersonasRefactorizado {

    public static void main(String[] args) {

        Path rutaFicheroPersonas = Paths.get("directorio/ficheroPrueva.csv");
        ArrayList<Persona> personasFichero;

        try {
            limpiarFicheroErrores();
            if (!Files.exists(rutaFicheroPersonas)) {
                System.err.println("No existe el fichero en la ruta " + rutaFicheroPersonas + ". No puedo realizar la importación");
            } else {
                List<String> lineasFichero = Files.readAllLines(rutaFicheroPersonas);

                if(lineasFichero.isEmpty()){
                    System.out.println("No hay líneas en el fichero. No puedo importar");
                }else{
                    System.out.println("El fichero tiene " + lineasFichero.size() + " líneas. Procediendo a " +
                            "procesarlas");
                    personasFichero = procesarLineasFichero(lineasFichero);

                    System.out.println("Terminada importacion. La Lista de personas es: " + personasFichero);
                    System.out.println("Nº de personas importadas: " + personasFichero.size());
                }
            }

        }catch (IOException excp){
            imprimirError(-1, "Error al interactuar con ficheros: "  + excp);
        }
    }

    private static ArrayList<Persona> procesarLineasFichero(List<String> lineasFichero) {
        int contLinea = 1;
        ArrayList<Persona> personasFichero = new ArrayList<>();
        for(String linea : lineasFichero){

            try {
                System.out.println("leyendo linea número:  " + contLinea + ": " + linea);
                Persona transformada = transformarLineaEnPersona(linea);
                if(transformada != null){
                    personasFichero.add(transformada);
                }
            }catch (NumberFormatException excepcionNumeros){
                imprimirError(contLinea, "Ha habido un error al transformar a entero: " +excepcionNumeros);
            }catch (Exception generica){
                imprimirError(contLinea,"Error general al transformar una línea: " + generica);
            }

            contLinea++;
        }

        return personasFichero;
    }

    private static Persona transformarLineaEnPersona(String linea) {
        String[] palabras = linea.split(",");
        Persona nuevaPersona = null;
        if (palabras.length != 0) {
            int id = Integer.parseInt(palabras[0]);
            String nombre = palabras[1];
            String dni = palabras[2];
            String rol = palabras[3];

            nuevaPersona = new Persona(id, nombre, dni, rol);
            System.out.println("Se ha generado una nueva persona:" + nuevaPersona);

        }

        return nuevaPersona;
    }

    public static void limpiarFicheroErrores() throws IOException {
        Path rutaFicheroErrores = Paths.get(ConstantesFicherosPersonas.CARPETA_EXPORTACIONES, ConstantesFicherosPersonas.ERRORES_LOG);

         Files.deleteIfExists(rutaFicheroErrores);

    }

    public static void imprimirError(int numLinea, String mensajeError){

        System.out.println("ERROR! IMPRIMIENDO ERROR EN FICHERO");
        Path rutaFicheroErrores = Paths.get(ConstantesFicherosPersonas.CARPETA_EXPORTACIONES, ConstantesFicherosPersonas.ERRORES_LOG);

        try {
            if(!Files.exists(rutaFicheroErrores)){
                Files.createFile(rutaFicheroErrores);
            }
            Files.writeString(rutaFicheroErrores, "LINEA " + numLinea + ": " + mensajeError + "\n",
                    StandardOpenOption.APPEND);
        } catch (IOException exc) {
            System.err.println("Error trabajando con el fichero de errores: " + exc);
        }
    }
}
