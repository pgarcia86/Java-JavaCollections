package s1_03_n2_ex2_pablogarciabarros;

import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Restaurante> restaurantes = new HashSet<Restaurante>();
		
		restaurantes.add(new Restaurante("Papa",8));
		restaurantes.add(new Restaurante("Papa",9));
		restaurantes.add(new Restaurante("Pepe",8));
		restaurantes.add(new Restaurante("Papi",3));
		restaurantes.add(new Restaurante("Pepa",4));
		restaurantes.add(new Restaurante("Pepa",7));
		restaurantes.add(new Restaurante("Pipo",5));
		restaurantes.add(new Restaurante("Pipo",7));
		restaurantes.add(new Restaurante("Papa",10));
		restaurantes.add(new Restaurante("Papas",8));
		
		
		//TreeSet es un Set ordenado. Si en la clase Restaurante implemento el metodo compareTo con las condiciones que
		//necesito, ordena el TreeSet.
		TreeSet<Restaurante> restaurantesOrdenados = new TreeSet<Restaurante>(restaurantes);
		
		Iterator<Restaurante> it = restaurantesOrdenados.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}
