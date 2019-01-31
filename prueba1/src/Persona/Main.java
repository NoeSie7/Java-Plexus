package Persona;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Main {
		
	static ArrayList<Persona> Lista = new ArrayList<Persona>();
	static String dni;
	static String nombre;
	static Integer edad;
	
	
	 public static void main(String[] args) {
		 
		 	
		 	//Personas
		 	Persona p = new Persona("9876543J"," Pepe Cajal",41);
		 	Persona p1 = new Persona("3456789L","Juanito Cabrera",21);
		 	Persona p2 = new Persona("1234567K","Risto Mejide",43);
		 	Persona p3 = new Persona("1267469K","Lucas Perez",67);
		 	

		 	
		 	//Añadimos personas a la lista
		 	Lista.add(p1);
		 	Lista.add(p2);
		 	Lista.add(p);
		 	Lista.add(p3);
		 	
		 	//añadir persona a la lista
		 	anadir_persona();
		 	
		 	//mostrar lista
		 	recorrer_lista();
		 	
		 	//buscar dni
		 	//buscar_dni();
		 	
		 	//eliminar dni
		 	//eliminar_dni();
		 	//recorrer_lista();
		 	
		 	//creamos fichero
		 	crear_fichero();
		 		
		 	//Eliminamos dni fichero
		 	eliminar_dni_fichero();
	 }
	 
	 
	 public static void anadir_persona() {
		 
		 Scanner reader = new Scanner(System.in);
		 Scanner reader1 = new Scanner(System.in);
		 Scanner reader2 = new Scanner(System.in);
		 Persona nuevo;
		 

			//Pedimos datos
			System.out.println("Introduzca el DNI");
			dni = reader.nextLine();
			System.out.println("Introduzca su nombre y apellidos");
			nombre = reader.nextLine();
			System.out.println("Introduzca su edad");
			edad = reader.nextInt();
		 
			nuevo = new Persona(dni,nombre,edad);
			Lista.add(nuevo);
		 
	 }
	 
	 public static void recorrer_lista() {
			// Obtenemos un Iterador y recorremos la lista.
			for(int i=0; i < Lista.size();++i) {
				System.out.println("Persona:" + i);
				System.out.println("DNI:" + Lista.get(i).get_dni());
				System.out.println("Nombre y apellidos:" + Lista.get(i).get_nombreapel());
				System.out.println("Edad:" + Lista.get(i).get_edad());
				System.out.println("\n");
			}
	 }
	 
	 public static void buscar_dni() {
			
		 	Scanner reader = new Scanner(System.in);
			
			//Pedimos datos
			System.out.println("Introduzca el DNI a buscar");
			dni = reader.nextLine();
			System.out.println("El dni a buscar es:" + dni);
		 
			for(int i = 0; i < Lista.size(); ++i) {
				if( dni.equals (Lista.get(i).get_dni()) ) {
					System.out.println(Lista.get(i).get_dni());
					System.out.println("La Persona con ese DNI es la:" +i);
				}
			}
	 }
	 
	 public static void eliminar_dni() {
		 
		 Scanner reader = new Scanner(System.in);
			
			//Pedimos datos
			System.out.println("Introduzca el DNI a eliminar");
			dni = reader.nextLine();
			
		 for(int i = 0; i < Lista.size(); ++i) {
				if(dni.equals(Lista.get(i).get_dni())) {
					Lista.remove(i);
				}
			}
		 
	 }
	 
	 public static void crear_fichero() {
		 
		 
		 FileWriter fichero = null;
		 String ruta = "C:\\Users\\Usuario\\Desktop\\archivo1.txt";

			try {
				
				File f = new File(ruta);
			    fichero = new FileWriter(f);
			    BufferedWriter espacio = new BufferedWriter(fichero);
			    PrintWriter escritura = new PrintWriter(fichero);

			    for (Persona linea : Lista) {
					fichero.write(linea.get_dni()+";");
					fichero.write(linea.get_nombreapel()+";");
					fichero.write(linea.get_edad()+";");
					escritura.println();
				}

				fichero.close();

			} catch (Exception ex) {
				System.out.println("Mensaje de la excepción: " + ex.getMessage());
			}

	 }
	 
	 public static void eliminar_dni_fichero() {
		 Scanner reader = new Scanner(System.in);
			
			//Pedimos datos
			System.out.println("Introduzca el DNI a eliminar");
			dni = reader.nextLine();
			
		 for(int i = 0; i < Lista.size(); ++i) {
				if(dni.equals(Lista.get(i).get_dni())) {
					Lista.remove(i);
				}
			}
		 FileWriter fichero = null;
		 String ruta = "C:\\Users\\Usuario\\Desktop\\archivo1.txt";

			try {
				
				File f = new File(ruta);
			    fichero = new FileWriter(f);
			    BufferedWriter espacio = new BufferedWriter(fichero);
			    PrintWriter escritura = new PrintWriter(fichero);

			    for (Persona linea : Lista) {
					fichero.write(linea.get_dni()+";");
					fichero.write(linea.get_nombreapel()+";");
					fichero.write(linea.get_edad()+";");
					escritura.println();
				}

				fichero.close();

			} catch (Exception ex) {
				System.out.println("Mensaje de la excepción: " + ex.getMessage());
			}
	 }

}
