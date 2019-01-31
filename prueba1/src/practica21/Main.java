package practica21;

import java.util.ArrayList;
import java.util.Scanner;

import Practica2.Empleado;
import Practica2.Jefe;

public class Main {
	
	static Coche c = new Coche("1234TF",4,4,"SKODA", true); //String mat, int puertas, int ruedas, String modelo, boolean air
	static CocheDeportivo d = new CocheDeportivo("9876TF",4,4,"LEXUS","130CV",230); //String mat, int puertas, int ruedas, String modelo, String motor, int velocidadmax
	static Coche c1 = new Coche("5678TF",4,4,"RENAULT", true); //String mat, int puertas, int ruedas, String modelo, boolean air
	static CocheDeportivo d1 = new CocheDeportivo("9101TF",4,4,"FERRARI","190CV",230); //String mat, int puertas, int ruedas, String modelo, String motor, int velocidadmax
	
	
	static ArrayList<Object> Listacoches = new ArrayList<Object>();
	static Integer opc = 0;
	
	
	
	public static void main(String[] args)    {
		 while (opc<5) {
			 	Scanner reader = new Scanner(System.in);
			 	System.out.println("1) Añadir nuevo vehiculo");
			 	System.out.println("2) Modificar vehiculo");
			 	System.out.println("3) Eliminar vehiculo");
			 	System.out.println("4) Mostrar vehiculo");
			 	
			 
				opc = reader.nextInt();
								
				switch (opc) {
				
				case 1:
					System.out.println("Ha escogido añadir un nuevo vehiculo");
					anadir_vehiculo();
					break;
				case 2:
					System.out.println("Ha escogido Modificar un vehiculo");
					modificar_vehiculo();
					break;
				case 3:
					System.out.println("Ha escogido borrar un vehiculo");
					borrar_vehiculo();
					break;
				case 4:
					System.out.println("Mostrar Vehiculos");
					mostrar_vehiculo();
					break;
				
				default: System.out.println("Ha salido del programa");
					break;
				}
			 }
		
	}
	
	public static void anadir_vehiculo() {
	
		Integer opc1 = 0;
		Scanner reader1 = new Scanner(System.in);
		
		System.out.println("1) Añadir Coche");
	 	System.out.println("2) Añadir Coche deportivo");
	 	
		Listacoches.add(c);
	 	Listacoches.add(d);
	 	Listacoches.add(c1);
	 	Listacoches.add(d1);
	 	
		opc1 = reader1.nextInt();
						
		switch (opc1) {
			
			case 1:
				System.out.println("Ha escogido añadir un coche");
				anadir_coche();
				break;
			case 2:
				System.out.println("Ha escogido añadir un coche deportivo");
				anadir_coche_deportivo();
				break;
			default: System.out.println("Ha salido del programa ya que esa opcion no existe");
			break;
		}
		
	}
	
	
	public static void anadir_coche() {
		
		 //String mat, int puertas, int ruedas, String modelo, boolean air
		 String mat;
		 int puertas;
		 int ruedas;
		 String modelop = "";
		 boolean airbag;
		 
		 Scanner reader = new Scanner(System.in);
		
		 Coche nuevo;
		 
			//Pedimos datos
			System.out.println("Introduzca la matricula");
			mat = reader.nextLine();
			System.out.println("Introduzca el modelo");
			modelop = reader.nextLine();
			System.out.println("Introduzca el numero de puertas");
			puertas = reader.nextInt();
			System.out.println("Introduzca el numero de ruedas");
			ruedas = reader.nextInt();
			System.out.println("Introduzca si tiene airbag o no(TRUE OR FALSE)");
			airbag = reader.nextBoolean();
		 
			nuevo = new Coche(mat,puertas,ruedas, modelop, airbag);
			
			Listacoches.add(nuevo);
	}
	
	public static void anadir_coche_deportivo() {
		//String mat, int puertas, int ruedas, String modelo, String motor, int velocidadmax
		
		 String mat;
		 int puertas;
		 int ruedas;
		 String modelop = "";
		 String motor;
		 int velocidadmax;
		 
		 Scanner reader = new Scanner(System.in);
		
		 CocheDeportivo nuevo;
		 
			//Pedimos datos
			System.out.println("Introduzca la matricula");
			mat = reader.nextLine();
			System.out.println("Introduzca el modelo");
			modelop = reader.nextLine();
			System.out.println("Introduzca la capacidad del motor");
			motor = reader.nextLine();
			System.out.println("Introduzca el numero de puertas");
			puertas = reader.nextInt();
			System.out.println("Introduzca el numero de ruedas");
			ruedas = reader.nextInt();
			
			System.out.println("Introduzca la velocidad maxima");
			velocidadmax = reader.nextInt();
			
			nuevo = new CocheDeportivo(mat,puertas,ruedas, modelop, motor, velocidadmax);
			Listacoches.add(nuevo);
	}
	
