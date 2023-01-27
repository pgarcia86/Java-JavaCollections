package s1_03_n3_pablogarciabarros;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class main {
	
	static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombreArchivo = "C:/Users/pgarc/eclipse-workspace/S1_03_PabloGarciaBarros/src/s1_03_n3_pablogarciabarros/personas.csv";
		String lectura = null;
		final String SEPARADOR = ",";
		ArrayList<Persona> personas = new ArrayList<Persona>();		
	/*	
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			archivo = new File(nombreArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			lectura = br.readLine();
		
			while(lectura != null) {
				String[] datosPersonas = lectura.split(SEPARADOR);				
				personas.add(new Persona(datosPersonas[0], datosPersonas[1], datosPersonas[2]));
				lectura = br.readLine();
			}		
		}
		catch(Exception e) {
			e.getMessage();
		}
		finally {
			try {
				br.close();
			}
			catch(Exception e) {
				e.getMessage();
			}
		}		
		*/
		personas = abrirArchivo(nombreArchivo, personas);
		iniciar(personas, nombreArchivo);		
	}
	
	public static void iniciar(ArrayList<Persona> personas, String nombreArchivo) {		
		
		int opcion;
		
		do {
			opcion = menu();
			
			switch(opcion) {			
				case 1:
					ingresarPersona(personas, nombreArchivo);
					break;
				case 2:
					ordenarNombreAZ(personas);
					break;
				case 3:
					ordenarNombreZA(personas);
					break;
				case 4:
					ordenarApellidoAZ(personas);
					break;
				case 5:
					ordenarApellidoZA(personas);
					break;
				case 6:
					ordenarDni19(personas);
					break;
				case 7:
					ordenarDni91(personas);
					break;
				case 0:
					break;
				default:
					break;
			}
		}while(opcion != 0);		
	}
	
	public static int menu() {
		
		int opcion = 0;
		
		do {		
		System.out.println("Ingrese la opcion deseada: " + 
			"\n1. Ingresar persona" +
			"\n2. Ordenar personas por nombre (A-Z)" +
			"\n3. Ordenar personas por nombre (Z-A)" +
			"\n4. Ordenar personas por apellido (A-Z)" +
			"\n5. Ordenar personas por apellido (Z-A)" +
			"\n6. Ordenar personas por DNI (1-9)" +
			"\n7. Ordenar personas por DNI (9-1)" + 
			"\n0. Salir");
		opcion = leerInt();
		
		return opcion;
		
		}while(true);			
	}
	
	public static ArrayList<Persona> abrirArchivo(String nombreArchivo, ArrayList<Persona> personas) {
				
		String lectura;
		final String SEPARADOR = ",";
		
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			archivo = new File(nombreArchivo);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			lectura = br.readLine();
		
			while(lectura != null) {
				String[] datosPersonas = lectura.split(SEPARADOR);				
				personas.add(new Persona(datosPersonas[0], datosPersonas[1], datosPersonas[2]));
				lectura = br.readLine();
			}		
		}
		catch(Exception e) {
			e.getMessage();
		}
		finally {
			try {
				br.close();
			}
			catch(Exception e) {
				e.getMessage();
			}
		}
		
		return personas;
	}
	
	
	public static void ingresarPersona(ArrayList<Persona> personas, String nombreArchivo) {
		System.out.println("Ingrese el nombre de la persona");
		String nombre = introducirNombreApellido();
		System.out.println("Ingrese el apellido de la persona");
		String apellido = introducirNombreApellido();
		System.out.println("Ingrese el DNI de la persona");
		String dni = entrada.next();
		
		Persona personaNueva = new Persona(nombre, apellido, dni);
		
		personas.add(personaNueva);
		
		escribirArchivo(nombre, apellido, dni, nombreArchivo);
		
	}
	
	public static void escribirArchivo(String nombre, String apellido, String dni, String nombreArchivo) {
		
		File archivoEscribir = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			archivoEscribir = new File(nombreArchivo);
			fw = new FileWriter(archivoEscribir, true);
			bw = new BufferedWriter(fw);
			bw.write(nombre + "," + apellido + "," + dni);
			bw.newLine();
			bw.flush();
		}
		catch (Exception e){
			e.getMessage();
		}
		finally {
			try {
				bw.close();
			}
			catch(Exception e) {
				e.getMessage();
			}
		}
		
	}
	
	public static String introducirNombreApellido(){
			
		String nombreApellido = "";
		boolean flag = false;
			
		do {				
			try {
				nombreApellido = chequeoEntradaNombrePersona();
				flag = true;				
			}
			catch(ExcepcionNombrePersonaIncorrecto enpi) {
				System.out.println(enpi.getMessage());
			}			
		}while(flag == false);
			
		return nombreApellido;
	}
	
	public static String chequeoEntradaNombrePersona() throws ExcepcionNombrePersonaIncorrecto{
		
		String nombreApellido;
		
		nombreApellido = entrada.nextLine();
				
		if(nombreApellido.matches(".*[0-9].*")) {
			throw new ExcepcionNombrePersonaIncorrecto("EL NOMBRE NO PUEDE CONTENER NUMEROS. INTENTELO NUEVAMENTE");
		}
		else {
			return nombreApellido;
		}
		
	}

	public static int leerInt(){
		
		int entradaInt = 0;
		boolean flag = false;
		
		do {
			try {
				entradaInt = chequeoInt();
				flag = true;
			}
			catch(ExcepcionEntradaEntero ei) {
				entrada.next();
				System.out.println(ei.getMessage());
				flag = false;
			}
			
		}while(flag == false);	
		
		entrada.nextLine();
		
		return entradaInt;				
	}
	
	public static int chequeoInt() throws ExcepcionEntradaEntero{
		
		int entradaInt;
		
		if(entrada.hasNextInt() ) {
			return entradaInt = entrada.nextInt();
		}
		else {
			throw new ExcepcionEntradaEntero("No ingreso un entero. Intentalo Nuevamente");
		}
	}

	public static void ordenarNombreAZ(ArrayList<Persona> personas) {
		
		Collections.sort(personas, new ComparadorNombre());
		
		for(Persona persona : personas) {
			System.out.println(persona.toString());
		}		
	}
	
	public static void ordenarNombreZA(ArrayList<Persona> personas) {
		
		Collections.sort(personas, new ComparadorNombre());
		Collections.reverse(personas);
		
		for(Persona persona : personas) {
			System.out.println(persona.toString());
		}
	}
	
	public static void ordenarApellidoAZ(ArrayList<Persona> personas) {
		
		Collections.sort(personas, new ComparadorApellido());
		
		for(Persona persona : personas) {
			System.out.println(persona.toString());
		}
		
	}
	
	public static void ordenarApellidoZA(ArrayList<Persona> personas) {
		
		Collections.sort(personas, new ComparadorApellido());
		Collections.reverse(personas);
		
		for(Persona persona : personas) {
			System.out.println(persona.toString());
		}
	}

	public static void ordenarDni19(ArrayList<Persona> personas) {
		
		Collections.sort(personas, new ComparadorDni());
		
		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}
	}
	
	public static void ordenarDni91(ArrayList<Persona> personas) {
		
		Collections.sort(personas, new ComparadorDni());
		Collections.reverse(personas);
		
		for (Persona persona : personas) {
			System.out.println(persona.toString());
		}		
	}
}
