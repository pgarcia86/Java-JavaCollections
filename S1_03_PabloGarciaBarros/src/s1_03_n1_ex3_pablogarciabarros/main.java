package s1_03_n1_ex3_pablogarciabarros;

import java.io.*;
import java.util.*;

public class main {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nombreArchivoLectura = "C:/Users/pgarc/eclipse-workspace/S1_03_PabloGarciaBarros/src/s1_03_n1_ex2_pablogarciabarros/Countries.txt";
		String nombreArchivoEscritura = "C:/Users/pgarc/eclipse-workspace/S1_03_PabloGarciaBarros/src/s1_03_n1_ex2_pablogarciabarros/Puntajes.txt";
		String respuesta;
		String nombre;
		
		HashMap<String, String> hashPaises = new HashMap<String,String>();
		ArrayList<Integer> indices = new ArrayList<Integer>();
		ArrayList<String> paises = new ArrayList<String>();
		
		int indiceAleatorio = 0;
		int intentos = 10;
		int puntaje = 0;
		
		Scanner entrada = new Scanner(System.in);		
		
		File archivo = null;
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		leerArchivo(nombreArchivoLectura, archivo, fr, br, hashPaises);
		
		paises.addAll(hashPaises.keySet());
		
		System.out.println("Ingrese su nombre");
		nombre = entrada.nextLine();					

		puntaje = juego(intentos, entrada, indices, puntaje, paises, hashPaises);
		
		escribirArchivo(nombreArchivoEscritura, nombre, puntaje, archivo, fw, bw);
			
		System.out.println("Puntaje final: " + puntaje);
	}
	
	public static int juego(int intentos, Scanner entrada, ArrayList<Integer> indices, int puntaje, 
			ArrayList<String> paises, HashMap<String, String> hashPaises) {
	
		boolean flag = false;
		int indiceAleatorio;
		String respuesta;
		
		indiceAleatorio = (int)(Math.random()*(52));
		System.out.println("Adivine la capital de " + paises.get(indiceAleatorio));
			
		respuesta = entrada.next();
		puntaje = actualizarPuntaje(respuesta, paises, hashPaises, indiceAleatorio, puntaje);
		
		while(intentos != 1) {
			
			while(flag == false) {
		
				indiceAleatorio = (int)(Math.random()*52);
				if(indices.contains(indiceAleatorio)) {	
					flag = false;
				}
				else {
					indices.add(indiceAleatorio);
					System.out.println("Adivine la capital de " + paises.get(indiceAleatorio));
					respuesta = entrada.next();
					puntaje = actualizarPuntaje(respuesta, paises, hashPaises, indiceAleatorio, puntaje);
					flag = true;
				}
			}			
			intentos--;
			flag = false;
		}	
		return puntaje;
		
	}
	
	public static boolean chequeoRespuesta(String respuesta, ArrayList<String> paises, HashMap<String, String> hashPaises, int indiceAleatorio) {
		
		if(hashPaises.get(paises.get(indiceAleatorio)).equalsIgnoreCase(respuesta)) {
			return true;
		}
		else {
			return false;
		}	
	}
	
	public static int actualizarPuntaje(String respuesta, ArrayList<String> paises, 
			HashMap<String, String> hashPaises, int indiceAleatorio, int puntaje) {
		
		if(chequeoRespuesta(respuesta, paises, hashPaises, indiceAleatorio) == true) {
			System.out.println("Respuesta correcta");
			puntaje++;
		}
		else {
			System.out.println("Respuesta incorrecta - La capital es: " + hashPaises.get(paises.get(indiceAleatorio)));
		}
		return puntaje;
	}
	
	public static void leerArchivo(String nombreArchivoLectura, File archivo, FileReader fr, BufferedReader br, HashMap<String, String> hashPaises) {	
		try {
			archivo = new File(nombreArchivoLectura);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			
			String lectura = "";
			
			while(lectura != null) {
				lectura = br.readLine();
				hashPaises.put(lectura.substring(0, lectura.indexOf("\s")), lectura.substring(lectura.indexOf("\s")+1));
			}
		}
		catch(Exception e) {
			e.getMessage();
		}
		finally {
			try {
				br.close();
			}
			catch(Exception e){
				e.getMessage();
			}
		}
	}
		
	public static void escribirArchivo(String nombreArchivoEscritura, String nombre, int puntaje,
			File archivo, FileWriter fw, BufferedWriter bw) {
		
		try {
			archivo = new File(nombreArchivoEscritura);
			fw = new FileWriter(archivo,true);	//pasando el parametro true, sobreescribe el archivo
			bw = new BufferedWriter(fw);
			bw.write(nombre + " - Puntaje: " + puntaje);
			bw.newLine();
			bw.flush();
			
		}
		catch(Exception e){
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

}

