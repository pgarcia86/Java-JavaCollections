package s1_03_n3_pablogarciabarros;

import java.util.Comparator;

public class ComparadorDni implements Comparator<Persona>{
	
	public int compare(Persona persona1, Persona persona2) {
		
		if(persona1.getDNI().compareToIgnoreCase(persona2.getDNI()) > 0) {
			return 1;
		}
		else if(persona1.getDNI().compareToIgnoreCase(persona2.getDNI()) < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}

}
