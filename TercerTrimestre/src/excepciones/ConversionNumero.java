package excepciones;

import java.util.Iterator;

public class ConversionNumero {
	
	public static void main(String[] args) {
	
		String frase  = "Me llamo Paco y tengo: 18";
		
        int indiceInicio = frase.indexOf(':') + 2;
        int indiceFin = frase.length();
        String numero1 = frase.substring(indiceInicio, indiceFin);
 
        System.out.println("Primer número encontrado: " + numero1);
        
        int numeroEntero = Integer.parseInt(numero1);
       
        mayorEdad(numeroEntero);

		
	}
	
	public static void mayorEdad(int numeroEntero) {
		
	       if (numeroEntero >= 18) {
	    	   System.out.println("es mayor de edad");
	    	   
	    	   
	       }else {
	    	   System.out.println("es menor de edad");
	       }
		
	}

}
