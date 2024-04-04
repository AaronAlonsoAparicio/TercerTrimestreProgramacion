package DawBank;

import java.util.Scanner;

/**
 * Clase principal para interactuar con el usuario y gestionar la cuenta bancaria.
 */
public class DawBank {
    private static final String NOMBRE_BANCO = "DaWBank";

	public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido a " + NOMBRE_BANCO);

        // Pedir datos para crear la cuenta

        boolean ibanValido = false;
        String iban;
        do {
        	System.out.println("Ingrese el IBAN de la cuenta:");
        	iban = teclado.nextLine();
        	
        	ibanValido = CuentaBancaria.validarIban(iban);
        	if(!ibanValido) {
        		System.out.println("IBAN no válido: debe ser formado por 2 letras y 22 números");
        	}
        	
        }while(!ibanValido);
        
        
        
        System.out.println("Ingrese el nombre del titular:");
        String titular = teclado.nextLine();

        System.out.println("Ingrese el apellido del titular:");
        String apellidoTitular = teclado.nextLine();
        
        System.out.println("Ingrese el DNI del titular:");
        String dniTitular = teclado.nextLine();
        
        System.out.println("Ingrese la edad del titular:");
        int edadTitular = teclado.nextInt();
        
        Persona titularCuenta = new Persona(titular, apellidoTitular, dniTitular, edadTitular);
        
        
        CuentaBancaria cuenta = new CuentaBancaria(iban, titularCuenta);
        int opcion;

        do {
            mostrarMenu();
            String concepto;
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("IBAN: " + cuenta.getIban());
                    Persona infoTitular = cuenta.getTitular();
                    
                    infoTitular.imprimir();
                    
                    System.out.println("Saldo: " + cuenta.getSaldo());
                    break;
                case 2:
                    System.out.println("IBAN: " + cuenta.getIban());
                    break;
                case 3:
                	
                	cuenta.getTitular().imprimir();
                	
                	break;
                case 4:
                    System.out.println("Saldo: " + cuenta.getSaldo());
                    break;
                case 5:
                    System.out.println("Ingrese la cantidad a ingresar:");
                    double cantidadIngreso = teclado.nextDouble();
                    teclado.nextLine();
                    
                    System.out.println("¿Qué concepto ponemos?");
                    concepto = teclado.nextLine();
                    
                    cuenta.ingresar(cantidadIngreso, concepto);
                    break;
                case 6:
                    System.out.println("Ingrese la cantidad a retirar:");
                    double cantidadRetiro = teclado.nextDouble();
                    teclado.nextLine();
                    
                    System.out.println("¿Qué concepto ponemos?");
                    concepto = teclado.nextLine();
                    
                    cuenta.retirar(cantidadRetiro, concepto);
                    break;
                case 7:
                    cuenta.mostrarMovimientos();
                    break;
                case 8:
                    System.out.println("Gracias por usar " + NOMBRE_BANCO);
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 8);

        teclado.close();
    }

    private static void mostrarMenu() {
        System.out.println("\nMenu Principal");
        System.out.println("1. Datos de la cuenta");
        System.out.println("2. IBAN");
        System.out.println("3. Titular");
        System.out.println("4. Saldo");
        System.out.println("5. Ingreso");
        System.out.println("6. Retirada");
        System.out.println("7. Movimientos");
        System.out.println("8. Salir");
    }
}
