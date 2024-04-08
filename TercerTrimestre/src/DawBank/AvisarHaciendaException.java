package DawBank;

public class AvisarHaciendaException  extends Exception {
	
	private Persona infoTitular;
	private String iban;
	private int operacion;
	
	
	public AvisarHaciendaException(Persona infoTitular, String iban, int operacion) {
		super();
		this.infoTitular = infoTitular;
		this.iban = iban;
		this.operacion = operacion;
	}
	
	
	
	
	

}
