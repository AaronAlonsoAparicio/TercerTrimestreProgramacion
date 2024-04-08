package DawBank;

public class PruebaMovimientos {

	public static void main(String[] args) {

		Movimiento[] listaMovimientos = new Movimiento[5];
		
		Movimiento ingresoNomina = new Movimiento("Nomina", 1800);
		Movimiento compraZapatillas = new Movimiento("Zapatillas adidas", -95);
		
		listaMovimientos[0] = ingresoNomina;
		listaMovimientos[1] = compraZapatillas;

		for(int cont = 0; cont < listaMovimientos.length; cont++) {
			
			Movimiento unMovimiento = listaMovimientos[cont];
			
			if(unMovimiento != null) {
				unMovimiento.imprimir();
			}
		}
		
	}

}
