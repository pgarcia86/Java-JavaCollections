package s1_03_n3_pablogarciabarros;

import java.util.Comparator;

public class ComparadorNombre implements Comparator<Persona>{
	
	public int compare(Persona persona1, Persona persona2) {
		
			if(persona1.getNombre().compareToIgnoreCase(persona2.getNombre()) > 0) {
				return 1;
			}
			else if(persona1.getNombre().compareToIgnoreCase(persona2.getNombre()) < 0) {
				return -1;
			}
			else {
				return 0;
			}
		}
	}

