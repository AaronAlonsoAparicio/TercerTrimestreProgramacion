package DawBank;

public class Constantes {
	
	 private static final String OPERACION_DESCONOCIDA = "Operacion desconocida";

	private static final String RETIRADA = "Retirada";

	private static final String INGRESO = "Ingreso";

	public static final int OPERACION_INGRESO = 1;
	 
	 public static final int OPERACION_RETIRADA = 2;
	 
	 public static String getNombreOperacion (int codigoOpereacion) {
		 
		 
		 if (codigoOpereacion == OPERACION_INGRESO) {
			 return INGRESO;
			
		}else if (codigoOpereacion == OPERACION_RETIRADA){
			return RETIRADA;
			
		}else {
			return OPERACION_DESCONOCIDA;
			
			
		}
		 
	 }
	 
	 
	
	

}
