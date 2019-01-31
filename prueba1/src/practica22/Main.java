package practica22;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import Persona.Persona;
import practica21.Coche;

public class Main {
	
	
	private static ArrayList<Vuelos> Listavuelos = new ArrayList<Vuelos>();
	static String[]x;
	static Integer opc = 0;
	
	
	
	public static void main(String[] args)    {
		
		leer_fichero();//Leemos datos de fichero
		
		while (opc<7) {
			
		 	Scanner reader = new Scanner(System.in);
		 	System.out.println("1) Vuelos que se puede hacer trasbordo");
		 	System.out.println("2) Hora que mas persona habra en la terminal");
		 	System.out.println("3) Listado de vuelos de llegada");
		 	System.out.println("4) Listado de vuelos de salida");
		 	System.out.println("5) Mostrar panel");
		 	System.out.println("6) Añadir vuelos");
		 	
		 	
		 
			opc = reader.nextInt();
							
			switch (opc) {
			
			case 1:
				System.out.println("Ha escogido vuelos con trasbordo");
					trasbordo();
				break;
			case 2:
				System.out.println("Ha escogido hora que habra mas personas en la terminal");
			
				break;
			case 3:
				System.out.println("Vuelos de LLegada");
				llegada();
				break;
			case 4:
				System.out.println("Vuelos de salida");
				salida();
				break;
			
			case 5:
				System.out.println("Mostrar Panel de vuelos");
				mostrar_panel();
				break;
			case 6:
				System.out.println("Añadir nuevo vuelo al fichero");
				anadir_vuelo();
				break;
				
			default: System.out.println("Ha salido del programa");
				break;
			}
		 }
	
	}
	
	public static void anadir_vuelo() {
		 //String mat, int puertas, int ruedas, String modelo, boolean air
		String numero;
		String origen;
		String hsalida; 
		String destino;
		String hllegada;
		 
		 Scanner reader = new Scanner(System.in);
		
		 Vuelos nuevo;
		 
			//Pedimos datos
			System.out.println("Introduzca el numero de vuelo");
			numero = reader.nextLine();
			System.out.println("Introduzca el origen del vuelo");
			origen = reader.nextLine();
			System.out.println("Introduzca la hora de salida");
			hsalida = reader.nextLine();
			System.out.println("Introduzca el destino");
			destino = reader.nextLine();
			System.out.println("Introduzca la hora de llegada");
			hllegada = reader.nextLine();
		 
			nuevo = new Vuelos(numero,origen,hsalida, destino, hllegada);
			
			Listavuelos.add(nuevo);
			escritura_vuelo();
	}
	
	public static void escritura_vuelo() {
		String ruta = "C:\\Users\\Usuario\\Desktop\\vuelos.txt";
		FileWriter fichero = null;
		try {
			
			File f = new File(ruta);
		    fichero = new FileWriter(f);
		    BufferedWriter espacio = new BufferedWriter(fichero);
		    PrintWriter escritura = new PrintWriter(fichero);

		    for (Vuelos linea : Listavuelos) {
				fichero.write(linea.getNum_vuelo()+";");
				fichero.write(linea.getOrigen()+";");
				fichero.write(linea.getH_salida()+";");
				fichero.write(linea.getDestino()+";");
				fichero.write(linea.getH_llegada());
				escritura.println();
			}

			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}
	}
	
	public static void trasbordo() {
		
		Scanner reader = new Scanner(System.in);
		String[] Hora_llegada;
		String[] Hora_salida;
		Integer h_llegada, m_llegada, h_salida, m_salida;
		String numero;
		
		
		
		System.out.println("Introduzca el numero de vuelo");
		numero = reader.nextLine();

		
		
		for(int i=0; i < Listavuelos.size(); ++i) {
			if(numero.equals(Listavuelos.get(i).getNum_vuelo())) {
				
				
				Hora_salida = Listavuelos.get(i).getH_salida().split(":");
				Hora_llegada = Listavuelos.get(i).getH_llegada().split(":");
				
				h_llegada = Integer.parseInt(Hora_llegada[0]);
				m_llegada = Integer.parseInt(Hora_llegada[1]);
				
				h_llegada = h_llegada * 3600;
				m_llegada = m_llegada * 60;
				
				if(Listavuelos.get(i).getDestino().equals(Listavuelos.get(i).getOrigen())) {
					
				}
				
				
			}
			
		
			
		}
		
	}
	
	public static void llegada() {
		for(int i=0; i < Listavuelos.size();++i) {
			System.out.println("Vuelo:" + i);
			System.out.println("Numero de vuelo:" + Listavuelos.get(i).getNum_vuelo());
			System.out.println("Destino:" + Listavuelos.get(i).getDestino());
			System.out.println("Hora de LLegada:" + Listavuelos.get(i).getH_llegada());
			System.out.println("\t");
		}
	}
	
	public static void salida() {
		for(int i=0; i < Listavuelos.size();++i) {
			System.out.println("Vuelo:" + i);
			System.out.println("Numero de vuelo:" + Listavuelos.get(i).getNum_vuelo());
			System.out.println("Origen:" + Listavuelos.get(i).getOrigen());
			System.out.println("Hora de salida:" + Listavuelos.get(i).getH_salida());
			System.out.println("\n");
		}
	}
	
	public static void mostrar_panel() {
		for(int i=0; i < Listavuelos.size();++i) {
			System.out.println("Vuelo:" + i);
			System.out.println("Numero de vuelo:" + Listavuelos.get(i).getNum_vuelo());
			System.out.println("Origen:" + Listavuelos.get(i).getOrigen());
			System.out.println("Hora de salida:" + Listavuelos.get(i).getH_salida());
			System.out.println("Destino:" + Listavuelos.get(i).getDestino());
			System.out.println("Hora de LLegada:" + Listavuelos.get(i).getH_llegada());
			System.out.println("\n");
		}
	}
	
	public static void leer_fichero() {
		String fichero = "";	
		try {
		      FileReader fr = new FileReader("C:\\Users\\Usuario\\Desktop\\vuelos.txt");
		      BufferedReader br = new BufferedReader(fr);
		 
		      String linea;
		  
		      while((linea = br.readLine()) != null) {
		    	  Vuelos v = new Vuelos();
		    	  x = linea.split(";"); //guardamos en el array
		    	  v.setNum_vuelo(x[0]);
		    	  v.setOrigen(x[1]);
		    	  v.setH_salida(x[2]);
		    	  v.setDestino(x[3]);
		    	  v.setH_llegada(x[4]);
		    	  Listavuelos.add(v);
		        //System.out.println(linea);
		      }
		      fr.close();
		    }
		    catch(Exception e) {
		      System.out.println("Excepcion leyendo fichero "+ fichero + ": " + e);
		    }
	}
}
