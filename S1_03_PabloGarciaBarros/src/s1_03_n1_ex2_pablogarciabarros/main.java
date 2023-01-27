package s1_03_n1_ex2_pablogarciabarros;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> lista = new ArrayList<Integer>();		
		List<Integer> listaInversa = new ArrayList<Integer>();
		
		lista.add(5);
		lista.add(4);
		lista.add(55);
		lista.add(93);
		lista.add(32);
		lista.add(17);
		lista.add(28);
		
		ListIterator<Integer> ite = lista.listIterator();
		
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		
		while(ite.hasPrevious()) {
			listaInversa.add(ite.previous());
		}
		
		ite = listaInversa.listIterator();
		System.out.println("\nLista inversa");
		
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
	}
}
