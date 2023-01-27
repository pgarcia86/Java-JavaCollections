package s1_03_n2_ex2_pablogarciabarros;

import java.util.Objects;

public class Restaurante implements Comparable<Restaurante>{
	
	private String nombre;
	private int puntuacion;
	
	public Restaurante(String nombre, int puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public int getPuntuacion() {
		return this.puntuacion;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + this.nombre + " - Puntuacion: " + this.puntuacion;
	}
	
	//Sobreescribo los metodos equals y hashCode para que no haya valores repetidos
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Restaurante) {
			Restaurante otroRestaurante = (Restaurante)obj;
			if((this.nombre.equalsIgnoreCase(otroRestaurante.getNombre())) && 
					(this.puntuacion == otroRestaurante.getPuntuacion())) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre, puntuacion);
	}
	
	@Override
	public int compareTo(Restaurante otroRestaurante) {
		if(this.nombre.compareToIgnoreCase(otroRestaurante.getNombre()) == 0) {	//Si los nombres son iguales, chequeo la puntuacion
			if(this.puntuacion > otroRestaurante.getPuntuacion()) {	//Si la puntuacion del restaurante es mayor que la del que paso por parametro, devuelvo -1
				return -1;
			}
			else {
				return 1;
			}
		}
		else if(this.nombre.compareToIgnoreCase(otroRestaurante.getNombre()) > 0) {	//Si el nombre del restaurante es mayor al que paso por parametro, devuelvo 1
			return 1;
		}
		else {
			return -1;
		}
	}

}
