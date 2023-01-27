package s1_03_n1_ex1_pablogarciabarros;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Meses> mesesAnyo = new ArrayList<Meses>();
		
		mesesAnyo.add(new Meses("Enero"));
		mesesAnyo.add(new Meses("Febrero"));
		mesesAnyo.add(new Meses("Marzo"));
		mesesAnyo.add(new Meses("Abril"));
		mesesAnyo.add(new Meses("Mayo"));
		mesesAnyo.add(new Meses("Junio"));
		mesesAnyo.add(new Meses("Julio"));
		mesesAnyo.add(new Meses("Septiembre"));
		mesesAnyo.add(new Meses("Octubre"));
		mesesAnyo.add(new Meses("Noviembre"));
		mesesAnyo.add(new Meses("Diciembre"));
		
		for(int i = 0; i < mesesAnyo.size(); i++) {
			System.out.println(mesesAnyo.get(i).toString());
		}
		
		mesesAnyo.add(7, new Meses("Agosto"));
		System.out.println("\n\nAgrego el mes de Agosto. Mantiene la posicion de los demas meses");
		
		for(int i = 0; i < mesesAnyo.size(); i++) {
			System.out.println(mesesAnyo.get(i).toString());
		}
		
		System.out.println("\n\nConvieto el ArrayList en un HashSet y lo recorro con un iterador." +
				"\nComo HashSet no es una coleccion ordenada, los imprime sin ningun orden." +
				"\nSi sobreescribo los metodos equals y hashCode no admite valores duplicados");
		
		HashSet<Meses> hashMeses = new HashSet<Meses>(mesesAnyo);
		
		hashMeses.add(new Meses("Febrero"));
		
		Iterator<Meses> it = hashMeses.iterator();
		
		while(it.hasNext()) {
			String mesImprimir = it.next().getMes();
			System.out.println(mesImprimir);
		}
	}
}
