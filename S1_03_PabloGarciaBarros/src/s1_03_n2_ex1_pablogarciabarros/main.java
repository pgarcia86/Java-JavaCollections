package s1_03_n2_ex1_pablogarciabarros;

import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Restaurante> restaurantes = new HashSet<Restaurante>();
		
		restaurantes.add(new Restaurante("Papa",5));
		restaurantes.add(new Restaurante("Papa",7));
		restaurantes.add(new Restaurante("Pepe",9));
		restaurantes.add(new Restaurante("Papa",5));
		restaurantes.add(new Restaurante("Pepe",9));
		
		Iterator<Restaurante> it = restaurantes.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
	}
}
