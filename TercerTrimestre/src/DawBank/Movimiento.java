package DawBank;

import java.time.LocalDateTime;

public class Movimiento {

	private String concepto;
	private double importe;
	private LocalDateTime fechaHora;
	
	
	public Movimiento(String concepto, double importe) {
		this.concepto = concepto;
		this.importe = importe;
		this.fechaHora = LocalDateTime.now();
	}
	
	public void imprimir() {
		System.out.println(toString());
	}
	
	
	
	@Override
	public String toString() {
		return "Movimiento [concepto=" + concepto + ", importe=" + importe + ", fechaHora=" + fechaHora + "]";
	}

	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	
//	private LocalDateTime fechaHoraMov;
	
	
}
