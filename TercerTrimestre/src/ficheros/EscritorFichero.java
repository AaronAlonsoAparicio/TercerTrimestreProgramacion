package ficheros;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;

public class EscritorFichero {

    public static void main(String[] args) {
        Path pathFichero = Paths.get("/home/diego/fichero2.txt");

        try {
            Files.writeString(pathFichero, "Paco", StandardOpenOption.APPEND);

            System.out.println("Fichero escrito");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
