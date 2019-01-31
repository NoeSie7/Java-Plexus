package Practica2;

import java.util.ArrayList;
import java.util.Scanner;

import Persona.Persona;

public class Main {
		
	static ArrayList<Jefe> Listajefes = new ArrayList<Jefe>();
	static ArrayList<Empleado> Listaempleados = new ArrayList<Empleado>();
	static Integer opc = 0;
	static Empleado e = new Empleado("1234567G","Pablo Escobar",22, "Desarrollador", "Informatica");
	static Empleado e1 = new Empleado("987654L","Luis Cantinflas",34, "Administrador", "Informatica");
	static Empleado e2 = new Empleado("9434554L","Pepe Pepon",38, "Desarrollador", "Informatica");
	static Jefe j = new Jefe("121212P","Jacobo Rodicio",45, 1234.8D, e);
	static Jefe j1 = new Jefe("989898T","Juanito Pescanova",52, 2134.7,e1);
	
	
	
	
	

	 public static void main(String[] args)    {
		 while (opc<7) {
		 	Scanner reader = new Scanner(System.in);
		 	System.out.println("1) Añadir empleado");
		 	System.out.println("2) Añadir Jefe");
		 	System.out.println("3) Buscar empleados");
		 	System.out.println("4) Buscar empleados por departamento");
		 	System.out.println("5) Borrar empleado ");
		 	System.out.println("6) Mostrar empleados con su respectivo jefe ");
			System.out.println("Introduzca una opción");
			opc = reader.nextInt();
			
			//empleados ejemplo
			Listaempleados.add(e);
			Listaempleados.add(e1);
			//jefes ejemplo
			Listajefes.add(j);
			Listajefes.add(j1);
			
			switch (opc) {
			
			case 1:
				System.out.println("Ha escogido añadir empleado");
				anadir_empleado();
				break;
			case 2:
				System.out.println("Ha escogido añadir Jefe");
				anadir_jefe();
				break;
			case 3:
				System.out.println("Ha escogido buscar empleados");
				buscar_empleado();
				break;
			case 4:
				System.out.println("Ha escogido buscar empleados por departamento");
				buscar_empleado_departamento();
				break;
			case 5:
				System.out.println("Ha escogido borrar empleado");
				borrar_empleado();
				break;
			case 6:
				System.out.println("Ha escogido mostrar empleado jefe");
				mostrar_empleado_jefe();
				break;
			default: System.out.println("Ha salido del programa");
				break;
			}
		 }
	 }
	 
	 public static void anadir_empleado() {
		 String dni;
		 String nombre;
		 Integer edad;
		 String puesto;
		 String departamento;
		 
		 Scanner reader = new Scanner(System.in);
		
		 Empleado nuevo;
		 

			//Pedimos datos
			System.out.println("Introduzca el DNI");
			dni = reader.nextLine();
			System.out.println("Introduzca su nombre y apellidos");
			nombre = reader.nextLine();
			System.out.println("Introduzca su edad");
			edad = reader.nextInt();
			System.out.println("Introduzca su puesto");
			puesto = reader.nextLine();
			System.out.println("Introduzca su departamento");
			departamento = reader.nextLine();
		 
			nuevo = new Empleado(dni,nombre,edad, puesto, departamento);
			
			Listaempleados.add(nuevo);
	 }
	 
	 public static void anadir_jefe() {
		 String dni;
		 String nombre;
		 Integer edad;
		 Double salario;
		 
		 Scanner reader = new Scanner(System.in);
		
		 Jefe nuevo;
		 

			//Pedimos datos
			System.out.println("Introduzca el DNI");
			dni = reader.nextLine();
			System.out.println("Introduzca su nombre y apellidos");
			nombre = reader.nextLine();
			System.out.println("Introduzca su edad");
			edad = reader.nextInt();
			System.out.println("Introduzca su salario");
			salario = reader.nextDouble();
			
			nuevo = new Jefe(dni,nombre,edad, salario,e2);
			
			Listajefes.add(nuevo);
	 }
	 public static void buscar_empleado() {
		 String dni;
		 Scanner reader = new Scanner(System.in);
		
			//Pedimos datos
			System.out.println("Introduzca el DNI");
			dni = reader.nextLine();
			for(int i = 0; i < Listaempleados.size(); ++i) {
				if( dni.equals (Listaempleados.get(i).get_dni()) ) {
					System.out.println(Listaempleados.get(i).get_dni());
					System.out.println("La Persona con ese DNI es la:" +i);
				}
			}
	 }
	 public static void buscar_empleado_departamento() {
		 String departamento;
		 Scanner reader = new Scanner(System.in);
		
			//Pedimos datos
			System.out.println("Introduzca el departamento a buscar");
			departamento = reader.nextLine();
			
			for(int i = 0; i < Listaempleados.size(); ++i) {
				if( departamento.equals (Listaempleados.get(i).get_departamento()) ) {
					System.out.println(Listaempleados.get(i).get_departamento());
					System.out.println("La Persona en ese departamento es la:" +i);
				}
			}
	 }
	 public static void borrar_empleado() {
		 
		 String dni;
		 Scanner reader = new Scanner(System.in);
			
			//Pedimos datos
			System.out.println("Introduzca el DNI a eliminar");
			dni = reader.nextLine();
			
		 for(int i = 0; i < Listaempleados.size(); ++i) {
				if(dni.equals(Listaempleados.get(i).get_dni())) {
					Listaempleados.remove(i);
				}
			}
	 }
	 
	 public static void mostrar_empleado_jefe() {
		 j.set_empleados(e2);
		 j.mostrar_empleados_jefe();
		 
	 }
	 

	 
}