	public static void borrar_vehiculo() {
		 
		 Coche c = new Coche();
		 CocheDeportivo d = new CocheDeportivo();
		 
		 String mat;
		 String listamat;
		 Scanner reader = new Scanner(System.in);
			
			//Pedimos datos
			System.out.println("Introduzca la Matricula a eliminar");
			mat = reader.nextLine();
			
			for(int i=0; i < Listacoches.size();++i) {
				 if(Listacoches.get(i) instanceof Coche) {
					 listamat = ((Coche) Listacoches.get(i)).getMatricula();
				 }else {
					 listamat = ((CocheDeportivo) Listacoches.get(i)).getMatricula();	
				 }
				 if(mat.equals(listamat)) {
						Listacoches.remove(i);
					}
			}
			 
			
	}
	
	public static void mostrar_vehiculo() {
		// Obtenemos un Iterador y recorremos la lista.
		
		for(int i=0; i < Listacoches.size();++i) {
			System.out.println("Vehiculo:" + i);
			 if(Listacoches.get(i) instanceof Coche) {
				//String mat, int puertas, int ruedas, String modelo, boolean air
				 System.out.println("Es de tipo: "+ Listacoches.get(i).getClass().getSimpleName() );
				 System.out.println("Matricula: "+ ((Coche) Listacoches.get(i)).getMatricula());
				 System.out.println("Puertas: "+ ((Coche) Listacoches.get(i)).getNoPuertas());
				 System.out.println("Ruedas: "+ ((Coche) Listacoches.get(i)).getNoRuedas());
				 System.out.println("modelo: "+ ((Coche) Listacoches.get(i)).getModelo());
			
				 System.out.println("\n");
			 }else {
				//String mat, int puertas, int ruedas, String modelo, String motor, int velocidadmax
				 System.out.println("Es de tipo: "+ Listacoches.get(i).getClass().getSimpleName() );
				 System.out.println("Matricula: "+ ((CocheDeportivo) Listacoches.get(i)).getMatricula());
				 System.out.println("Puertas: "+ ((CocheDeportivo) Listacoches.get(i)).getNoPuertas());
				 System.out.println("Ruedas: "+ ((CocheDeportivo) Listacoches.get(i)).getNoRuedas());
				 System.out.println("Max velocidad: "+ ((CocheDeportivo) Listacoches.get(i)).getMaxVelocidad());
				 System.out.println("Motor: "+ ((CocheDeportivo) Listacoches.get(i)).getCapacidadMotor());
				 System.out.println("modelo :"+ ((CocheDeportivo) Listacoches.get(i)).getModelo());
				 
				 System.out.println("\n");
			 }
		}
	}
	
	public static void modificar_vehiculo() {
		
		 
		 String mat;
		 String modelo;
		 String listamat;
		 Object x;
		 
		 Scanner reader = new Scanner(System.in);
			
			//Pedimos datos
			System.out.println("Introduzca la Matricula del coche a modificar");
			mat = reader.nextLine();
			
			for(int i=0; i < Listacoches.size();++i) {
				 if(Listacoches.get(i) instanceof Coche) {
					 listamat = ((Coche) Listacoches.get(i)).getMatricula();
					 x = (Coche) Listacoches.get(i);
				 }else {
					 listamat = ((CocheDeportivo) Listacoches.get(i)).getMatricula();	
					 x = (CocheDeportivo) Listacoches.get(i);
				 }
				 if(mat.equals(listamat)) {
					 if(x instanceof Coche) {
						 System.out.println("Introduzca el nuevo modelo del coche");
							modelo = reader.nextLine();
						 ((Coche) x).setModelo(modelo);
					 }else {
						 System.out.println("Introduzca el nuevo modelo del coche");
							modelo = reader.nextLine();
						 ((CocheDeportivo) x).setModelo(modelo);
					 }
					}
			}
	}
}
