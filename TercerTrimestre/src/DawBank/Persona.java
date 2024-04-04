package DawBank;

public class Persona {

	private String nombre;
	private String apellidos;
	private String dni;
	private int edad;
	
	public Persona(String nombreT, String apellidosT, String dniT, int edadT) {
		this.nombre = nombreT;
		this.apellidos = apellidosT;
		this.dni = dniT;
		this.edad = edadT;
	}
	
	public void imprimir() {
		System.out.println("*** Info Persona **** ");
		System.out.println("	Nombre: " + nombre);
		System.out.println("	Apellidos: " + apellidos);
		System.out.println("	DNI: " + dni);
		System.out.println("	Edad: " + edad);
		
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
}
