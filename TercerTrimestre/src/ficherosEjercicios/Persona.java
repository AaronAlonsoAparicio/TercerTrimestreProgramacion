package ficherosEjercicios;

import java.util.ArrayList;

public class Persona {

	 int id;
	 String nombre;
	 String dni;
	 String rol;

	public Persona(int id, String nombre, String dni, String rol) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", rol=" + rol + "]";
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public String getRol() {
		return rol;
	}
	
	public String toCSV() {
	    return id + ", " + nombre + ", " + dni + ", " + rol;
	}

}
