package s1_03_n2_ex1_pablogarciabarros;

import java.util.Objects;

public class Restaurante {
	
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
	public boolean equals(Object obj) {
		if(obj instanceof Restaurante) {
			Restaurante otroRestaurante = (Restaurante)obj;
			if(this.nombre.equalsIgnoreCase(otroRestaurante.getNombre()) && 
					(this.puntuacion == otroRestaurante.getPuntuacion())) {
				System.out.println("Son iguales. No se puede insertar");
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
	public String toString() {
		return "Nombre: " + this.nombre + " - Puntuacion: " + this.puntuacion;
	}

}
