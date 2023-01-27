package s1_03_n3_pablogarciabarros;

import java.util.Comparator;

public class ComparadorApellido implements Comparator<Persona>{
	
	public int compare(Persona persona1, Persona persona2) {

		if(persona1.getApellido().compareToIgnoreCase(persona2.getApellido()) > 0) {
			return 1;
		}
		else if(persona1.getApellido().compareToIgnoreCase(persona2.getApellido()) < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
