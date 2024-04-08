package excepciones;

import java.util.Random;
import java.util.Scanner;

public class ErrorArray {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Random aleatorios = new Random();

		int[] errores = new int[5];
		
		for (int contador = 0; contador < errores.length; contador++) {
			errores[contador] = aleatorios.nextInt(1,5);

		}
		System.out.println("Dame que posicion quieres que te muestre");
		int posicion = teclado.nextInt();
		
		try {
			System.out.println(errores[posicion]);
			;
			;
			;
		} catch (ArrayIndexOutOfBoundsException excepcion) {
			System.out.println("Esta posicion no esta en el array");
		}finally {
			
			teclado.close();
			System.out.println("Fin del programa.");
			
		}
		
		
		
		

	}

}
