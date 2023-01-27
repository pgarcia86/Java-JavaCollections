package s1_03_n3_pablogarciabarros;

public class Persona {

	private String nombre;
	private String apellido;
	private final String DNI;
	
	public Persona(String nombre, String apellido, String DNI) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.DNI = DNI;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public String getDNI() {
		return this.DNI;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + " - Apellido: " + this.apellido + " - DNI: " + this.DNI;
	}
	
}
