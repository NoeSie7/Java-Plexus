package es.plexus.cedei.vuelos.vuelos;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main {
	
	
	private static ArrayList<Vuelos> Listavuelos = new ArrayList<Vuelos>();
	static String[]x;
	static Integer opc = 0;
	static SimpleDateFormat format = new SimpleDateFormat("HH:mm");
	
	
	
	public static void main(String[] args) throws ParseException    {
		
		leer_fichero();//Leemos datos de fichero
		
		while (opc<7) {
			
		 	Scanner reader = new Scanner(System.in);
		 	System.out.println("1) Vuelos que se puede hacer trasbordo");
		 	System.out.println("2) Hora que mas persona habra en la terminal");
		 	System.out.println("3) Listado de vuelos de llegada");
		 	System.out.println("4) Listado de vuelos de salida");
		 	System.out.println("5) Mostrar panel");
		 	System.out.println("6) A�adir vuelos");
		 	
		 	
		 
			opc = reader.nextInt();
							
			switch (opc) {
			
			case 1:
				System.out.println("Ha escogido vuelos con trasbordo");
					trasbordo();
				break;
			case 2:
				System.out.println("Ha escogido hora que habra mas personas en la terminal");
					hora_mas();
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
				System.out.println("A�adir nuevo vuelo al fichero");
				anadir_vuelo();
				break;
				
			default: System.out.println("Ha salido del programa");
				break;
			}
		 }
	
	}
	
	public static void anadir_vuelo() throws ParseException {
		 //String mat, int puertas, int ruedas, String modelo, boolean air
		String numero;
		String origen;
		String hsalida; 
		String destino;
		String hllegada;
		Date hs;
		Date hll;
		 
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
		 
			hs=format.parse(hsalida);
			hll=format.parse(hllegada);
			
			nuevo = new Vuelos(numero,origen, destino,hs,hll);
			
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
				fichero.write(linea.getHsalida()+";");
				fichero.write(linea.getDestino()+";");
				fichero.write(linea.getHllegada().toString());
				escritura.println();
			}

			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepci�n: " + ex.getMessage());
		}
	}
	
	public static void trasbordo() {
		
		ArrayList<Vuelos> copia = new ArrayList <Vuelos>(Listavuelos);
		Date aux, aux1;
		Vuelos v = new Vuelos();
		Boolean result;
		
		for(int i = 0 ; i < Listavuelos.size(); ++i) {
			for(int j = 0; j < copia.size(); ++j) {
				aux = Listavuelos.get(i).getHllegada();
				aux1 = copia.get(j).getHsalida();
				result = v.evaluarLimite(aux, aux1);
				//System.out.println("Hora llegada: " + aux + " Hora de salida: "+  aux1 + " Valor funcion: " + result) ;
				
				if(Listavuelos.get(i).getDestino().equals(copia.get(j).getOrigen()) && (result == true )) {
					System.out.println("vuelo con trasbordo: " + copia.get(j).getNum_vuelo() );
					System.out.println("vuelo con Destino: " + Listavuelos.get(i).getDestino() + " puede hacer trasbordo de: "+ copia.get(j).getOrigen() + " a " + copia.get(j).getDestino()+ " a las: "+ copia.get(j).getHsalida());
				}else {
					//System.out.println("No hay " + copia.get(j).getNum_vuelo() );
				}
			}
		}
	}
	
	public static void hora_mas() {
		ArrayList<Vuelos> copia = new ArrayList <Vuelos>(Listavuelos);
		Date aux, aux1;
		Vuelos v = new Vuelos();
		Boolean result;
		
		for(int i = 0 ; i < Listavuelos.size(); ++i) {
			for(int j = 0; j < copia.size(); ++j) {
				aux = Listavuelos.get(i).getHllegada();
				aux1 = copia.get(j).getHsalida();
				result = v.evaluarLimite(aux, aux1);
				//System.out.println("Hora llegada: " + aux + " Hora de salida: "+  aux1 + " Valor funcion: " + result) ;
				
				if(Listavuelos.get(i).getDestino().equals(copia.get(j).getOrigen()) && (result == true )) {
					System.out.println("vuelo con trasbordo: " + copia.get(j).getNum_vuelo() );
					System.out.println("Entre las: "+ Listavuelos.get(i).getHsalida() +"y las: "+ copia.get(j).getHsalida()+" mayor numero de personas en la terminal de: " +  copia.get(j).getOrigen());
				}else {
					//System.out.println("No hay " + copia.get(j).getNum_vuelo() );
				}
			}
		}
	}
	
	
	public static void llegada() {
		for(int i=0; i < Listavuelos.size();++i) {
			System.out.println("Vuelo:" + i);
			System.out.println("Numero de vuelo:" + Listavuelos.get(i).getNum_vuelo());
			System.out.println("Destino:" + Listavuelos.get(i).getDestino());
			System.out.println("Hora de LLegada:" + Listavuelos.get(i).getHllegada());
			System.out.println("\t");
		}
	}
	
	public static void salida() {
		for(int i=0; i < Listavuelos.size();++i) {
			System.out.println("Vuelo:" + i);
			System.out.println("Numero de vuelo:" + Listavuelos.get(i).getNum_vuelo());
			System.out.println("Origen:" + Listavuelos.get(i).getOrigen());
			System.out.println("Hora de salida:" + Listavuelos.get(i).getHsalida());
			System.out.println("\n");
		}
	}
	
	public static void mostrar_panel() {
		for(int i=0; i < Listavuelos.size();++i) {
			System.out.println("Vuelo:" + i);
			Listavuelos.get(i).mostrar();
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
		    	  v.setDestino(x[3]);
		    	  v.setHsalida(format.parse(x[2]));
		    	  v.setHllegada(format.parse(x[4]));
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
