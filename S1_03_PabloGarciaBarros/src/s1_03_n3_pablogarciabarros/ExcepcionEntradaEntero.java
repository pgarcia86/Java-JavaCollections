package s1_03_n3_pablogarciabarros;

import java.util.InputMismatchException;

public class ExcepcionEntradaEntero extends InputMismatchException{
	
	private String mensaje;
	
	public ExcepcionEntradaEntero(String mensaje) {
		super(mensaje);
	}

}
