package excepciones;

import java.util.Scanner;

public class ExplicacionDivisionPorCero {
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("dime el 1 numero");
		int num1 = teclado.nextInt();
		System.out.println("dame el 2 numero");
		int num2 = teclado.nextInt();
		try {
			System.out.println("La division es: " + operacionAritmetica(1, num1, num2));
			;
			;
			;
		} catch (ArithmeticException excepcion) {
			System.out.println("Error no se puede dividir entre 0: "+ excepcion.getMessage() );
			
		
		}
	

	}

	public static double division(int num1, int num2) {
		return num1 / num2;

	}

	public static double operacionAritmetica(int operacion, int num1, int num2) {
		if (operacion == 1) {
			return division(num1, num2);

		} else {
			return -1;

		}

	}

}
