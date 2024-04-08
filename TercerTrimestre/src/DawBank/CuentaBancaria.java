package DawBank;

/**
 * Clase que representa una cuenta bancaria con operaciones básicas como
 * ingresos, retiradas y seguimiento de movimientos.
 */
public class CuentaBancaria {
	private static final int NUM_MAX_MOVIMIENTOS = 10;

	private final String iban;
	private final Persona titular;
	private double saldo;
	private final Movimiento[] listaMovimientos;

	private int numMovimientos;

	public CuentaBancaria(String iban, Persona titular) {
		this.iban = iban;
		this.titular = titular;
		this.saldo = 0;
		this.listaMovimientos = new Movimiento[NUM_MAX_MOVIMIENTOS];
		this.numMovimientos = 0;
	}

	public boolean ingresar(double cantidad, String concepto) throws CuentaException {

		boolean exito = false;
		if (cantidad > 0) {
			saldo += cantidad;
			registrarMovimiento(cantidad, concepto);
			comprobacionHacienda(cantidad);
			exito = true;
		} else {
			throw new CuentaException("Error al ingresar");
		}

		return exito;
	}

	public boolean retirar(double cantidad, String concepto) throws CuentaException {
		boolean exito = false;
		if (cantidad > 0 && (saldo - cantidad) >= -50) {
			saldo -= cantidad;
			registrarMovimiento(-cantidad, concepto);
			comprobacionSaldoNegativo();
			exito = true;
		} else {
			String mensajeException;
			if (cantidad < 0) {

				mensajeException = "Cantidad no validad al retirar";

			} else {

				mensajeException = " Con esta cantidad la cuenta se va a quedar a negativo";
			}

			throw new CuentaException(mensajeException);

		}

		return exito;
	}

	public void mostrarMovimientos() {
		System.out.println("Movimientos de la cuenta:");
		for (int cont = 0; cont < listaMovimientos.length; cont++) {

			Movimiento unMovimiento = listaMovimientos[cont];

			if (unMovimiento != null)
				unMovimiento.imprimir();

		}
	}

	private void registrarMovimiento(double importe, String concepto) {

		Movimiento movimientoCuenta = new Movimiento(concepto, importe);

		if (numMovimientos < NUM_MAX_MOVIMIENTOS) {

			listaMovimientos[numMovimientos] = movimientoCuenta;
			numMovimientos++;
		} else {
			desplazarMovimientos();
			listaMovimientos[listaMovimientos.length - 1] = movimientoCuenta;
		}
	}

	private void desplazarMovimientos() {

		for (int cont = 0; cont < listaMovimientos.length - 1; cont++) {
			listaMovimientos[cont] = listaMovimientos[cont + 1];
		}
	}

	// Para que veamos cómo se haría con la función de copia de arrays
	private void desplazarMovimientosCopiaArray() {
		System.arraycopy(listaMovimientos, 1, listaMovimientos, 0, listaMovimientos.length - 1);
	}

	private String esIngresoORetirada(double movimiento) {
		return movimiento > 0 ? "+" : "-";
	}

	private void comprobacionHacienda(double cantidad) {
		if (cantidad > 3000) {
			System.out.println("AVISO: Notificar a hacienda");
		}
	}

	private void comprobacionSaldoNegativo() {
		if (saldo < 0) {
			System.out.println("AVISO: Saldo negativo");
		}
	}

	public String getIban() {
		return iban;
	}

	public Persona getTitular() {
		return titular;
	}

	public double getSaldo() {
		return saldo;
	}

	// Funcion útil para validar un IBAN pero era necesario saber cómo saber si un
	// caracter es letra o número
	public static boolean validarIban(String iban) {
		if (iban.length() != 24) {
			return false;
		}

		// Verificamos que los dos primeros caracteres sean letras
		for (int cont = 0; cont < 2; cont++) {
			char ch = iban.charAt(cont);
			if (!Character.isLetter(ch)) {
				return false;
			}
		}

		// Verificamos que los siguientes 22 caracteres sean dígitos
		for (int cont = 2; cont < 24; cont++) {
			char ch = iban.charAt(cont);
			if (!Character.isDigit(ch)) {
				return false;
			}
		}

		return true;
	}
}
