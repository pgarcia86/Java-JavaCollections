package s1_03_n3_pablogarciabarros;

public class ExcepcionNombrePersonaIncorrecto extends Exception{
	
	private String mensaje;
	
	public ExcepcionNombrePersonaIncorrecto(String mensaje) {
		super(mensaje);
	}

}
